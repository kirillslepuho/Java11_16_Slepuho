package by.tc.rentalshop.service.impl;

import java.sql.SQLException;

import by.tc.rentalshop.dao.RentDAO;
import by.tc.rentalshop.dao.SportEquipmentDAO;
import by.tc.rentalshop.dao.UserDAO;
import by.tc.rentalshop.dao.exception.DAOException;
import by.tc.rentalshop.dao.factory.DAOFactory;
import by.tc.rentalshop.service.ClientService;
import by.tc.rentalshop.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {

	DAOFactory daoFactory = DAOFactory.getInstance();
	SportEquipmentDAO sportEquipmentDAO = daoFactory.getSportEquipmentsDAO();
	UserDAO userDAO = daoFactory.getUserDAO();
	RentDAO rentDAO = daoFactory.getRentDAO();
	private static int maxCountOfUsersEquipment = 3;

	@Override
	public void deleteUser(String email) throws ServiceException {

		if (email == null || email.isEmpty()) {
			throw new ServiceException("Incorrect email");
		}

		try {
			userDAO.deleteUser(email);
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void showEquipment() throws ServiceException {
		try {
			sportEquipmentDAO.showEquipment();
		} catch (SQLException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void registration(String name, String email, String password, int phone) throws ServiceException {
		if (name == null || name.isEmpty() || email == null || email.isEmpty() || password == null
				|| password.isEmpty()) {
			throw new ServiceException("Incorrect data");
		}

		try {
			userDAO.addUser(name, email, password, phone);
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void signIn(String email, String password) throws ServiceException {

		if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
			throw new ServiceException("Incorrect data");
		}

		try {
			if (!userDAO.signIn(email, password)) {
				throw new ServiceException("Incorrect login or password");
			}
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void editUser(String oldEmail, String newName, String newEmail, int newPhone, String newPassword)
			throws ServiceException {

		if (oldEmail == null || oldEmail.isEmpty() || newName == null || newName.isEmpty() || newPassword == null
				|| newPassword.isEmpty() || newEmail == null || newEmail.isEmpty()) {
			throw new ServiceException("Incorrect data");
		}

		try {
			userDAO.editUser(oldEmail, newName, newEmail, newPhone, newPassword);
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

	@Override
	public String rentEquipment(String email, String title) throws ServiceException {

		if (email == null || email.isEmpty() || title == null || title.isEmpty()) {
			throw new ServiceException("Incorrect data");
		}
		// Проверка,что пользователь взял напрокат не более максимально
		// возможного количества товаров
		try {
			if (rentDAO.getCountOfUsersEquipment(email) > maxCountOfUsersEquipment) {
				throw new ServiceException("Exceeded the maximum possible quantity of goods");
			}
		} catch (DAOException e) {
			throw new ServiceException();
		}

		try {
			rentDAO.rentEquipment(email, title);
			return rentDAO.selectLastInsertId();
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void returnEquipment(int rent_id) throws ServiceException {
		try {
			rentDAO.returnEquipment(rent_id);
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void showUsersEquipment(String email) throws ServiceException {

		if (email == null || email.isEmpty()) {
			throw new ServiceException("Incorrect email");
		}

		try {
			userDAO.showUsersEquipment(email);
		} catch (SQLException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void searchEquipment(String title) throws ServiceException {

		if (title == null || title.isEmpty()) {
			throw new ServiceException("Incorrect email");
		}

		try {
			sportEquipmentDAO.searchEquipment(title);
		} catch (SQLException e) {
			throw new ServiceException();
		}

	}

}
