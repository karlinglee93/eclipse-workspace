package com.oa.po;

public class Label {
	private int id;
	private String name;
	private String basises;
	private int level;
	private String period;
	private String secretScope;
	private int type;
	private String procDefUniqueId;
	private String organs_id;
	private String organs_name;
	
	Label(int id, String name, String basises, int level, String period, String secretScope, int type,
			String procDefUniqueId, String organs_id, String organs_name) {
		super();
		this.id = id;
		this.name = name;
		this.basises = basises;
		this.level = level;
		this.period = period;
		this.secretScope = secretScope;
		this.type = type;
		this.procDefUniqueId = procDefUniqueId;
		this.organs_id = organs_id;
		this.organs_name = organs_name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getSecretScope() {
		return secretScope;
	}
	public void setSecretScope(String secretScope) {
		this.secretScope = secretScope;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getProcDefUniqueId() {
		return procDefUniqueId;
	}
	public void setProcDefUniqueId(String procDefUniqueId) {
		this.procDefUniqueId = procDefUniqueId;
	}
	public String getOrgans_id() {
		return organs_id;
	}
	public void setOrgans_id(String organs_id) {
		this.organs_id = organs_id;
	}
	public String getOrgans_name() {
		return organs_name;
	}
	public void setOrgans_name(String organs_name) {
		this.organs_name = organs_name;
	}
}
