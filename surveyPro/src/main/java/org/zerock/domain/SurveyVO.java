package org.zerock.domain;

public class SurveyVO {

	private int sv_id;
	private String sv_title;
	private String sv_writer;
	private String sv_startdate;
	private String sv_enddate;
	private int sv_hits;
	private int sv_count;
	private String sv_state;
	private String list_content;
	private String list_id;
	
	
	
	public String getList_content() {
		return list_content;
	}
	public void setList_content(String list_content) {
		this.list_content = list_content;
	}
	
	public String getList_id() {
		return list_id;
	}
	public void setList_id(String list_id) {
		this.list_id = list_id;
	}
	public int getSv_id() {
		return sv_id;
	}
	public void setSv_id(int sv_id) {
		this.sv_id = sv_id;
	}
	public String getSv_title() {
		return sv_title;
	}
	public void setSv_title(String sv_title) {
		this.sv_title = sv_title;
	}
	public String getSv_writer() {
		return sv_writer;
	}
	public void setSv_writer(String sv_writer) {
		this.sv_writer = sv_writer;
	}
	public String getSv_startdate() {
		return sv_startdate;
	}
	public void setSv_startdate(String sv_startdate) {
		this.sv_startdate = sv_startdate;
	}
	public String getSv_enddate() {
		return sv_enddate;
	}
	public void setSv_enddate(String sv_enddate) {
		this.sv_enddate = sv_enddate;
	}
	public int getSv_hits() {
		return sv_hits;
	}
	public void setSv_hits(int sv_hits) {
		this.sv_hits = sv_hits;
	}
	public int getSv_count() {
		return sv_count;
	}
	public void setSv_count(int sv_count) {
		this.sv_count = sv_count;
	}
	public String getSv_state() {
		return sv_state;
	}
	public void setSv_state(String sv_state) {
		this.sv_state = sv_state;
	}
	
}
