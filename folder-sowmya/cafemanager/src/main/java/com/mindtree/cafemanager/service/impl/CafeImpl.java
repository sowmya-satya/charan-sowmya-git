package com.mindtree.cafemanager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.cafemanager.entity.Cafe;
import com.mindtree.cafemanager.entity.Manager;
import com.mindtree.cafemanager.exception.ManagerNotFoundException;
import com.mindtree.cafemanager.exception.NoSuchCafeExistsException;
import com.mindtree.cafemanager.repository.CafeRepository;
import com.mindtree.cafemanager.repository.ManagerRepository;
import com.mindtree.cafemanager.service.CafeService;

@Service
public class CafeImpl implements CafeService {

	@Autowired
	CafeRepository caferespository;

	@Autowired
	ManagerRepository managerrespository;

	public String addCafeWithManager(Cafe cafe) {

		caferespository.save(cafe);
		return "added";
	}

	public List<Cafe> getallcafe(int managerId) throws ManagerNotFoundException {
		Manager manager = managerrespository.findById(managerId).get();
		List<Cafe> cafe = new ArrayList<Cafe>();
		

		
		cafe = manager.getCafes();
		

		if (!cafe.isEmpty()) {
			return cafe;
		} else {
			throw new ManagerNotFoundException("Manager not found with ID: " + managerId);
		}

	}

	public Set<Cafe> getAllManagerCafeByRevenue(int revenue) throws NoSuchCafeExistsException {
		// TODO Auto-generated method stub
		List<Cafe> cafes = caferespository.findAll();
		HashSet<Cafe> cafelist = new HashSet<Cafe>();
		for (Cafe cafe : cafes) {
			if (cafe.getRevenue() > revenue) {
				cafelist.add(cafe);
			}
		}
		if (!cafelist.isEmpty()) {
			return cafelist;
		} else {
			throw new NoSuchCafeExistsException("No cafe exists below " + revenue);
		}
	}

}
