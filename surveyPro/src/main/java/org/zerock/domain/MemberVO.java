package org.zerock.domain;

public class MemberVO {

	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_kind;
	private int m_age;
	private String m_gender;
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pwd(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_kind() {
		return m_kind;
	}
	public void setM_kind(String m_kind) {
		this.m_kind = m_kind;
	}
	public int getM_age() {
		return m_age;
	}
	public void setM_age(int m_age) {
		this.m_age = m_age;
	}
	public String getM_gender() {
		return m_gender;
	}
	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}

	//	@Override
	//	public String toString() {
	//		return "MemberVO [m_id=" + m_id + ", m_pwd=" + m_pwd + ", m_name=" + m_name + ", m_kind=" + m_kind + ", m_age="
	//				+ m_age + ", m_gender=" + m_gender + "]";
	//	}
	
}
