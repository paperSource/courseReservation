package cn.edu.chenggong.action;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.edu.chenggong.biz.UsersBiz;
import cn.edu.chenggong.po.Users;

@Controller
@RequestMapping("userAction")
public class UserAction {
	@Resource
	private UsersBiz usersBiz;
    static Users stId;
	public UsersBiz getUsersBiz() {
		return usersBiz;
	}
    
	public void setUsersBiz(UsersBiz usersBiz) {
		this.usersBiz = usersBiz;
	}
	/**
	 * 添加用户信息
	 * @param users
	 */
	@RequestMapping("/addUserInfo")
	public String addUserInfo(Users users) {
		usersBiz.addUserInfo(users);
		return "redirect:/success.jsp";
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
			System.out.println("该用户存在"+u.toString());
			stId=u;
			if(u.getUsersState()==1){
				return "UinformationDisplay.action";
			}
			return "informationDisplay.action";
		}
		else{
			System.out.println("该用户不存在");
			return "redirect:/login.jsp";
		}
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
	@RequestMapping("/UinformationDisplay")
    public String UinformationDisplay(HttpSession session){		
		List<Users> usersList = new ArrayList<Users>();
		usersList = usersBiz.getTheUsesInfo();
		session.setAttribute("usersList", usersList);
		session.setAttribute("stId", stId);
		return "/roleFlag1.jsp";		
	}
	@RequestMapping("/editPageBefor")
	public String editPageBefor(Users users,HttpSession session){
		Users userEdit=usersBiz.findUsersInfoById(users);
		System.out.println(userEdit.toString());
		session.setAttribute("userEdit", userEdit);
		return "/editPage_1.jsp";		
	}
	@RequestMapping("/editPageBeforU")
	public String editPageBeforU(Users users){
		usersBiz.updateUsersInfo(users);
		return "UinformationDisplay.action";		
	}
	@RequestMapping("/delectPageBefor")
	public String delectPageBefor(Users users,HttpSession session){
		users=usersBiz.findUsersInfoById(users);
		usersBiz.delectUsersInfo(users);
		return "informationDisplay.action";		
	}
	@RequestMapping("/editPageAfter")
	public String editPageAfter(Users users){	
		usersBiz.updateUsersInfo(users);
		return "informationDisplay.action";		
	}	
	@RequestMapping("/login0")
	public String login0(Users users){
		return "login0.jsp";
		
	}
}
