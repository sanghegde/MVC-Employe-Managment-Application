package com.cg.bean;

/**
 * @author Sangeeta
 * 
 *         This is the employee class which maintains the details of each
 *         employee
 *
 */
public class Employee {

	private int id;
	private String name;

	// maintains the next employeeid
	public static int employeeId;

	// gets invoked whenever a class is loaded
	static {
		employeeId = 200;
	}

	// It will give the next employeeid that will be assigned to next employee
	// object
	public static int getNextId() {
		return employeeId + 1;
	}

	// This is a Ctor..
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
