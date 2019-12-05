package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Machine;
import it.contrader.model.User;

public class MachineDAO {

	private final String QUERY_ALL = "SELECT * FROM machine";
	private final String QUERY_CREATE = "INSERT INTO machine (name, number_sensor) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM machine WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE machine SET name=?, number_sensor=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM machine WHERE id=?";
	
	public MachineDAO() { }
	
	
	public List<Machine> getAll() {
		List<Machine> machinesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Machine machine;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int number_sensors = Integer.parseInt(resultSet.getString("number_sensor"));
				machine = new Machine(name, number_sensors);
				machine.setId(id);
				machinesList.add(machine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return machinesList;
	}

	public boolean insert(Machine machineToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, machineToInsert.getName());
			preparedStatement.setInt(2, machineToInsert.getNumber_sensors());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Machine read(int machineId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, machineId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name;
			int number_sensors;

			name = resultSet.getString("name");
			number_sensors = Integer.parseInt(resultSet.getString("number_sensor"));
			Machine machine = new Machine(name, number_sensors);
			machine.setId(resultSet.getInt("id"));
			return machine;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Machine machineToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (machineToUpdate.getId() == 0)
			return false;

		Machine machineRead = read(machineToUpdate.getId());
		if (!machineRead.equals(machineToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (machineToUpdate.getName() == null || machineToUpdate.getName().equals("")) {
					machineToUpdate.setName(machineRead.getName());
				}
				/*
				if (userToUpdate.getPassword() == null || userToUpdate.getPassword().equals("")) {
					userToUpdate.setPassword(userRead.getPassword());
				}
				*/

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, machineToUpdate.getName());
				preparedStatement.setInt(2, machineToUpdate.getNumber_sensors());
				preparedStatement.setInt(3, machineToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
