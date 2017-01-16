package by.tc.rentalshop.controller.command.impl;

import by.tc.rentalshop.bean.Request;

import by.tc.rentalshop.bean.Response;
import by.tc.rentalshop.bean.requests.RentEquipmentRequest;
import by.tc.rentalshop.controller.command.Command;
import by.tc.rentalshop.service.ClientService;
import by.tc.rentalshop.service.exception.ServiceException;
import by.tc.rentalshop.service.factory.ServiceFactory;

public class RentEquipment implements Command {

	@Override
	public Response execute(Request request) {

		RentEquipmentRequest rentEquipmentRequest = null;
		if (request instanceof RentEquipmentRequest) {
			rentEquipmentRequest = (RentEquipmentRequest) request;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getClientService();

		String title = rentEquipmentRequest.getTitle();
		String email = rentEquipmentRequest.getEmail();

		Response response = new Response();
		try {
			// Получает номер заказа
			String rentId = clientService.rentEquipment(email, title);
			response.setErrorStatus(false);
			response.setMessage("Your rent number = " + rentId);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			e.printStackTrace();
		}

		return response;
	}

}
