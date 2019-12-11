package entity;

public class College {

	private int collegeId;
	
	private String collegeName;
	
	private int collegeRating;
	
	private University university;

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public int getCollegeRating() {
		return collegeRating;
	}

	public void setCollegeRating(int collegeRating) {
		this.collegeRating = collegeRating;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public College(int collegeId, String collegeName, int collegeRating, University university) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.collegeRating = collegeRating;
		this.university = university;
	}

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeRating=" + collegeRating
				+ ", university=" + university + "]";
	}
	
	
}
