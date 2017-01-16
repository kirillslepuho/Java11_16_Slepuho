package by.tc.rentalshop.service;

import by.tc.rentalshop.service.exception.ServiceException;

public interface ShopService extends OverallService {
	void addSportEquipment(String title, String firm, int price, String category) throws ServiceException;

	void editSportEquipment(int id, String newTitle, String newFirm, int newPrice, String newCategory)
			throws ServiceException;

	void deleteSportEquipment(int id) throws ServiceException;
}
