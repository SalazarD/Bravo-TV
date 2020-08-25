package com.bean;

import com.annotations.*;

public class Mock {

	@Value
	private int id;
	
	@Value
	private String msg;
	
	@Override
	public String toString() {
		return String.format("[Mock id=%d msg=%s]", id, msg);
	}
}
