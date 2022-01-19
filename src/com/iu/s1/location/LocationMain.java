package com.iu.s1.location;

import java.util.List;

public class LocationMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");
		
		LocationDAO locationDAO = new LocationDAO();
		LocationView locationView = new LocationView();
		
		try {
			List<LocationDTO> ar = locationDAO.getList();
			locationView.view(ar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("DB 연동 테스트 종료");
	}

}
