package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Operator;

public class OperatorDAO {

	

	private final String QUERY_ALL = "SELECT * FROM operator";
	private final String QUERY_CREATE = "INSERT INTO operator (name, type) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM operator WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE operator SET name=?, type=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM operator WHERE id=?";

	public OperatorDAO() {

	}

	public List<Operator> getAll() {
		List<Operator> operatorsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Operator operator;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String type = resultSet.getString("type");

				operator = new Operator(name, type);
				operator.setId(id);
				operatorsList.add(operator);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return operatorsList;
	}

	public boolean insert(Operator operatorToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, operatorToInsert.getName());
			preparedStatement.setString(2, operatorToInsert.getType());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Operator read(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name;
			String type;

			name = resultSet.getString("name");
			type = resultSet.getString("type");
			
			Operator operator = new Operator(name, type);
			operator.setId(resultSet.getInt("id"));

			return operator;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Operator operatorToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		
		if (operatorToUpdate.getId() == 0)
			return false;

		Operator departmentRead = read(operatorToUpdate.getId());
		if (!departmentRead.equals(operatorToUpdate)) {
			try {
				
				if (operatorToUpdate.getName() == null || operatorToUpdate.getName().equals("")) {
					operatorToUpdate.setName(departmentRead.getName());
				}

				
				if (operatorToUpdate.getType() == null || operatorToUpdate.getType().equals("")) {
					operatorToUpdate.setType(departmentRead.getType());
				}
				
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, operatorToUpdate.getName());
				preparedStatement.setString(2, operatorToUpdate.getType());
				preparedStatement.setInt(3, operatorToUpdate.getId());
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
