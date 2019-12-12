package service.serviceImpl;

import dao.CollegeDao;
import dao.daoImpl.CollegeDaoImpl;
import exception.DaoException;
import service.CollegeService;

public class CollegeServiceImpl implements CollegeService{
	
	static CollegeDao collegeDao = new CollegeDaoImpl();

	@Override
	public String registerCollege(int universityId, int collegeId, String collegeName, int collegeRating){
		// TODO Auto-generated method stub
		String message = null;
		try {
			collegeDao.registerCollege(universityId, collegeId, collegeName, collegeRating);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
