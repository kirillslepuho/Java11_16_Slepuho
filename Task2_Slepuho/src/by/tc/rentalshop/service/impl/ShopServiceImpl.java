package by.tc.rentalshop.service.impl;

import java.sql.SQLException;

import by.tc.rentalshop.dao.SportEquipmentDAO;
import by.tc.rentalshop.dao.UserDAO;
import by.tc.rentalshop.dao.exception.DAOException;
import by.tc.rentalshop.dao.factory.DAOFactory;
import by.tc.rentalshop.service.ShopService;
import by.tc.rentalshop.service.exception.ServiceException;

public class ShopServiceImpl implements ShopService {

	DAOFactory daoFactory = DAOFactory.getInstance();
	SportEquipmentDAO sportEquipmentDAO = daoFactory.getSportEquipmentsDAO();
	UserDAO userDAO = daoFactory.getUserDAO();

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
	public void addSportEquipment(String title, String firm, int price, String category) throws ServiceException {

		if (title == null || title.isEmpty() || firm == null || firm.isEmpty() || category == null
				|| category.isEmpty()) {
			throw new ServiceException("Incorrect data");
		}

		try {
			sportEquipmentDAO.addSportEquipment(title, firm, price, category);
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void editSportEquipment(int id, String newTitle, String newFirm, int newPrice, String newCategory)
			throws ServiceException {

		if (newTitle == null || newTitle.isEmpty() || newFirm == null || newFirm.isEmpty() || newCategory == null
				|| newCategory.isEmpty()) {
			throw new ServiceException("Incorrect data");
		}

		try {
			sportEquipmentDAO.editSportEquipment(id, newTitle, newFirm, newPrice, newCategory);
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void deleteSportEquipment(int id) throws ServiceException {
		try {
			sportEquipmentDAO.deleteSportEquipment(id);
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

}
