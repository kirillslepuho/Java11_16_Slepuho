package by.tc.rentalshop.controller.command.impl;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.bean.Response;
import by.tc.rentalshop.controller.command.Command;

public class WrongRequest implements Command {

	public Response execute(Request request) {
		Response response = new Response();
		response.setErrorStatus(true);
		response.setErrorMessage("Wrong request name");
		return response;

	}

}
