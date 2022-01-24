package com.iu.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.iu.s1.util.DBConnector;

public class EmployeeDAO {
	private DBConnector dbConn;
	
	public EmployeeDAO() {
		dbConn = new DBConnector();
	}
	
	public EmployeeDTO getOne(EmployeeDTO emp) throws Exception {
		EmployeeDTO employeeDTO = null;
		
		Connection conn = dbConn.getConnect();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		PreparedStatement st = conn.prepareStatement(sql);
		// index 1부터 시작
		st.setInt(1, emp.getEmployee_id());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("employee_id"));
			employeeDTO.setFirst_name(rs.getString("first_name"));
			employeeDTO.setLast_name(rs.getString("last_name"));
			employeeDTO.setEmail(rs.getString("email"));
			employeeDTO.setPhone_number(rs.getString("phone_number"));
			employeeDTO.setHire_date(rs.getString("hire_date"));
			employeeDTO.setJob_id(rs.getString("job_id"));
			employeeDTO.setSalary(rs.getInt("salary"));
			employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
			employeeDTO.setManager_id(rs.getInt("manager_id"));
			employeeDTO.setDepartment_id(rs.getInt("department_id"));	
		}
		
		rs.close();
		st.close();
		conn.close();
		return employeeDTO;
		
	}
	
	public List<EmployeeDTO> getList() throws Exception {
		
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		
		Connection conn = dbConn.getConnect();
		
		String sql = "SELECT * FROM EMPLOYEES";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("employee_id"));
			employeeDTO.setFirst_name(rs.getString("first_name"));
			employeeDTO.setLast_name(rs.getString("last_name"));
			employeeDTO.setEmail(rs.getString("email"));
			employeeDTO.setPhone_number(rs.getString("phone_number"));
			employeeDTO.setHire_date(rs.getString("hire_date"));
			employeeDTO.setJob_id(rs.getString("job_id"));
			employeeDTO.setSalary(rs.getInt("salary"));
			employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
			employeeDTO.setManager_id(rs.getInt("manager_id"));
			employeeDTO.setDepartment_id(rs.getInt("department_id"));
			
			ar.add(employeeDTO);
		}
		
		rs.close();
		st.close();
		conn.close();
		
		return ar;
		
	}
}



	

	

