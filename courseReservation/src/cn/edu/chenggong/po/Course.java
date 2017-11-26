package cn.edu.chenggong.po;

import javax.xml.crypto.Data;


public class Course {
	private int id;// id
	private String courseTitle;// 课程名称
	private String classHour;// 课程时长
	private String teacherName;// 授课教师
	private String classify;// 课程分类
	private String classifyNo;//课程分类编号
	private Data gmt_creat;// 创建时间
	private Data gmt_modifed;// 修改时间
	
	public Course() {
		super();
	}
	

	public Course(int id, String courseTitle, String classHour,
			String teacherName, String classify, String classifyNo,
			Data gmt_creat, Data gmt_modifed) {
		super();
		this.id = id;
		this.courseTitle = courseTitle;
		this.classHour = classHour;
		this.teacherName = teacherName;
		this.classify = classify;
		this.classifyNo = classifyNo;
		this.gmt_creat = gmt_creat;
		this.gmt_modifed = gmt_modifed;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getClassHour() {
		return classHour;
	}
	public void setClassHour(String classHour) {
		this.classHour = classHour;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getClassifyNo() {
		return classifyNo;
	}
	public void setClassifyNo(String classifyNo) {
		this.classifyNo = classifyNo;
	}
	public Data getGmt_creat() {
		return gmt_creat;
	}
	public void setGmt_creat(Data gmt_creat) {
		this.gmt_creat = gmt_creat;
	}
	public Data getGmt_modifed() {
		return gmt_modifed;
	}
	public void setGmt_modifed(Data gmt_modifed) {
		this.gmt_modifed = gmt_modifed;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", courseTitle=" + courseTitle
				+ ", classHour=" + classHour + ", teacherName=" + teacherName
				+ ", classify=" + classify + ", classifyNo=" + classifyNo
				+ ", gmt_creat=" + gmt_creat + ", gmt_modifed=" + gmt_modifed
				+ "]";
	}
	

	
}
