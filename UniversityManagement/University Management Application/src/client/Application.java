package client;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entity.College;
import entity.University;
import exception.DaoException;
import service.CollegeService;
import service.UniversityService;
import service.serviceImpl.CollegeServiceImpl;
import service.serviceImpl.UniversityServiceImpl;

public class Application {

	static Scanner scan = new Scanner(System.in);

	static University university = new University();

	static UniversityService universityService = new UniversityServiceImpl();

	static CollegeService collegeService = new CollegeServiceImpl();
	
	static List<University> universityList;
	
	static College college = new College();

	public static void main(String[] args) {

		int x = 0;
		do {
			System.out.println("Enter your choice");
			System.out.println("Press 1 to register a university");
			System.out.println("Press 2 to register a college");
			System.out.println("Press 3 to display the list of colleges under university");
			System.out.println("Press 4 to display the college details whose rating is greater than entered rating");
			System.out.println("press 5 to exit");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				registerUniversity();
				break;
			case 2:
				registerCollege();
				break;
			case 3:
				listColleges();
				break;
			case 4:
				
			case 5:
				System.exit(0);
			}
			System.out.println("Press 9 to go to main menu");
			x = scan.nextInt();

		} while (x == 9);

	}

	private static void listColleges() {
		// TODO Auto-generated method stub
		System.out.println("Enter the university Id");
		university.setUniversityId(scan.nextInt());
		List<College> collegeList = universityService.listColleges(university.getUniversityId());
	}

	private static void registerCollege() {
		// TODO Auto-generated method stub
		List<University> universityList = universityService.displayUniversityDetails();
		universityList.stream().collect(Collectors.toList()).forEach(System.out::println);
		//System.out.println(university);
		System.out.println("Enter the university Id");
		university.setUniversityId(scan.nextInt());
		System.out.println("Enter the college Id");
		college.setCollegeId(scan.nextInt());
		System.out.println("Enter the college name");
		college.setCollegeName(scan.next());
		System.out.println("Enter the college rating");
		college.setCollegeRating(scan.nextInt());
		try {
			collegeService.registerCollege(university.getUniversityId(),college.getCollegeId(),college.getCollegeName(),college.getCollegeRating());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void registerUniversity() {
		// TODO Auto-generated method stub
		System.out.println("Enter the university Id");
		university.setUniversityId(scan.nextInt());
		System.out.println("Enter the university Name");
		university.setUniversityName(scan.next());
		universityService.registerUniversity(university.getUniversityId(), university.getUniversityName());
		System.out.println("Registration successful");
		System.out.println(university.getUniversityId()+" "+university.getUniversityName());
		//university = universityService.registerUniversity(universityList);
	}

}
