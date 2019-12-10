package com.mindtree.cafemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.cafemanager.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{

}
