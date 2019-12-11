package Assignments;

import java.util.Comparator;

public class EmployeeList implements Comparable<EmployeeList> {
	private String empID;
	private String empName;
	private int empAge;
	private double empSalary;
	
	public EmployeeList(String empID, String empName, int empAge, double empSalary) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empAge = empAge;
		this.empSalary = empSalary;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	
	public static final Comparator<EmployeeList> IdComparator = new Comparator<EmployeeList>() {

		@Override
		public int compare(EmployeeList e1, EmployeeList e2) {
			return e1.getEmpID().compareTo(e1.getEmpID());
		}
		
	};
	
	@Override
	public String toString() {
		return "EmployeeList [empID=" + empID + ", empName=" + empName + ", empAge=" + empAge + ", empSalary="
				+ empSalary + "]";
	}
	
	@Override
	public int compareTo(EmployeeList e) {
		if(!(this.getEmpID().equals(e.getEmpID()))) {
			if(this.getEmpID().compareTo(e.getEmpID()) > 0) {
				return 1;
			}
			else if(this.getEmpID().compareTo(e.getEmpID()) < 0) {
				return -1;
			}
			else
				return 0;
		}
		else if(!(this.getEmpName().equals(e.getEmpName()))) {
			if(this.getEmpName().compareTo(e.getEmpName()) > 0) {
				return 1;
			}
			else if(this.getEmpName().compareTo(e.getEmpName()) < 0) {
				return -1;
			}
			else
				return 0;
		}
		else if(!(this.getEmpAge() == e.getEmpAge())) {
			return this.getEmpAge() - e.getEmpAge();
		}
		else if(!(this.getEmpSalary() == e.getEmpSalary())) {
			return (int)(this.getEmpSalary() - e.getEmpSalary());
		}
		return 0;
		
	}
//	
//	@Override
//	public int compareTo(EmployeeList e) {
//		if(this.getEmpName().compareTo(e.getEmpName()) > 0) {
//			return 1;
//		}
//		else if(this.getEmpName().compareTo(e.getEmpName()) < 0) {
//			return -1;
//		}
//		else
//			return 0;
//		
//	}
	
//	@Override
//	public int compareTo(EmployeeList e) {
//		return this.getEmpAge() - e.getEmpAge();
//		
//	}
	
//	@Override
//	public int compareTo(EmployeeList e) {
//		return (int)(this.getEmpSalary() - e.getEmpSalary());
//		
//	}
	
}
