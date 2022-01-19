package com.iu.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.s1.util.DBConnector;

public class DepartmentDAO {
	// DAO : Data Access Object
	private DBConnector dbConnector;

	public DepartmentDAO() {
		dbConnector = new DBConnector();
	}
	
	public List<DepartmentDTO> getList() throws Exception {
		ArrayList<DepartmentDTO> ar = new ArrayList<>();
		
		// SELECT * FROM DEPARTMENTS
		// 1. DB 로그인
		Connection conn = dbConnector.getConnect();
		
		// 2. SQL Query문 작성
		// java에서는 ; 제외
		String sql = "SELECT * FROM DEPARTMENTS";
		
		// 3. 작성한 SQL Query를 미리 전송
		PreparedStatement st = conn.prepareStatement(sql);
		
		// 4. ? 값을 세팅, 없으면 통과
		
		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		// cursor가 한 줄 읽는 메서드 next() 리턴은 데이터가 있으면 true, 없으면 false
		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			// String name = rs.getString("department_name");	// adminstratoin
			// departmentDTO.setDepartment_name(name);
			
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			departmentDTO.setLocation_id(rs.getInt("Location_id"));
			
			// arrayList
			ar.add(departmentDTO);
			
		}
		
		// 6. 외부 연결 해제
		// 연결된 순서의 역순
		rs.close();
		st.close();
		conn.close();
		
		return ar;
	}
}
