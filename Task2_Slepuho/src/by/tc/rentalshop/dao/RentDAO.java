package by.tc.rentalshop.dao;

import by.tc.rentalshop.dao.exception.DAOException;

public interface RentDAO {
	void returnEquipment(int rent_id) throws DAOException;

	void rentEquipment(String email, String title) throws DAOException;

	public int getCountOfUsersEquipment(String email) throws DAOException;

	public String selectLastInsertId() throws DAOException;
}
