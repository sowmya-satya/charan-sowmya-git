package service;

import exception.DaoException;

public interface CollegeService {

	String registerCollege(int universityId, int collegeId, String collegeName, int collegeRating) throws DaoException;

}
