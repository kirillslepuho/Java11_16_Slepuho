package by.tc.rentalshop.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.tc.rentalshop.dao.RentDAO;
import by.tc.rentalshop.dao.exception.DAOException;

public class RentDAOImpl implements RentDAO {

	private java.sql.Connection connection;

	public RentDAOImpl() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rentEquipment(String email, String title) throws DAOException {
		Statement statement;
		try {
			StringBuilder stringBuilder = new StringBuilder();
			// Создание нового заказа
			StringBuilder stringBuilderSecond = new StringBuilder();
			stringBuilder.append("INSERT INTO rent(rt_user, rt_sportequipment) VALUES(");
			stringBuilder.append(getUserId(email) + ",");
			stringBuilder.append(getActiveSportEquipmentId(title) + ");");
			// Смена статуса взятого напрокат оборудования
			stringBuilderSecond.append("UPDATE sportequipment SET ");
			stringBuilderSecond.append("eq_status = 'N'  WHERE eq_id=" + getActiveSportEquipmentId(title) + ";");
			statement = connection.createStatement();
			statement.execute(stringBuilder.toString());
			statement.execute(stringBuilderSecond.toString());

		} catch (SQLException e) {
			throw new DAOException();
		}

	}

	@Override
	public void returnEquipment(int rent_id) throws DAOException {
		Statement statement;
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("DELETE FROM rent where rt_id = " + rent_id + ";");
			statement = connection.createStatement();
			statement.execute(stringBuilder.toString());
		} catch (SQLException e) {
			throw new DAOException();
		}

	}

	public int getCountOfUsersEquipment(String email) throws DAOException {
		Statement statement;
		try {
			int result = 0;
			statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT count(*) FROM rent WHERE rt_user=" + getUserId(email) + ";");
			while (resultSet.next()) {
				result = resultSet.getByte(1);
			}
			return result;
		} catch (SQLException e) {
			throw new DAOException();
		}

	}

	private String getUserId(String email) throws SQLException {
		Statement statement;
		String result = null;
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT us_id FROM user WHERE us_email='" + email + "';");
		while (resultSet.next()) {
			int temp = resultSet.getByte(1);
			result = Integer.toString(temp);
		}

		return result;
	}

	private String getActiveSportEquipmentId(String title) throws DAOException {
		Statement statement;
		try {
			String result = null;
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"SELECT eq_id FROM sportequipment WHERE eq_title='" + title + "' AND eq_status = 'Y' Limit 1;");
			while (resultSet.next()) {
				int temp = resultSet.getByte(1);
				result = Integer.toString(temp);
			}
			return result;
		} catch (SQLException e) {
			throw new DAOException("There is no available equipment");
		}
	}

	public String selectLastInsertId() throws DAOException {
		Statement statement;
		try {
			String result = null;
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT max(rt_id) from rent;");
			while (resultSet.next()) {
				int temp = resultSet.getByte(1);
				result = Integer.toString(temp);
			}
			return result;
		} catch (SQLException e) {
			throw new DAOException();
		}
	}

}
