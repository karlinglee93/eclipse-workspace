package com.oa.po;

public class Label {
	private int id;
	private static String name;
	private String basises;
	private static int level;
	private static String period;
	private static String secretScope;
	private static int type;
	private static String procDefUniqueId;
	private static String organs_id;
	private static String organs_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Label.name = name;
	}
	public String getBasises() {
		return basises;
	}
	public void setBasises(String basises) {
		this.basises = basises;
	}
	public static int getLevel() {
		return level;
	}
	public static void setLevel(int level) {
		Label.level = level;
	}
	public static String getPeriod() {
		return period;
	}
	public static void setPeriod(String period) {
		Label.period = period;
	}
	public static String getSecretScope() {
		return secretScope;
	}
	public static void setSecretScope(String secretScope) {
		Label.secretScope = secretScope;
	}
	public static int getType() {
		return type;
	}
	public static void setType(int type) {
		Label.type = type;
	}
	public static String getProcDefUniqueId() {
		return procDefUniqueId;
	}
	public static void setProcDefUniqueId(String procDefUniqueId) {
		Label.procDefUniqueId = procDefUniqueId;
	}
	public static String getOrgans_id() {
		return organs_id;
	}
	public static void setOrgans_id(String organs_id) {
		Label.organs_id = organs_id;
	}
	public static String getOrgans_name() {
		return organs_name;
	}
	public static void setOrgans_name(String organs_name) {
		Label.organs_name = organs_name;
	}
	
	
}
