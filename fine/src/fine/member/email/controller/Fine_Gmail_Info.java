package fine.member.email.controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Fine_Gmail_Info extends Authenticator{
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("iop800015@gmail.com", "wjdgusqhd12!");
	}
}
