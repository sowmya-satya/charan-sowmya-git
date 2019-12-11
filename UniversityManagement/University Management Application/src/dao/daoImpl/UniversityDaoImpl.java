package dao.daoImpl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UniversityDao;
import entity.University;
import exception.DButilityException;
import exception.DaoException;
import utility.DbUtil;

public class UniversityDaoImpl implements UniversityDao {

	//static University university = new University();

	@Override
	public String registerUniversity(int universityId, String universityName) throws DaoException {
		// TODO Auto-generated method stub
		int row = 0;

		try {
			PreparedStatement pstmt = null;

			Connection con = null;
			con = DbUtil.getConnection();
			
			if (con != null) {
				System.out.println("Connected");
			}
				
			String sql = "insert into university(universityId,universityName) values(?,?)";

			
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, universityId);

			pstmt.setString(2, universityName);

		    row = pstmt.executeUpdate();

			if (row > 0) {
				System.out.println("Inserted");
			} else {
				System.out.println("Not inserted");
			}
			pstmt.close();

			DbUtil.closeConnection(con);
			} catch (DButilityException e) {
				throw new DaoException(e);
			} catch (SQLException e) {
			throw new DaoException(e);
		}
		return universityName;


	}

	@Override
	public List<University> displayUniversity() throws DaoException {
		// TODO Auto-generated method stub
		List<University> universityList = new ArrayList<University>();
		try {
			Connection con = null;
			con = DbUtil.getConnection();

			if (con != null) {
				System.out.println("Connected");
			}
			String sql = "select * from university";

			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(sql);

			ResultSet rs = null;
			rs = pstmt.executeQuery();
			while (rs.next()) {
				University university = new University();

				university.setUniversityId(rs.getInt(1));
				university.setUniversityName(rs.getString(2));
				universityList.add(university);
			}
			
			pstmt.close();
			rs.close();

			DbUtil.closeConnection(con);
		} catch (DButilityException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}

		return universityList;
	}

}
