package com.iu.s1.location;

import java.util.List;
import java.util.Scanner;

public class LocationController {
	private LocationDAO locationDAO;
	private LocationView locationView;
	private Scanner sc = null;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
		sc = new Scanner(System.in); 
	}
	
	public void start() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 지역정보 출력");
			System.out.println("2. 지역번호 검색");
			System.out.println("3. 나가기");
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				List<LocationDTO> ar = locationDAO.getList();
				locationView.view(ar);
				break;
			case 2:
				System.out.println("검색할 지역번호를 입력하세요: ");
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(sc.nextInt());
				locationDTO = locationDAO.getOne(locationDTO);
				locationView.view(locationDTO);
			default:
				flag = false;
				break;
			}
		}
	}

}
