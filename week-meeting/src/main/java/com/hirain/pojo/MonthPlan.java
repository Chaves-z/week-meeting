package com.hirain.pojo;

public class MonthPlan {
	private Long id;

	private Long userid;

	private String projectname;

	private String messioncontent;

	private String messionstate;

	private String messionprogress;

	private String deadline;

	private String accomplishtime;

	private String date;

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

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname == null ? null : projectname.trim();
	}

	public String getMessioncontent() {
		return messioncontent;
	}

	public void setMessioncontent(String messioncontent) {
		this.messioncontent = messioncontent == null ? null : messioncontent.trim();
	}

	public String getMessionstate() {
		return messionstate;
	}

	public void setMessionstate(String messionstate) {
		this.messionstate = messionstate == null ? null : messionstate.trim();
	}

	public String getMessionprogress() {
		return messionprogress;
	}

	public void setMessionprogress(String messionprogress) {
		this.messionprogress = messionprogress == null ? null : messionprogress.trim();
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline == null ? null : deadline.trim();
	}

	public String getAccomplishtime() {
		return accomplishtime;
	}

	public void setAccomplishtime(String accomplishtime) {
		this.accomplishtime = accomplishtime == null ? null : accomplishtime.trim();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}