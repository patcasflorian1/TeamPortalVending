package org.eurovending.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eurovending.helper.DBHelper;
import org.eurovending.model.ConfigMachine;

public class ConfigMachineDao {
	
	//create table ConfigMachine
	public void createConfigMachine(ConfigMachine configMachine) {
		DBHelper dbHelper = new DBHelper();
		Connection connection = dbHelper.getConnection();
		String sql = "CREATE TABLE IF NOT EXISTS config_machine_"+ configMachine.getNameMachine() + " (id INT AUTO_INCREMENT PRIMARY KEY,"
				+ " numberOfProducts INT, nameOfProductsFinal VARCHAR(255), nameOfProducts VARCHAR(255), "
				+ "quantityOfProducts DOUBLE)";	
		// Execute the SQL statement here
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeConnection(connection);
		}
	}
	
	//insert into table ConfigMachine
	public void insertConfigMachine(ConfigMachine configMachine) throws SQLException {
		DBHelper dbHelper = new DBHelper();
		Connection connection = dbHelper.getConnection();
		String sql = "INSERT INTO config_machine_"+ configMachine.getNameMachine() + " (numberOfProducts, nameOfProductsFinal, nameOfProducts, quantityOfProducts) VALUES (?, ?, ?, ?)";
		// Execute the SQL statement here
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, configMachine.getNumberOfProducts());
		preparedStatement.setString(2, configMachine.getNameOfProductsFinal());
		preparedStatement.setString(3, configMachine.getNameOfProducts());
		preparedStatement.setDouble(4, configMachine.getQuantityOfProducts());
		preparedStatement.executeUpdate();
		
		// Close the connection
		dbHelper.closeConnection(connection);
		
	}
	//update table ConfigMachine
	public void updateConfigMachine(ConfigMachine configMachine) throws SQLException {
		DBHelper dbHelper = new DBHelper();
		Connection connection = dbHelper.getConnection();
		String sql = "UPDATE config_machine_"+ configMachine.getNameMachine() + " SET numberOfProducts = ?, nameOfProductsFinal = ?, nameOfProducts = ?, quantityOfProducts = ? WHERE id = ?";
		// Execute the SQL statement here
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, configMachine.getNumberOfProducts());
		preparedStatement.setString(2, configMachine.getNameOfProductsFinal());
		preparedStatement.setString(3, configMachine.getNameOfProducts());
		preparedStatement.setDouble(4, configMachine.getQuantityOfProducts());
		preparedStatement.setInt(5, configMachine.getId());
		preparedStatement.executeUpdate();
		// Close the connection
		 dbHelper.closeConnection(connection);
		
	}
	//delete from table ConfigMachine	
	public void deleteConfigMachine(ConfigMachine configMachine) {
		DBHelper dbHelper = new DBHelper();
		Connection connection = dbHelper.getConnection();
		String sql = "DELETE FROM config_machine_"+ configMachine.getNameMachine() + " WHERE id = ?";
		// Execute the SQL statement here
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, configMachine.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeConnection(connection);
		}
	}
	//drop table ConfigMachine by nameMachine
	public void dropConfigMachineByNameMachine(String nameMachine) {
		DBHelper dbHelper = new DBHelper();
		Connection connection = dbHelper.getConnection();
		String sql = "DROP TABLE IF EXISTS config_machine_"+ nameMachine;
		// Execute the SQL statement here
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeConnection(connection);
		}
	}
	
	//get all ConfigMachine by nameMachine
	public void getAllConfigMachineByNameMachine(String nameMachine) {
		DBHelper dbHelper = new DBHelper();
		Connection connection = dbHelper.getConnection();
		String sql = "SELECT * FROM config_machine_"+ nameMachine;
		// Execute the SQL statement here
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeConnection(connection);
		}
		}
	//get single ConfigMachine
	public ConfigMachine getSingleConfigMachine(int id, String nameMachine) {
		 ConfigMachine configMachine = null;
		DBHelper dbHelper = new DBHelper();
		Connection connection = dbHelper.getConnection();
		String sql = "SELECT * FROM config_machine_"+ nameMachine + " WHERE id = ?";
		// Execute the SQL statement here
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				configMachine = new ConfigMachine();
				configMachine.setId(resultSet.getInt("id"));
				configMachine.setNameMachine(resultSet.getString("nameMachine"));
				configMachine.setNumberOfProducts(resultSet.getInt("numberOfProducts"));
				configMachine.setNameOfProductsFinal(resultSet.getString("nameOfProductsFinal"));
				configMachine.setNameOfProducts(resultSet.getString("nameOfProducts"));
				configMachine.setQuantityOfProducts(resultSet.getDouble("quantityOfProducts"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeConnection(connection);
		}
		return configMachine;
	}
	//get ConfigMachine by numberOfProducts	
	public ConfigMachine getConfigMachineByNumberOfProducts(int numberOfProducts) {
		DBHelper dbHelper = new DBHelper();
		Connection connection = dbHelper.getConnection();
		String sql = "SELECT * FROM config_machine WHERE numberOfProducts = ?";
		// Execute the SQL statement here
		PreparedStatement preparedStatement = null;
		ConfigMachine configMachine = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, numberOfProducts);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				configMachine = new ConfigMachine();
				configMachine.setId(resultSet.getInt("id"));
				configMachine.setNameMachine(resultSet.getString("nameMachine"));
				configMachine.setNumberOfProducts(resultSet.getInt("numberOfProducts"));
				configMachine.setNameOfProductsFinal(resultSet.getString("nameOfProductsFinal"));
				configMachine.setNameOfProducts(resultSet.getString("nameOfProducts"));
				configMachine.setQuantityOfProducts(resultSet.getDouble("quantityOfProducts"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeConnection(connection);
		}
		return configMachine;
	}
}
