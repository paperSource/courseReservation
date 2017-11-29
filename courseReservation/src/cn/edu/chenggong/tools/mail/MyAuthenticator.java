package cn.edu.chenggong.tools.mail;

import javax.mail.*;

/** @pdOid 03bf3c3c-573f-40f9-a826-b6fabfb9619e */
public class MyAuthenticator extends Authenticator {
   /** @pdOid 176f00f2-65ae-4b3b-af51-13cf1c265a2f */
   protected PasswordAuthentication getPasswordAuthentication() {  
       return new PasswordAuthentication(userName, password);  
   }
   
   /** @pdOid 0c9c0ede-ee7b-4353-886b-0d2b93f33138 */
   String userName = null;
   /** @pdOid 172931b8-eaca-497c-bad9-55ebf209d2e3 */
   String password = null;
   
   /** @pdOid dd23527c-49a2-4ac6-a370-455012b3a15b */
   public MyAuthenticator() {  
   }
   
   /** @param username 
    * @param password
    * @pdOid 435418b5-b720-4710-bddc-254c6a998e3b */
   public MyAuthenticator(String username, String password) {   
       this.userName = username;   
       this.password = password;   
   }

}