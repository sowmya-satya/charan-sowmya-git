package com.mindtree.cafemanager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.cafemanager.apiconfig.ApiResponse;
import com.mindtree.cafemanager.entity.Cafe;
import com.mindtree.cafemanager.entity.Manager;
import com.mindtree.cafemanager.exception.ServiceException;
import com.mindtree.cafemanager.service.CafeService;
import com.mindtree.cafemanager.service.ManagerService;

//@RequestMapping(path = "/cafe")
@RestController

public class Controller {

	@Autowired
	private CafeService cafeservice;

	@Autowired
	private ManagerService managerservice;

	@PostMapping(path = "/addcafe")
	public String addCafeWithManager(@RequestBody Cafe cafe) {
		String temp = null;
		temp = cafeservice.addCafeWithManager(cafe);
		return temp;

	}

	@GetMapping(path = "/getallcafe/{managerId}")
	public ApiResponse getallcafe(@PathVariable int managerId) {

		ApiResponse response = new ApiResponse();

		List<Cafe> cafesList = new ArrayList<Cafe>();

		try {
			cafesList = cafeservice.getallcafe(managerId);

			response.setBody(cafesList);
			response.setMessage("Successfully retireved");
			response.setSuccess(true);
			response.setError(false);

		} catch (ServiceException e) {
			response.setBody("Retriving falied");
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setError(true);
		}

		return response;

	}

	@GetMapping(path = "/getallmanagercafe/{revenue}")
	public ApiResponse getAllManagerCafeByRevenue(@PathVariable int revenue) {

		ApiResponse response = new ApiResponse();

		Set<Cafe> cafesSet = null;
		try {
			cafesSet = cafeservice.getAllManagerCafeByRevenue(revenue);

			response.setBody(cafesSet);
			response.setMessage("Successfully retireved");
			response.setSuccess(true);
			response.setError(false);

		} catch (ServiceException e) {
			response.setBody("Retriving falied");
			response.setMessage(e.getMessage());
			response.setSuccess(false);
			response.setError(true);
		}

		return response;
	}
}
