package com.mindtree.cafemanager.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mindtree.cafemanager.entity.Cafe;
import com.mindtree.cafemanager.entity.Manager;
import com.mindtree.cafemanager.exception.ManagerNotFoundException;
import com.mindtree.cafemanager.exception.NoSuchCafeExistsException;
import com.mindtree.cafemanager.exception.ServiceException;

public interface CafeService {

	//public String addCafe(int managerId, Cafe cafe);

	public List<Cafe> getallcafe(int managerId) throws ManagerNotFoundException;

	public Set<Cafe> getAllManagerCafeByRevenue(int revenue) throws NoSuchCafeExistsException;

	public String addCafeWithManager(Cafe cafe);

}
