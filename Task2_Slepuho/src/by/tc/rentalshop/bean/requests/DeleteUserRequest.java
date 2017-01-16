package by.tc.rentalshop.bean.requests;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.controller.CommandsNames;

public class DeleteUserRequest extends Request {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CommandsNames getCommand() {
		return CommandsNames.DELETE_USER;
	}

}
