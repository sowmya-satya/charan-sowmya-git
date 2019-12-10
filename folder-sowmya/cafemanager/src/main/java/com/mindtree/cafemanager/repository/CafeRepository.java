package com.mindtree.cafemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.cafemanager.entity.Cafe;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer>{

}
