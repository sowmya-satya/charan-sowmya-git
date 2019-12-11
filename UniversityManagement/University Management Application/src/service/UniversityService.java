package service;

import java.util.List;

import entity.College;
import entity.University;

public interface UniversityService {

	public String registerUniversity(int universityId, String universityName);

	public List<University> displayUniversityDetails();

	public List<College> listColleges(int universityId);

	
}
