package com.dinesh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

public class JdbcCustomerDAO implements CustomerDAO {

	private DataSource dataSource;

	// Connection establishment with DB
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Customer customer) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO CUSTOMERs " + "(ID, NAME, ADDRESS) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getAddress());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM CUSTOMERs WHERE ID = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getInt("ID"), rs.getString("NAME"), rs.getString("Address"));
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public List<Customer> listCustomers() {
		String sql = "select * from Customers";
		Connection conn = null;
		List<Customer> customers = new ArrayList();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				customers.add(new Customer(rs.getInt("ID"), rs.getString("NAME"), rs.getString("Address")));
			}
			rs.close();
			ps.close();
			System.out.println(customers.size());
			return customers;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public void update(int id, String address) {
		String sql = "update Customers set address = ? where id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(2, id);
			ps.setString(1, address);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		System.out.println("Updated Record with ID = " + id);

	}

}
