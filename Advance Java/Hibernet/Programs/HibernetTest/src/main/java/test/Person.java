package test;

public class Person {
	private int id;
	private String name;
	private String city;
	private double salary;
	
	public Person() {
	
	}
	
	
	public Person( String name, String city, double salary) {
		super();
		this.name = name;
		this.city = city;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
