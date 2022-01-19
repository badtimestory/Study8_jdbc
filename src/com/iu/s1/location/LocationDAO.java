package com.iu.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.s1.util.DBConnector;

// DB에 접근
public class LocationDAO {
	private DBConnector dbConn;
	
	public LocationDAO() {
		dbConn = new DBConnector();
	}
	
	public List<LocationDTO> getList() throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<>();
		
		// 1. DB에 로그인
		Connection conn = dbConn.getConnect();
		
		// 2. SQL Query문 작성 
		String sql = "SELECT * FROM LOCATIONS";
		
		// 3. Query문을 미리 전송 (정적 쿼리 Statement보다 동적 쿼리 PreparedStatement를 사용)
		PreparedStatement st = conn.prepareStatement(sql);
		
		// 4. ? 세팅 통과
		
		// 5. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			
			ar.add(locationDTO);
		}
		
		// 6. 자원 해제 (연결의 역순)
		rs.close();
		st.close();
		conn.close();
		
		return ar;
	}

}
