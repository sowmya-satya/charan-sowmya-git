package com.mindtree.cafemanager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "manager")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Manager {
	
	@Id
	@Column(name = "manager_id")
	private int managerId;
	
	@Column(name ="manager_name")
	private String managerName;
	
	@Column(name = "salary")
	private int salary;
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL,mappedBy="manager")
	private List<Cafe> cafes;
	
	

	public Manager() {
		super();
	}

	public Manager(int managerId, String managerName, int salary, List<Cafe> cafes) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.salary = salary;
		this.cafes = cafes;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
@JsonIgnore
	public List<Cafe> getCafes() {
		return cafes;
	}

	public void setCafes(List<Cafe> cafes) {
		this.cafes = cafes;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", salary=" + salary + ", cafes="
				+ cafes + "]";
	}
	

}
