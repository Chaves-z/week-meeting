package com.hirain.pojo;

public class Plan {
	private Long id;

	private Long userid;

	private String date;

	private String lastweek;

	private String currentweek;

	private String problem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLastweek() {
		return lastweek;
	}

	public void setLastweek(String lastweek) {
		this.lastweek = lastweek == null ? null : lastweek.trim();
	}

	public String getCurrentweek() {
		return currentweek;
	}

	public void setCurrentweek(String currentweek) {
		this.currentweek = currentweek == null ? null : currentweek.trim();
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem == null ? null : problem.trim();
	}
}