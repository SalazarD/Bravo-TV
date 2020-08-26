package com.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Vod implements Bean{
	private int video_id;
	private String video_name;
	private String video_category;
	private int duration;
	private String frequency;
	private Timestamp video_start_time;
	private Timestamp video_end_time;
	private BigDecimal cost;
	
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}
	public String getVideo_category() {
		return video_category;
	}
	public void setVideo_category(String video_category) {
		this.video_category = video_category;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public Timestamp getVideo_start_time() {
		return video_start_time;
	}
	public void setVideo_start_time(Timestamp video_start_time) {
		this.video_start_time = video_start_time;
	}
	public Timestamp getVideo_end_time() {
		return video_end_time;
	}
	public void setVideo_end_time(Timestamp video_end_time) {
		this.video_end_time = video_end_time;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "Vod [video_id=" + video_id 
				+ ", video_name=" + video_name 
				+ ", video_category=" + video_category
				+ ", duration=" + duration 
				+ ", frequency=" + frequency 
				+ ", video_start_time=" + video_start_time
				+ ", video_end_time=" + video_end_time 
				+ ", cost=" + cost + "]";
	}
	
	private static final String[] COLUMN_NAMES = new String[] {
			"video_id", "video_name", "video_category", "duration", "frequency",
			"video_start_time", "video_end_time", "cost"
	};

	@Override
	public String[] getColumnNames() {
		return COLUMN_NAMES;
	}
	@Override
	public Object[] getColumnValues() {
		return new Object[] { video_id, video_name, video_category, duration, frequency,
				video_start_time, video_end_time, cost
				
		};
	}
	@Override
	public void setColumnValues(Object[] values) {
		video_id = (int) values[0];
		video_name = (String) values[1];
		video_category = (String) values[2];
		duration = (int) values[3];
		frequency = (String) values[4];
		video_start_time = (Timestamp) values[5];
		video_end_time = (Timestamp) values[6];
		cost = (BigDecimal) values[7];
		
	}
	
	
	
}
