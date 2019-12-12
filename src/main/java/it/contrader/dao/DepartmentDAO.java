package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Department;
import it.contrader.utils.ConnectionSingleton;

public class DepartmentDAO {
	

	private final String QUERY_ALL = "SELECT * FROM department";
	private final String QUERY_CREATE = "INSERT INTO department (name, number_operators) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM department WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE department SET name=?, number_operators=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM department WHERE id=?";

	public DepartmentDAO() {

	}

	public List<Department> getAll() {
		List<Department> departmentsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Department department;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int number_operators = resultSet.getInt("number_operators");

				department = new Department(name, number_operators);
				department.setId(id);
				departmentsList.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departmentsList;
	}

	public boolean insert(Department departmentToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, departmentToInsert.getName());
			preparedStatement.setInt(2, departmentToInsert.getNumber_operators());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Department read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name;
			int number_operators;

			name = resultSet.getString("name");
			number_operators = resultSet.getInt("number_operators");
			
			Department department = new Department(name, number_operators);
			department.setId(resultSet.getInt("id"));

			return department;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Department departmentToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		
		if (departmentToUpdate.getId() == 0)
			return false;

		Department departmentRead = read(departmentToUpdate.getId());
		if (!departmentRead.equals(departmentToUpdate)) {
			try {
				
				if (departmentToUpdate.getName() == null || departmentToUpdate.getName().equals("")) {
					departmentToUpdate.setName(departmentRead.getName());
				}

				
				
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, departmentToUpdate.getName());
				preparedStatement.setInt(2, departmentToUpdate.getNumber_operators());
				preparedStatement.setInt(3, departmentToUpdate.getId());
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
