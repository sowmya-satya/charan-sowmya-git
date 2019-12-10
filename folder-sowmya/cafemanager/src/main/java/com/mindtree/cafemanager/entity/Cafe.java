package com.mindtree.cafemanager.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="cafe")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cafe {
	
	@Id
	@Column(name = "cafe_id")
	private int cafeId;
	
	@Column(name = "cafe_name")
	private String cafeName;
	
	@Column(name = "cafe_revenue")
	private int revenue;
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.ALL)
	private Manager manager;
	
	

	public Cafe() {
		super();
	}

	public Cafe(int cafeId, String cafeName, int revenue, Manager manager) {
		super();
		this.cafeId = cafeId;
		this.cafeName = cafeName;
		this.revenue = revenue;
		this.manager = manager;
	}

	public int getCafeId() {
		return cafeId;
	}

	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}

	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
//@JsonIgnore
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Cafe [cafeId=" + cafeId + ", cafeName=" + cafeName + ", revenue=" + revenue + ", manager=" + manager
				+ "]";
	}

}
