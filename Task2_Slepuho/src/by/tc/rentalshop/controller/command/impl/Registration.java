package by.tc.rentalshop.controller.command.impl;

import by.tc.rentalshop.bean.Request;

import by.tc.rentalshop.bean.Response;
import by.tc.rentalshop.bean.requests.RegistrationRequest;
import by.tc.rentalshop.controller.command.Command;
import by.tc.rentalshop.service.ClientService;
import by.tc.rentalshop.service.exception.ServiceException;
import by.tc.rentalshop.service.factory.ServiceFactory;

public class Registration implements Command {

	public Response execute(Request request) {

		RegistrationRequest registrationRequest = null;
		if (request instanceof RegistrationRequest) {
			registrationRequest = (RegistrationRequest) request;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getClientService();

		String name = registrationRequest.getName();
		String email = registrationRequest.getEmail();
		String password = registrationRequest.getPassword();
		int phone = registrationRequest.getPhone();

		Response response = new Response();
		try {
			clientService.registration(name, email, password, phone);
			response.setErrorStatus(false);
			response.setMessage("Welcome!!!");
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return response;
	}

}
