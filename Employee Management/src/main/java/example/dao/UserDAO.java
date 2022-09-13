package example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import example.model.User;

public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/abhi?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Abhishek@123";

	private static final String INSERT_USERS_SQL = "INSERT INTO users (fname,lname,salary,department,position, email, mobno) VALUES  (?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_USER_BY_ID = "select fname,lname,salary,department,position, email, mobno from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?";
	private static final String UPDATE_USERS_SQL = "update users set fname = ?,lname=?,salary=?,department=?,position=?,email= ?, mobno =? where id = ?";

	public UserDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getFname());
			preparedStatement.setString(2, user.getLname());
			preparedStatement.setDouble(3, user.getSalary());
			preparedStatement.setString(4, user.getDepartment());
			preparedStatement.setString(5, user.getPosition());
			preparedStatement.setString(6, user.getEmail());
			preparedStatement.setString(7, user.getMobno());
		
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				double salary=rs.getDouble("salary");
				String department = rs.getString("department");
				String position = rs.getString("position");
				String email=rs.getString("email");
				String mobno=rs.getString("mobno");
			    user = new User(id, fname,lname,salary,department,position,email, mobno);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();		
		try (Connection connection = getConnection();

				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				int id = rs.getInt("id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				double salary=rs.getDouble("salary");
				String department = rs.getString("department");
				String position = rs.getString("position");
				String email=rs.getString("email");
				String mobno=rs.getString("mobno");
				users.add(new User(id, fname,lname,salary,department,position, email, mobno));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getFname());
			statement.setString(2, user.getLname());
			statement.setDouble(3, user.getSalary());
			statement.setString(4, user.getDepartment());
			statement.setString(5, user.getPosition());
			statement.setString(6, user.getEmail());
			statement.setString(7, user.getMobno());
			statement.setInt(8, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
