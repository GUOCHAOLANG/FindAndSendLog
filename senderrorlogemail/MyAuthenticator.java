package com.senderrorlogemail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @ClassName: MyAuthenticator
 * @Description: 辅助邮件发送
 * @author guochaolang
 * @Time: 2016-3-7 下午4:00:55
 */
public class MyAuthenticator extends Authenticator {
	String userName = null;
	String password = null;

	public MyAuthenticator() {
	}

	public MyAuthenticator(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
}
