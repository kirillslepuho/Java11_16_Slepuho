package by.tc.rentalshop.controller.command.impl;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.bean.Response;
import by.tc.rentalshop.bean.requests.DeleteSportEquipmentRequest;
import by.tc.rentalshop.controller.command.Command;
import by.tc.rentalshop.service.ShopService;
import by.tc.rentalshop.service.exception.ServiceException;
import by.tc.rentalshop.service.factory.ServiceFactory;

public class DeleteSportEquipment implements Command {

	public Response execute(Request request) {

		DeleteSportEquipmentRequest deleteSportEquipmentRequest = null;
		if (request instanceof DeleteSportEquipmentRequest) {
			deleteSportEquipmentRequest = (DeleteSportEquipmentRequest) request;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ShopService shopService = serviceFactory.getShopService();

		int equipmentId = deleteSportEquipmentRequest.getEquipmentId();

		Response response = new Response();
		try {
			shopService.deleteSportEquipment(equipmentId);
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
