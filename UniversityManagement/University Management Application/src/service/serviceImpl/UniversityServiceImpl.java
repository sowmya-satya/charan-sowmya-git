package service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import dao.CollegeDao;
import dao.UniversityDao;
import dao.daoImpl.CollegeDaoImpl;
import dao.daoImpl.UniversityDaoImpl;
import entity.College;
import entity.University;
import exception.DaoException;
import service.UniversityService;

public class UniversityServiceImpl implements UniversityService {

	UniversityDao universityDao = new UniversityDaoImpl();
	
	static CollegeDao collegeDao = new CollegeDaoImpl();

	@Override
	public String registerUniversity(int universityId, String universityName) {
		// TODO Auto-generated method stub
		String message = null;
		try {
			message = universityDao.registerUniversity(universityId, universityName);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public List<University> displayUniversityDetails() {
		// TODO Auto-generated method stub
		List<University> university = new ArrayList<>();
		try {
			university = universityDao.displayUniversity();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return university;
	}

	@Override
	public List<College> listColleges(int universityId) {
		// TODO Auto-generated method stub
		List<College> colleges = new ArrayList<>();
		colleges = collegeDao.listColleges(universityId);
		return colleges;
	}

}
