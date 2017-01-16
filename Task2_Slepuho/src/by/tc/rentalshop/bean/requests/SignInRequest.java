package by.tc.rentalshop.bean.requests;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.controller.CommandsNames;

public class SignInRequest extends Request {

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CommandsNames getCommand() {
		return CommandsNames.SIGN_IN;
	}

}
