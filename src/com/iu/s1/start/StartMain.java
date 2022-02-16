package com.iu.s1.start;

import java.util.List;

import com.iu.s1.employee.EmployeeDAO;
import com.iu.s1.employee.EmployeeDTO;
import com.iu.s1.employee.EmployeeView;
import com.iu.s1.region.RegionDAO;
import com.iu.s1.region.RegionDTO;

public class StartMain {

	public static void main(String[] args) throws Exception {
		System.out.println("DB 연동 테스트 시작");
		
		FrontController fc = new FrontController();
		fc.mainStart();
		
		System.out.println("DB 연동 테스트 끝");
	}

}
