package example.model;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class User {
	protected int id;
	protected String fname;
	protected String lname;
	protected double salary;
	protected String department;
	protected String position;
	protected String email;
	protected String mobno;
	
	

	public User(int id, String fname, String lname, double salary, String department, String position, String email,
			String mobno) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
		this.department = department;
		this.position = position;
		this.email = email;
		this.mobno = mobno;
	}
	public User(String fname, String lname, double salary, String department, String position, String email,
			String mobno) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
		this.department = department;
		this.position = position;
		this.email = email;
		this.mobno = mobno;
		
	}





	public User() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}


	
}
