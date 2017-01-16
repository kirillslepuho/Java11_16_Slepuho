package by.tc.rentalshop.dao.impl;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.tc.rentalshop.dao.SportEquipmentDAO;
import by.tc.rentalshop.dao.exception.DAOException;

public class SportEquipmentDAOImpl implements SportEquipmentDAO {

	private java.sql.Connection connection;

	public SportEquipmentDAOImpl() {

	}

	@Override
	public void addSportEquipment(String title, String firm, int price, String category) throws DAOException {
		Statement statement;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "root");
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("INSERT INTO sportequipment(eq_title, eq_firm, eq_price,eq_category) VALUES(");
			stringBuilder.append("\"" + title + "\",\"");
			stringBuilder.append(firm + "\",");
			stringBuilder.append(price + ",\"");
			stringBuilder.append(category + "\");");
			statement = connection.createStatement();
			statement.execute(stringBuilder.toString());
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void editSportEquipment(int id, String newTitle, String newFirm, int newPrice, String newCategory)
			throws DAOException {
		Statement statement;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "root");
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("UPDATE sportequipment SET ");
			stringBuilder.append("eq_title='" + newTitle + "', ");
			stringBuilder.append("eq_firm='" + newFirm + "', ");
			stringBuilder.append("eq_price=" + newPrice + ", ");
			stringBuilder.append("eq_category='" + newCategory + "' WHERE eq_id='" + id + "';");
			statement = connection.createStatement();
			statement.execute(stringBuilder.toString());
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteSportEquipment(int id) throws DAOException {
		Statement statement;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "root");
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("DELETE FROM sportequipment WHERE eq_id=" + id + ";");
			statement = connection.createStatement();
			statement.execute(stringBuilder.toString());
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void showEquipment() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "root");
		Statement statement;
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from sportequipment");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("eq_id") + "," + resultSet.getString("eq_title") + ","
					+ resultSet.getString("eq_firm") + "," + resultSet.getString("eq_price") + ","
					+ resultSet.getString("eq_category") + "," + resultSet.getString("eq_status"));
		}
		connection.close();
	}

	@Override
	public void searchEquipment(String title) throws SQLException {
		Statement statement;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "root");
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from sportequipment where eq_title ='" + title + "';");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("eq_id") + "," + resultSet.getString("eq_title") + ","
					+ resultSet.getString("eq_firm") + "," + resultSet.getString("eq_price") + ","
					+ resultSet.getString("eq_category") + "," + resultSet.getString("eq_status"));
		}
		connection.close();

	}

}
