package com.cg.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.controller.EmployeeController;
import com.cg.bean.Employee;

/**
 * @author Sangeeta
 * 
 *         Presentation on the console
 *
 */
public class EmployeeUI {

	Map<String, String> employee = new HashMap<>();
	EmployeeController control;

	// obtaining details of employee
	public void setControl(EmployeeController control) {
		this.control = control;
	}

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	// start the employee application
	public void start() throws NumberFormatException, IOException {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		EmployeeController control = (EmployeeController) context.getBean("controller");
		setControl(control);

		accept();
	}

	// accept the choice from menue
	private void accept() throws NumberFormatException, IOException {

		int choice;
		do {
			System.out.println(
					"Enter choice\n1.Add New Employee\n2.View all employees\n3.Get employee by id\n4.Delete an employee\n5.Exit");
			choice = Integer.parseInt(reader.readLine());

			switch (choice) {
			case 1:
				System.out.println("Enter the Employee Name");
				employee.put("id", String.valueOf(Employee.getNextId()));
				employee.put("name", reader.readLine());
				control.addEmployee(employee);
				break;
			case 2:
				viewAll(control.viewAllEmployee());
				break;
			case 3:
				System.out.println("Enter the Employee ID");
				control.getEmployeeById(Integer.parseInt(reader.readLine()));
				break;
			case 4:
				System.out.println("Enter the Employee ID");
				control.deleteEmployee(Integer.parseInt(reader.readLine()));
				break;
			case 5:
				System.exit(1);
			}
		} while (true);
	}

	// view the details of an employee from the database
	private void viewAll(HashMap<Integer, Employee> viewAllEmployee) {
		Set<Entry<String, String>> set = employee.entrySet();
		set.stream().forEach((element) -> System.out.println(element.getValue() + " " + element.getKey()));
	}
}
