package withjdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("jdbctemplate.xml");

		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeedao");
//		Employee employee = new Employee(101, "Steven", "Chennai");
//		employeeDAO.insert(employee);

//		List<Employee> employees = employeeDAO.findByEmployeeId(101);

		Employee employee = employeeDAO.findByEmployeeId(102);
		System.out.println(employee);

//		List<Employee> employees = employeeDAO.findALLEmployees();
//		for (Employee emp : employees) {
//			System.out.println(emp);
//
//		}
//		List<Customer> customers = customerDAO.listCustomers();
//		for (Customer record : customers) {
//			System.out.print("ID : " + record.getCustId());
//			System.out.print(", Name : " + record.getName());
//			System.out.println(", Age : " + record.getAddress());
//		}
//		System.out.println("----Updating Record with ID = 2 -----");
//		customerDAO.update(2, "MOMBO");
	}
}
