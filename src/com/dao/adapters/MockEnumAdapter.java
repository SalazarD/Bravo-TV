package com.dao.adapters;
import com.bean.MockEnum;
import com.dao.DaoAdapter;

public class MockEnumAdapter implements DaoAdapter<MockEnum, Integer> {

	@Override
	public Integer adaptToOutput(MockEnum value) {
		if (value == null) return null;
		switch(value) {
			case TYPE1:
				return 1;
			case TYPE2:
				return 2;
			default:
				return null;
		}
	}

	@Override
	public MockEnum adaptToInput(Integer value) {
		if (value == null) return null;
		switch(value) {
			case 1:
				return MockEnum.TYPE1;
			case 2:
				return MockEnum.TYPE2;
			default:
				return null;
		}
	}

}
