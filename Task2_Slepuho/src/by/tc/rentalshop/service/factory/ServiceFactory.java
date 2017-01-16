package by.tc.rentalshop.service.factory;

import by.tc.rentalshop.service.ClientService;
import by.tc.rentalshop.service.ShopService;
import by.tc.rentalshop.service.impl.ClientServiceImpl;
import by.tc.rentalshop.service.impl.ShopServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private ClientService clientService = new ClientServiceImpl();
	private ShopService shopService = new ShopServiceImpl();

	private ServiceFactory() {
	}

	public ClientService getClientService() {
		return clientService;
	}

	public ShopService getShopService() {
		return shopService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}
}
