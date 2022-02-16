package com.iu.s1.region;

public class RegionTest {

	public static void main(String[] args) {
		// Region Package내에 있는 것만 Test

		RegionController regionController = new RegionController();

		try {
			regionController.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


