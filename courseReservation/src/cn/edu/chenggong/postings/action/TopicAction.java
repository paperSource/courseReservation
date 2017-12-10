package cn.edu.chenggong.postings.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.chenggong.biz.impl.UsersBizImpl;
import cn.edu.chenggong.po.Users;
import cn.edu.chenggong.postings.model.Topic;
import cn.edu.chenggong.postings.service.Interface.ITopicSV;
import cn.edu.chenggong.util.SpringContextUtil;

@Controller
@RequestMapping("topicAction")
public class TopicAction {
	@Resource
	private ITopicSV topicSVImpl;
	public void setTopicSVImpl(ITopicSV topicSVImpl) {
		this.topicSVImpl = topicSVImpl;
	}
	public ITopicSV getTopicSVImpl() {
		return topicSVImpl;
	}
	@RequestMapping("addTopic")
	public void addTopic(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String topic_title = request.getParameter("title");
		String topic_content = request.getParameter("topic_content");
		Users user = (Users) session.getAttribute("users");
		String message = "发表成功";
		try{
			if(user!=null){
				Topic tp = new Topic();
				tp.setTitle(topic_title);
				tp.setContent(topic_content);
				tp.setTopicStarter(user.getId());
				tp.setClassify("0");
				tp.setBrowseNum(0);
				tp.setReplyNum(0);
				tp.setState(1);
				tp.setUpvote(0);
				topicSVImpl.add(tp);
			}else{
				message = "用户还未登陆，请登录!";
			}
		}catch (Exception e) {
			message = "发表失败，系统内部错误！";
			throw new RuntimeException("插入异常");
		}finally{
			out.print(message);
		}
	}
	@RequestMapping("query")
	public @ResponseBody Map<String, Object> queryList(HttpServletRequest request) throws Exception{
		int intPage = Integer.parseInt(request.getParameter("page"));
		int number = Integer.parseInt(request.getParameter("num"));
		UsersBizImpl biz = (UsersBizImpl) SpringContextUtil.getApplicationContext().getBean("usersBizImpl");
		int start = (intPage-1)*number;
		List<Topic> topicList = topicSVImpl.queryPag(start, number);
		System.out.println(topicList.size());
		for(int i=0;i<topicList.size();i++){
			topicList.get(i).setStaUsers(biz.findAllById(topicList.get(i).getTopicStarter()));
			topicList.get(i).setEndUsers(biz.findAllById(topicList.get(i).getEndUser()));
		}
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("total", topicSVImpl.queryList().size());
		map.put("topicList", topicList);
		return map;
	}
	@RequestMapping("detail")
	public ModelAndView detail(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("id"));
		ModelAndView ma = new ModelAndView();
		Topic topic = topicSVImpl.queryById(id);
		UsersBizImpl biz = (UsersBizImpl) SpringContextUtil.getApplicationContext().getBean("usersBizImpl");
		topic.setStaUsers(biz.findAllById(topic.getTopicStarter()));
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("users");
		int delPermission = 0;
		if(user!=null){
			if(topic.getTopicStarter() == user.getId()){
				delPermission = 1;
			}
		}
		ma.addObject("delPermission",delPermission);
		ma.addObject("topic",topic);
		ma.setViewName("/jsp/postings/detail.jsp");
		return ma;
	}
	@RequestMapping("deleteTopic")
	public void deleteTopic(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("topicId"));
		PrintWriter out = response.getWriter();
		String message = "删除成功";
		try{
			Topic topic = topicSVImpl.queryById(id);
			if(topic!=null){
				topicSVImpl.delete(topic);
			}else{
				message = "您要删除的帖子不存在";
			}
		}catch(Exception e){
			message = "删除失败，内部错误！";
			throw new RuntimeException("删除异常");
		}finally{
			out.print(message);
		}
	}
	@RequestMapping("addUpvote")
	public void addUpvote(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("topicId"));
		PrintWriter out = response.getWriter();
		try{
			topicSVImpl.addUpvote(id);
		}catch(Exception e){
			throw new RuntimeException("送花异常");
		}finally{
			int upvotenum = topicSVImpl.queryById(id).getUpvote();
			out.print(upvotenum);
		}
	}
}
