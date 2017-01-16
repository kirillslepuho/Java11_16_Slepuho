package by.tc.rentalshop.service;

import by.tc.rentalshop.service.exception.ServiceException;

public interface OverallService {
	void deleteUser(String email) throws ServiceException;

	void showEquipment() throws ServiceException;
}
