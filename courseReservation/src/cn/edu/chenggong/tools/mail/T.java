package cn.edu.chenggong.tools.mail;
public class T {

	public static void main(String[] args) {
		MailSenderProperties mailInfo=new MailSenderProperties();
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("chenggongcj");
		mailInfo.setPassword("chenggong521");
		mailInfo.setFromAddress("chenggongcj@163.com");
		mailInfo.setToAddress("1030447239@qq.com");
		mailInfo.setSubject("TX数码商城密码找回");
		mailInfo.setContent("你好！");
		SimpleMailSender sm=new SimpleMailSender();
		sm.sendTextMail(mailInfo);
	}

}
