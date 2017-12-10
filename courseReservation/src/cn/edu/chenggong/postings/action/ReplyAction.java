package cn.edu.chenggong.postings.action;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.chenggong.biz.impl.UsersBizImpl;
import cn.edu.chenggong.po.Users;
import cn.edu.chenggong.postings.model.Reply;
import cn.edu.chenggong.postings.service.Interface.IReplySV;
import cn.edu.chenggong.util.SpringContextUtil;

@Controller
@RequestMapping("replyAction")
public class ReplyAction {
	@Resource
	private IReplySV replySV;
	public void setReplySV(IReplySV replySV) {
		this.replySV = replySV;
	}
	public IReplySV getReplySV() {
		return replySV;
	}
	@RequestMapping("addReply")
	public void addReply(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String reply_content = request.getParameter("reply_content");
		int topicID = Integer.parseInt(request.getParameter("topicID"));
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("users");
		String message = "回复成功";
		try{
			if(user!=null){
				Reply reply = new Reply();
				reply.setTopicID(topicID);
				reply.setReplyID(user.getId());
				reply.setContent(reply_content);
				reply.setFlowers(0);
				reply.setEggs(0);
				reply.setState(1);
				replySV.add(reply);
			}else{
				message = "请登录!";
			}
		}catch(Exception e){
			message = "回复失败，系统内部错误！";
			throw new RuntimeException("插入异常");
		}finally{
			out.print(message);
		}
	}
	@RequestMapping("query")
	public @ResponseBody Map<String, Object> query(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int intPage = Integer.parseInt(request.getParameter("page"));
		int number = Integer.parseInt(request.getParameter("num"));
		int start = (intPage-1)*number;
		int topicID = Integer.parseInt(request.getParameter("topicID"));
		UsersBizImpl biz = (UsersBizImpl) SpringContextUtil.getApplicationContext().getBean("usersBizImpl");
		List<Reply> replyList = replySV.queryByTopicID(topicID, start, number);
		for(int i=0;i<replyList.size();i++){
			replyList.get(i).setReplyUser(biz.findAllById(replyList.get(i).getReplyID()));
		}
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("users");
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("total", replySV.queryByTopicIDList(topicID).size());
		map.put("replyList", replyList);
		map.put("user", user);
		return map;
	}
	@RequestMapping("deleteReply")
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("replyId"));
		PrintWriter out = response.getWriter();
		String message = "删除成功";
		try{
			replySV.delete(id);
		}catch(Exception e){
			message = "删除失败，内部错误！";
			throw new RuntimeException("删除异常");
		}finally{
			out.print(message);
		}
	}
	@RequestMapping("addFlowers")
	public void addFlowers(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("replyId"));
		PrintWriter out = response.getWriter();
		try{
			replySV.addFlowers(id);
		}catch(Exception e){
			throw new RuntimeException("送花异常");
		}finally{
			int flowsnum = replySV.queryByID(id).getFlowers();
			out.print(flowsnum);
		}
	}
	@RequestMapping("addEggs")
	public void addEggs(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("replyId"));
		PrintWriter out = response.getWriter();
		try{
			replySV.addEggs(id);
		}catch(Exception e){
			throw new RuntimeException("丢蛋异常");
		}finally{
			int eggsnum = replySV.queryByID(id).getEggs();
			out.print(eggsnum);
		}
	}
}
