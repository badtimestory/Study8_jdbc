package com.iu.s1.start;

import java.util.List;

import com.iu.s1.department.DepartmentDAO;
import com.iu.s1.department.DepartmentDTO;
import com.iu.s1.department.DepartmentView;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentView departmentView = new DepartmentView();
		
		try {
			List<DepartmentDTO> ar = departmentDAO.getList();
			departmentView.view(ar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("DB 연동 테스트 끝");
	}

}
