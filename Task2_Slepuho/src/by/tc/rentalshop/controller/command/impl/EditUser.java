package by.tc.rentalshop.controller.command.impl;

import by.tc.rentalshop.bean.Request;

import by.tc.rentalshop.bean.Response;
import by.tc.rentalshop.bean.requests.EditUserRequest;
import by.tc.rentalshop.controller.command.Command;
import by.tc.rentalshop.service.ClientService;
import by.tc.rentalshop.service.exception.ServiceException;
import by.tc.rentalshop.service.factory.ServiceFactory;

public class EditUser implements Command {

	public Response execute(Request request) {

		EditUserRequest editUserRequest = null;
		if (request instanceof EditUserRequest) {
			editUserRequest = (EditUserRequest) request;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getClientService();

		String newName = editUserRequest.getName();
		String newEmail = editUserRequest.getEmail();
		String newPassword = editUserRequest.getPassword();
		int newPhone = editUserRequest.getPhone();
		String oldEmail = editUserRequest.getChangedUserEmail();

		Response response = new Response();
		try {
			clientService.editUser(oldEmail, newName, newEmail, newPhone, newPassword);
			;
			response.setErrorStatus(false);
			response.setMessage("Successfully");
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return response;
	}

}
