package com.oa.po;

public class Label {
	private int id;
	private String basises;
	private int level;
	private String duration;
	private String scope;
	
	Label(String basises, int level, String duration, String scope) {
		super();
		this.basises = basises;
		this.level = level;
		this.duration = duration;
		this.scope = scope;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBasises() {
		return basises;
	}
	public void setBasises(String basises) {
		this.basises = basises;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
