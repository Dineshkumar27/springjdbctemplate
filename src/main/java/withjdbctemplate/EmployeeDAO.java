package withjdbctemplate;

import java.util.List;

import javax.sql.DataSource;

public interface EmployeeDAO {
	public void setDataSource(DataSource ds);

	public void insert(Employee employee);

//	public List<Employee> findByEmployeeId(int empId);
	public Employee findByEmployeeId(int empId);

	public List<Employee> findALLEmployees();

}
