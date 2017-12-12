package cn.edu.chenggong.action;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.chenggong.biz.UsersBiz;
import cn.edu.chenggong.po.Users;
import cn.edu.chenggong.tools.mail.GetUserMail;

@Controller
@RequestMapping("userAction")
public class UserAction {
	@Resource
	private UsersBiz usersBiz;
    static Users stId;
	/**
	 * 添加用户信息
	 * @param users
	 */
	@RequestMapping("/addUserInfo")
	public String addUserInfo(Users users) {		
		usersBiz.addUserInfo(users);
		return "/success.jsp";
	} 
	
	@RequestMapping("/insertAdmin")
	public String insertAdmin(Users users) {
		usersBiz.addAdminInfo(users);
		return "informationDisplay.action";
	}
	/*用户登录及状态判断*/
	@RequestMapping("/userLogin")
	public String userLogin(Users users,HttpSession session){
		Users u = usersBiz.findUsers(users);
		if (u!=null){
			session.setAttribute("users", u); 
			stId=u;
			if(u.getUsersState()==1){
				return "UinformationDisplay.action";
			}
			return "informationDisplay.action";
		}
		else{
			System.out.println("该用户不存在");
			return "/login.jsp";
		}
	}
	/**
	 * 
	 * @param users
	 * @param session
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/userAjaxId")
	public void userAjaxId(Users users,HttpSession session,HttpServletResponse response) throws IOException{
		Users u = usersBiz.findUsersInfoById(users);
		String msg1 = "该用户存在";	
		String msg2 = "该用不户存在";	
		PrintWriter out = response.getWriter();
		if (u!=null){
			session.setAttribute("users", u);  
			System.out.println("该用户存在"+u.toString());
				
				 out.print(msg1);			 
				
		}
		else{
			System.out.println("该用户不存在");
			out.print(msg2);
			
		}
		out.flush();
		out.close();
	}
	/**
	 * 邮箱随机密码发送
	 * @param users
	 */
	@RequestMapping("/pastMailcode")
	public void pastMailcode(Users users){
		int randNum =(int)(Math.random() * (999999));
		String a=randNum+"";
		users.setEmilCode(a);
		usersBiz.insertMailcode(users);
		Users u = usersBiz.findUsersInfoById(users);		
		System.out.println(users.getEmilCode());	
		GetUserMail mail = new GetUserMail();
		mail.getUsersMail(u);
	}
	@RequestMapping("/equalEmilCode")
	public void equalEmilCode(Users users,HttpServletResponse response) throws IOException{
		String msg1 = "邮箱验证不通过";	
		String msg2 = "邮箱验证通过";
		PrintWriter out = response.getWriter();
	    String s1=users.getEmilCode();
	    Users u=usersBiz.findUsersInfoById(users);
	    System.out.println(u.toString());
	    String s2 = u.getEmilCode();
		if(s1.equals(s2)){
				out.print(msg2);			
		}else{
			    out.print(msg1);
		}
		out.flush();
		out.close();
	}
	/*信息资料显示*/
	@RequestMapping("/informationDisplay")
	public String informationDisplay(HttpSession session){
		
		List<Users> usersList = new ArrayList<Users>();
		usersList = usersBiz.getTheUsesInfo();
		session.setAttribute("usersList", usersList);
		session.setAttribute("stId", stId);
		return "/roleFlag0.jsp";		
	}
	/*用户信息资料显示*/
	@RequestMapping("/UinformationDisplay")
    public String UinformationDisplay(HttpSession session){		
		List<Users> usersList = new ArrayList<Users>();
		usersList = usersBiz.getTheUsesInfo();
		session.setAttribute("usersList", usersList);
		session.setAttribute("stId", stId);
		return "/roleFlag1.jsp";		
	}
	/*用户信息编辑页面跳转*/
	@RequestMapping("/editPageBefor")
	public String editPageBefor(Users users,HttpSession session){
		Users userEdit=usersBiz.findUsersInfoById(users);
		System.out.println(userEdit.toString());
		session.setAttribute("userEdit", userEdit);
		return "/editPage_1.jsp";		
	}
	/*用户修改信息*/
	@RequestMapping("/editPageBeforU")
	public String editPageBeforU(Users users){
		usersBiz.updateUsersInfo(users);
		return "UinformationDisplay.action";		
	}	
	@RequestMapping("/userUpdatePwd")
	public String userUpdatePwd(Users users){
		usersBiz.userUpdatePwd(users);
		return "/updatePwdSuccess.jsp";		
	}
	/*用户信息删除*/
	@RequestMapping("/delectPageBefor")
	public String delectPageBefor(Users users,HttpSession session){
		users=usersBiz.findUsersInfoById(users);
		usersBiz.delectUsersInfo(users);
		return "informationDisplay.action";		
	}
	/*用户信息编辑后页面跳转*/
	@RequestMapping("/editPageAfter")
	public String editPageAfter(Users users){	
		usersBiz.updateUsersInfo(users);
		return "informationDisplay.action";		
	}	
	/*页面跳转*/
	@RequestMapping("/login0")
	public String login0(Users users){
		return "login0.jsp";
		
	}
	
}
