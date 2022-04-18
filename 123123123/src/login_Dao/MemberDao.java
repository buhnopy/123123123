package login_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import login_Dto.MemberDto;

public class MemberDao {
	
	private MemberDao() {}
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public Connection getConnection() {
		
		try {
			
			Context initCtx = new InitialContext();
    		Context envCtx = (Context)initCtx.lookup("java:comp/env"); 
    		DataSource ds = (DataSource)envCtx.lookup("jdbc/pool123");   
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	
	public boolean joinMember(MemberDto memberDto) {
		
		boolean isJoin = false;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE ID = ?");
			
			pstmt.setString(1, memberDto.getId());
			
			rs = pstmt.executeQuery();
			
			if (!rs.next()) {
				
				pstmt = conn.prepareStatement("INSERT INTO MEMBER (ID , PW , NAME , TEL , EMAIL) VALUES (?,?,?,?,?)");
				
				pstmt.setString(1, memberDto.getId());
				pstmt.setString(1, memberDto.getPw());
				pstmt.setString(1, memberDto.getName());
				pstmt.setString(1, memberDto.getTel());
				pstmt.setString(1, memberDto.getEmail());
				
				pstmt.executeUpdate();
				
				isJoin = true;
				
				
			}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)    {try {rs.close();}    catch (SQLException e) {}}
        	if (pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if (conn != null)  {try {conn.close();}  catch (SQLException e) {}}
		}
		
		return isJoin;
		
		
		
		
		
	}
	
	
	
}
