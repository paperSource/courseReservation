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
			//if(user!=null){
				Topic tp = new Topic();
				tp.setTitle(topic_title);
				tp.setContent(topic_content);
				tp.setTopicStarter(59);
				tp.setClassify("0");
				tp.setBrowseNum(0);
				tp.setReplyNum(0);
				tp.setState("1");
				tp.setUpvote(0);
				topicSVImpl.add(tp);
			//}else{
			//	message = "用户还未登陆，请登录!";
			//}
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
	@RequestMapping("test")
	public void test(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		String pageIndex = request.getParameter("page");
		System.out.println(pageIndex);
		out.print(pageIndex);
	}
}
