package com.cg.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.bean.Employee;

/**
 * @author Sangeeta
 * 
 *         This is a class for maintaining the list of all unique employee
 *         objects.
 *
 */
public class EmployeeDAO {

	HashMap<Integer, Employee> employee1 = new HashMap<>();

	// adding employee details into database
	public void addEmployee(Map<String, String> employee) {
		Employee employees = new Employee(Integer.parseInt(employee.get("id")), employee.get("name"));
		employee1.put(Integer.parseInt(employee.get("id")), employees);
	}

	// reading data from database
	public HashMap<Integer, Employee> viewAllEmployee() {
		return employee1;
	}

	// getting employeeid from database
	public Employee getEmployeeById(int id) {
		return employee1.get(id);
	}

	// deleting employeeid from database
	public void deleteEmployee(int id) {
		employee1.remove(id);
	}
}
