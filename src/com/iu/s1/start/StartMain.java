package com.iu.s1.start;

import java.util.List;

import com.iu.s1.employee.EmployeeDAO;
import com.iu.s1.employee.EmployeeDTO;
import com.iu.s1.employee.EmployeeView;

public class StartMain {

	public static void main(String[] args) throws Exception {
		System.out.println("DB 연동 테스트 시작");
		
		FrontController fc = new FrontController();
		fc.mainStart();
		
//		EmployeeDAO employeeDAO = new EmployeeDAO();
//		EmployeeView ev = new EmployeeView();
//		
//		List<EmployeeDTO> ar = employeeDAO.getList();
//		ev.view(ar);
		
		System.out.println("DB 연동 테스트 끝");
	}

}
