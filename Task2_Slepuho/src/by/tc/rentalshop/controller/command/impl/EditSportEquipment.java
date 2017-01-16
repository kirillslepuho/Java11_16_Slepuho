package by.tc.rentalshop.controller.command.impl;

import by.tc.rentalshop.bean.Request;

import by.tc.rentalshop.bean.Response;
import by.tc.rentalshop.bean.requests.EditSportEquipmentRequest;
import by.tc.rentalshop.controller.command.Command;
import by.tc.rentalshop.service.ShopService;
import by.tc.rentalshop.service.exception.ServiceException;
import by.tc.rentalshop.service.factory.ServiceFactory;

public class EditSportEquipment implements Command {

	public Response execute(Request request) {

		EditSportEquipmentRequest editSportEquipmentRequest = null;
		if (request instanceof EditSportEquipmentRequest) {
			editSportEquipmentRequest = (EditSportEquipmentRequest) request;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ShopService shopService = serviceFactory.getShopService();

		String newTitle = editSportEquipmentRequest.getTitle();
		String newFirm = editSportEquipmentRequest.getFirm();
		int newPrice = editSportEquipmentRequest.getPrice();
		String newCategory = editSportEquipmentRequest.getCategory();
		int changedId = editSportEquipmentRequest.get—hangedEquipmentId();

		Response response = new Response();
		try {
			shopService.editSportEquipment(changedId, newTitle, newFirm, newPrice, newCategory);
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
