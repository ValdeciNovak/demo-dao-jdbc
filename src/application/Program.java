package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DBIntegrityExeption;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			st= conn.prepareStatement(
			"DELETE FROM department "
			+ "WHERE "
			+ "Id = ?"
			);
			
			st.setInt(1, 2);
			
			int rowsAffected = st.executeUpdate();

			System.out.println("Done! Rows affected " + rowsAffected);

		} catch (SQLException e) {
			throw new DBIntegrityExeption(e.getMessage());
			// TODO: handle exception
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();	
		}
	}

}
