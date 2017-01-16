package by.tc.rentalshop.controller.command.impl;

import by.tc.rentalshop.bean.Request;

import by.tc.rentalshop.bean.Response;
import by.tc.rentalshop.bean.requests.ReturnEquipmentRequest;
import by.tc.rentalshop.controller.command.Command;
import by.tc.rentalshop.service.ClientService;
import by.tc.rentalshop.service.exception.ServiceException;
import by.tc.rentalshop.service.factory.ServiceFactory;

public class ReturnEquipment implements Command {

	public Response execute(Request request) {

		ReturnEquipmentRequest returnEquipmentRequest = null;
		if (request instanceof ReturnEquipmentRequest) {
			returnEquipmentRequest = (ReturnEquipmentRequest) request;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getClientService();

		int rentId = returnEquipmentRequest.getRent_id();

		Response response = new Response();
		try {
			clientService.returnEquipment(rentId);
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
