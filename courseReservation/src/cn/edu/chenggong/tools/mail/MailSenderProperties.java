package cn.edu.chenggong.tools.mail;

import java.util.Properties;

/** @pdOid 435600e6-ac6d-4d3b-8e32-b18100260461 */
public class MailSenderProperties {
   /**  发送邮件的服务器的IP和端口
    * 
    * @pdOid d31a756e-3fca-4eb7-a680-3b1e5aa21731 */
   private String mailServerHost;
   /** @pdOid f1402a2e-b7a6-43c4-be2f-d992050fa293 */
   private String mailServerPort = "25";
   /**  邮件发送的地址
    * 
    * @pdOid 3714c91b-0887-4db8-bc05-dcea47067638 */
   private String fromAddress;
   /**  邮件接收者的地址
    * 
    * @pdOid 00eaebf3-7107-46b4-b67e-f2ff54386114 */
   private String toAddress;
   /**  登陆邮件发送服务器的用户名和密码
    * 
    * @pdOid 512aaa49-f13e-464d-a1f2-da5218da3445 */
   private String userName;
   /** @pdOid 24bd84a4-1d4d-44e7-82db-cb05ed8f99b2 */
   private String password;
   /**  是否需要身份验证
    * 
    * @pdOid 6fd1883c-0625-41ac-ace0-e2297c50df6e */
   private boolean validate = false;
   /**  邮件主题
    * 
    * @pdOid 78168e63-5fce-4ceb-bb8c-70f7321bc4fc */
   private String subject;
   /**  邮件的文本内容
    * 
    * @pdOid b5e6b02a-40c0-4e1a-9402-e0d87642bc8a */
   private String content;
   /**  邮件附件的文件名
    * 
    * @pdOid 71957849-1135-4447-ba31-393108a43be6 */
   private String[] attachFileNames;
   
   /** 获得邮件会话属性
    * 
    * 
    * @pdOid 5877e6e4-016a-42ad-8ba3-162a30aa4143 */
   public Properties getProperties() {   
     Properties p = new Properties();   
     p.put("mail.smtp.host", this.mailServerHost);   
     p.put("mail.smtp.port", this.mailServerPort);   
     p.put("mail.smtp.auth", validate ? "true" : "false");   
     return p;   
   }
   
   /** @pdOid 2be16e7a-58b9-4f3f-929a-50e9feaeabfd */
   public String getMailServerHost() {   
     return mailServerHost;   
   }
   
   /** @param mailServerHost
    * @pdOid 6b1c069a-a718-4a77-b62d-76783643c33b */
   public void setMailServerHost(String mailServerHost) {   
     this.mailServerHost = mailServerHost;   
   }
   
   /** @pdOid ed684798-f4f1-4efe-93dc-58967c0d32c9 */
   public String getMailServerPort() {   
     return mailServerPort;   
   }
   
   /** @param mailServerPort
    * @pdOid e21bd554-9a20-4de8-8091-d5fb3b848f95 */
   public void setMailServerPort(String mailServerPort) {   
     this.mailServerPort = mailServerPort;   
   }
   
   /** @pdOid d898d5f8-1b09-44dd-b3e7-444b43c4aaaf */
   public boolean isValidate() {   
     return validate;   
   }
   
   /** @param validate
    * @pdOid f85da000-6e11-4941-a827-0e5fa9e75c5d */
   public void setValidate(boolean validate) {   
     this.validate = validate;   
   }
   
   /** @pdOid 1590ee75-9071-43f4-a497-49dd37e016e0 */
   public String[] getAttachFileNames() {   
     return attachFileNames;   
   }
   
   /** @param fileNames
    * @pdOid 68d1637f-463d-4734-b5cf-db0702b15116 */
   public void setAttachFileNames(String[] fileNames) {   
     this.attachFileNames = fileNames;   
   }
   
   /** @pdOid bb3e2e7f-c125-41c4-99ee-36a01f7749b9 */
   public String getFromAddress() {   
     return fromAddress;   
   }
   
   /** @param fromAddress
    * @pdOid fa8b6bbc-0375-431d-ac25-532c665b9a20 */
   public void setFromAddress(String fromAddress) {   
     this.fromAddress = fromAddress;   
   }
   
   /** @pdOid 59a8fa9f-94ec-4570-bea8-663602b64370 */
   public String getPassword() {   
     return password;   
   }
   
   /** @param password
    * @pdOid 8bef5943-228b-4d58-9deb-bdae3eebaecf */
   public void setPassword(String password) {   
     this.password = password;   
   }
   
   /** @pdOid 119cfeca-3e97-4f33-8d90-a48d0aa4c22e */
   public String getToAddress() {   
     return toAddress;   
   }
   
   /** @param toAddress
    * @pdOid 02209e69-c3a1-4194-a694-64c6a2e12732 */
   public void setToAddress(String toAddress) {   
     this.toAddress = toAddress;   
   }
   
   /** @pdOid 9a464953-0dec-45b7-b0b9-bb1cb2cae340 */
   public String getUserName() {   
     return userName;   
   }
   
   /** @param userName
    * @pdOid c4da6024-3085-49bf-8bf7-efa34d405dad */
   public void setUserName(String userName) {   
     this.userName = userName;   
   }
   
   /** @pdOid fd8a3aa5-6d16-46e3-bc26-8e804eb9cacc */
   public String getSubject() {   
     return subject;   
   }
   
   /** @param subject
    * @pdOid 4667ebaa-8e89-4c6b-aa5d-ee68d6e88f9c */
   public void setSubject(String subject) {   
     this.subject = subject;   
   }
   
   /** @pdOid b9396238-1989-4c2c-9f20-b4a6d779d66b */
   public String getContent() {   
     return content;   
   }
   
   /** @param textContent
    * @pdOid e06aefbe-e0c8-403b-b4d7-734a73ea229c */
   public void setContent(String textContent) {   
     this.content = textContent;   
   }

}