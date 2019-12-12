package dao;

import java.util.List;

import entity.College;
import exception.DaoException;

public interface CollegeDao {

	String registerCollege(int universityId, int collegeId, String collegeName, int collegeRating) throws DaoException;

	List<College> listColleges(int universityId) throws DaoException;

}
