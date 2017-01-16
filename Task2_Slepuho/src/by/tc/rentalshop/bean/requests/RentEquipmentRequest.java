package by.tc.rentalshop.bean.requests;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.controller.CommandsNames;

public class RentEquipmentRequest extends Request {
	private String email;
	private String title;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CommandsNames getCommand() {
		return CommandsNames.RENT_EQUIPMENT;
	}

}
