package by.tc.rentalshop.service;

import by.tc.rentalshop.service.exception.ServiceException;

public interface ClientService extends OverallService {
	void registration(String name, String email, String password, int phone) throws ServiceException;

	void signIn(String email, String password) throws ServiceException;

	void editUser(String oldEmail, String newName, String newEmail, int newPhone, String newPassword)
			throws ServiceException;

	String rentEquipment(String email, String title) throws ServiceException;

	void returnEquipment(int rent_id) throws ServiceException;

	void showUsersEquipment(String email) throws ServiceException;

	void searchEquipment(String title) throws ServiceException;
}
