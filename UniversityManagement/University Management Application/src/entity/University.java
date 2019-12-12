package entity;

public class University {

	private int universityId;
	
	private String universityName;

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Override
	public String toString() {
		return "University [universityId=" + universityId + ", universityName=" + universityName + "]";
	}

	public University(int universityId, String universityName) {
		super();
		this.universityId = universityId;
		this.universityName = universityName;
	}

	public University() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
