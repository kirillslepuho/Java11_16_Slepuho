package by.tc.rentalshop.controller.command.impl;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.bean.Response;
import by.tc.rentalshop.bean.requests.SignInRequest;
import by.tc.rentalshop.controller.command.Command;
import by.tc.rentalshop.service.ClientService;
import by.tc.rentalshop.service.exception.ServiceException;
import by.tc.rentalshop.service.factory.ServiceFactory;

public class SignIn implements Command {

	public Response execute(Request request) {

		SignInRequest signInRequest = null;
		if (request instanceof SignInRequest) {
			signInRequest = (SignInRequest) request;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getClientService();

		String email = signInRequest.getEmail();
		String password = signInRequest.getPassword();

		Response response = new Response();
		try {
			clientService.signIn(email, password);
			response.setErrorStatus(false);
			response.setMessage("Welcome!");
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return response;
	}

}
