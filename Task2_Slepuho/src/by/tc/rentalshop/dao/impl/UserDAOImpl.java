package by.tc.rentalshop.dao.impl;

import by.tc.rentalshop.dao.UserDAO;
import by.tc.rentalshop.dao.exception.DAOException;

import java.sql.*;

public class UserDAOImpl implements UserDAO {

	private java.sql.Connection connection;

	public UserDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(String name, String email, String password, int phone) throws DAOException {
		Statement statement;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "root");
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("INSERT INTO user(us_name, us_email,us_password, us_phone) VALUES(");
			stringBuilder.append("\"" + name + "\",\"");
			stringBuilder.append(email + "\",\"");
			stringBuilder.append(password + "\",");
			stringBuilder.append(phone + ");");
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
	public void editUser(String oldEmail, String newName, String newEmail, int newPhone, String newPassword)
			throws DAOException {
		Statement statement;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "root");
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("UPDATE user SET ");
			stringBuilder.append("us_name='" + newName + "', ");
			stringBuilder.append("us_email='" + newEmail + "', ");
			stringBuilder.append("us_password='" + newPassword + "', ");
			stringBuilder.append("us_phone=" + newPhone + " WHERE us_email='" + oldEmail + "';");
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
	public void deleteUser(String email) throws DAOException {
		Statement statement;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "root");
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("DELETE FROM user WHERE us_email='" + email + "';");
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

	public boolean signIn(String email, String password) throws DAOException {
		Statement statement;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "root");
			String resultPassword = null;
			statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT us_password FROM user WHERE us_email='" + email + "';");
			while (resultSet.next()) {
				resultPassword = resultSet.getString(1);
			}

			return (resultPassword.equals(password)) ? true : false;

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
	public void showUsersEquipment(String email) throws SQLException {
		Statement statement;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "root");
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"SELECT rt_id,eq_title,eq_firm,eq_price FROM sportequipment inner join rent on rt_sportequipment = eq_id inner join user on rt_user = us_id where us_id = "
						+ getUserId(email) + ";");
		while (resultSet.next()) {
			System.out.println(resultSet.getString("rt_id") + "," + resultSet.getString("eq_title") + ","
					+ resultSet.getString("eq_firm") + "," + resultSet.getString("eq_price"));
		}
		connection.close();
	}

	private int getUserId(String email) throws SQLException {
		Statement statement;
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false", "root", "root");
		int result = 0;
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT us_id FROM user WHERE us_email='" + email + "';");
		while (resultSet.next()) {
			result = resultSet.getByte(1);
		}
		connection.close();
		return result;
	}

}
