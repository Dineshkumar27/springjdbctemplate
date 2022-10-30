package withjdbctemplate;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcEmployeeDAO implements EmployeeDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public void insert(Employee employee) {
		String sql = "INSERT INTO Employee " + "(ID, NAME, ADDRESS) VALUES (?, ?, ?)";
//		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { employee.getEmpId(), employee.getName(), employee.getAddress() });

	}

//	public List<Employee> findByEmployeeId(int empId) {
//		// TODO Auto-generated method stub
//		String sql = "SELECT * FROM Employee WHERE ID = " + empId;
//		List<Employee> employees = new ArrayList();
//
//		employees = jdbcTemplate.query(sql, new EmployeeRowMapper());
//		return employees;
//	}

	public Employee findByEmployeeId(int empId) {
		String sql = "SELECT empId,name,address FROM Employee WHERE empID = ?";

//		Employee employee = (Employee) jdbcTemplate.queryForObject(sql, 
//		new Object[] { empId },
//				new EmployeeRowMapper());

		Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[] { empId },
				new BeanPropertyRowMapper(Employee.class));
		return employee;
	}

	public List<Employee> findALLEmployees() {
		String sql = "SELECT * FROM Employee";
		List<Employee> employees = jdbcTemplate.query(sql, new EmployeeRowMapper());
		return employees;
	}

}
