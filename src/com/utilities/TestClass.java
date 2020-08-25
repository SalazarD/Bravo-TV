package com.utilities;

import java.util.ArrayList;

import com.bean.Mock;
import com.dao.MockDao;

public class TestClass {
	public static void main(String[] args) {
		ArrayList<Mock> mocks = MockDao.getAllMocks();
		for (Mock mock : mocks) {
			System.out.println(mock);
		}
	}
}
