package cn.edu.chenggong.tools.mail;

import org.junit.Test;

import cn.edu.chenggong.po.Users;

public class GetUserMail {
	@Test
public void getUsersMail(Users users){
	MailSenderProperties mailInfo=new MailSenderProperties();
	mailInfo.setMailServerHost("smtp.163.com");
	mailInfo.setMailServerPort("25");
	mailInfo.setValidate(true);
	mailInfo.setUserName("chenggongcj");
	mailInfo.setPassword("chenggong521");
	mailInfo.setFromAddress("chenggongcj@163.com");
	mailInfo.setToAddress(users.getEmilName());
	mailInfo.setSubject("CG早教系统密码找回");
	mailInfo.setContent("您好！验证码为"+users.getEmilCode());
	SimpleMailSender sm=new SimpleMailSender();
	sm.sendTextMail(mailInfo);
}
}
