package by.tc.rentalshop.bean.requests;

import by.tc.rentalshop.controller.CommandsNames;

public class EditUserRequest extends RegistrationRequest {
	private String changedUserEmail;

	public String getChangedUserEmail() {
		return changedUserEmail;
	}

	public void setChangedUserEmail(String changedUserEmail) {
		this.changedUserEmail = changedUserEmail;
	}

	public CommandsNames getCommand() {
		return CommandsNames.EDIT_USER;
	}

}
