package by.tc.rentalshop.controller.command.impl;

import by.tc.rentalshop.bean.Request;
import by.tc.rentalshop.bean.Response;
import by.tc.rentalshop.bean.requests.AddSportEquipmentRequest;
import by.tc.rentalshop.controller.command.Command;
import by.tc.rentalshop.service.ShopService;
import by.tc.rentalshop.service.exception.ServiceException;
import by.tc.rentalshop.service.factory.ServiceFactory;

public class AddSportEquipment implements Command {

	@Override
	public Response execute(Request request) {

		AddSportEquipmentRequest addSportEquipmentRequest = null;
		if (request instanceof AddSportEquipmentRequest) {
			addSportEquipmentRequest = (AddSportEquipmentRequest) request;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ShopService shopService = serviceFactory.getShopService();

		String title = addSportEquipmentRequest.getTitle();
		String firm = addSportEquipmentRequest.getFirm();
		int price = addSportEquipmentRequest.getPrice();
		String category = addSportEquipmentRequest.getCategory();

		Response response = new Response();
		try {
			shopService.addSportEquipment(title, firm, price, category);
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
