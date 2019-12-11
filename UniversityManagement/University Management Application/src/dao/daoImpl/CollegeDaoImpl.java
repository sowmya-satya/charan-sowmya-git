package dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CollegeDao;
import entity.College;
import exception.DButilityException;
import exception.DaoException;
import utility.DbUtil;

public class CollegeDaoImpl implements CollegeDao {
	
	@Override
	public String registerCollege(int universityId, int collegeId, String collegeName, int collegeRating) throws DaoException {
		// TODO Auto-generated method stub
		String message = "";
		Connection con = null;

		try {
			
			con = DbUtil.getConnection();

			if (con != null) {
				System.out.println("Connected");
			}
			String sql = "insert into college(collegeId,collegeName,collegeRating,universityId) values(?,?,?,?)";

			PreparedStatement pstmt = null;

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, collegeId);

			pstmt.setString(2, collegeName);

			pstmt.setInt(3, collegeRating);

			pstmt.setInt(4, universityId);

			int row = pstmt.executeUpdate();

			if (row > 0) {
				System.out.println("Inserted");
			} else {
				System.out.println("Not inserted");
			}
			pstmt.close();
		DbUtil.closeConnection(con);
		} catch (DButilityException e) {
			throw new DaoException(e);
		}catch(SQLException e) {
			throw new DaoException(e);
		}
		return message;

	}

	@Override
	public List<College> listColleges(int universityId) throws DaoException {
		// TODO Auto-generated method stub
		List<College> colleges = new ArrayList<College>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DbUtil.getConnection();
			if (con != null) {
				System.out.println("Connected");
			}
			String sql = "Select * from college where universityId=?";
			pstmt.setInt(1, universityId);

		} catch (DButilityException e) {
			throw new DaoException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
