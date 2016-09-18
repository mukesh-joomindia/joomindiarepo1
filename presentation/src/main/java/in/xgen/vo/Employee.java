package in.xgen.vo;

public class Employee {
	private int empId;
	 private String name;
	 private Long salary;
	 private int age;
	 /**
	  * @return the empId
	  */
	 public int getEmpId() {
	  return empId;
	 }
	 /**
	  * @param empId the empId to set
	  */
	 public void setEmpId(int empId) {
	  this.empId = empId;
	 }
	 /**
	  * @return the name
	  */
	 public String getName() {
	  return name;
	 }
	 /**
	  * @param name the name to set
	  */
	 public void setName(String name) {
	  this.name = name;
	 }
	 /**
	  * @return the salary
	  */
	 public Long getSalary() {
	  return salary;
	 }
	 /**
	  * @param salary the salary to set
	  */
	 public void setSalary(Long salary) {
	  this.salary = salary;
	 }
	 /**
	  * @return the age
	  */
	 public int getAge() {
	  return age;
	 }
	 /**
	  * @param age the age to set
	  */
	 public void setAge(int age) {
	  this.age = age;
	 }
	 
	 public String toString(){
	  return "Employee{ name-"+name+" age-"+age+" salary-"+salary+"}";
	 }
}
