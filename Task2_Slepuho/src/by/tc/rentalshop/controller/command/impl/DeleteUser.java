package by.tc.rentalshop.controller.command.impl;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.bean.Response;
import by.tc.rentalshop.bean.requests.DeleteUserRequest;
import by.tc.rentalshop.controller.command.Command;
import by.tc.rentalshop.service.ShopService;
import by.tc.rentalshop.service.exception.ServiceException;
import by.tc.rentalshop.service.factory.ServiceFactory;

public class DeleteUser implements Command {

	public Response execute(Request request) {

		DeleteUserRequest deleteUserRequest = null;
		if (request instanceof DeleteUserRequest) {
			deleteUserRequest = (DeleteUserRequest) request;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ShopService shopService = serviceFactory.getShopService();

		String email = deleteUserRequest.getEmail();

		Response response = new Response();
		try {
			shopService.deleteUser(email);
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
