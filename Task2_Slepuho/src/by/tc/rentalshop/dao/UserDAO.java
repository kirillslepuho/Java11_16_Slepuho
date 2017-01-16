package by.tc.rentalshop.dao;

import java.sql.SQLException;

import by.tc.rentalshop.dao.exception.DAOException;

public interface UserDAO {
	void addUser(String name, String cost, String password, int phone) throws DAOException;

	boolean signIn(String email, String password) throws DAOException;

	void editUser(String oldEmail, String newName, String newCost, int newNumber, String newPassword)
			throws DAOException;

	void deleteUser(String email) throws DAOException;

	void showUsersEquipment(String email) throws SQLException;
}
