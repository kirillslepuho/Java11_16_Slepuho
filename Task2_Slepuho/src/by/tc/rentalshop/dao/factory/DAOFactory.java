package by.tc.rentalshop.dao.factory;

import by.tc.rentalshop.dao.RentDAO;
import by.tc.rentalshop.dao.SportEquipmentDAO;
import by.tc.rentalshop.dao.UserDAO;
import by.tc.rentalshop.dao.impl.RentDAOImpl;
import by.tc.rentalshop.dao.impl.SportEquipmentDAOImpl;
import by.tc.rentalshop.dao.impl.UserDAOImpl;

public class DAOFactory {
	private static final DAOFactory daoFactory = new DAOFactory();

	private DAOFactory() {
	}

	private UserDAO userDAO = new UserDAOImpl();
	private SportEquipmentDAO sportEquipmentsDAO = new SportEquipmentDAOImpl();
	private RentDAO rentDAO = new RentDAOImpl();

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public SportEquipmentDAO getSportEquipmentsDAO() {
		return sportEquipmentsDAO;
	}

	public RentDAO getRentDAO() {
		return rentDAO;
	}

	public static DAOFactory getInstance() {
		return daoFactory;
	}
}
