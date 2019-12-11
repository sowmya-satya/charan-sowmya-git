package dao;

import java.util.List;

import entity.University;
import exception.DaoException;

public interface UniversityDao {

	//University registerUniversity(int universityId, String universityName) throws DaoException;

	//List<University> registerUniversity(List<University> universityList) throws DaoException;

	String registerUniversity(int universityId, String universityName) throws DaoException;

	List<University> displayUniversity() throws DaoException;

}
