package by.tc.rentalshop.dao;

import java.sql.SQLException;

import by.tc.rentalshop.dao.exception.DAOException;

public interface SportEquipmentDAO {
	void addSportEquipment(String title, String firm, int price, String category) throws DAOException;

	void editSportEquipment(int id, String newTitle, String newFirm, int newPrice, String newCategory)
			throws DAOException;

	void deleteSportEquipment(int id) throws DAOException;

	void showEquipment() throws SQLException;

	void searchEquipment(String title) throws SQLException;
}
