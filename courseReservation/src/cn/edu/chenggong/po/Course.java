package cn.edu.chenggong.po;

import javax.xml.crypto.Data;


public class Course {
	private int id;// id
	private String courseTitle;// 课程名称
	private String imagePath;// 课程图片
	private String courseIntroduction;// 课程简介
	private String classHour;// 课程时长
	private String teacherName;// 授课教师
	private String teacherIntroduction;// 教师简介
	private String classify;// 课程分类
	private Data gmt_creat;// 创建时间
	private Data gmt_modifed;// 修改时间
	public Course() {
		super();
	}
	public Course(int id, String courseTitle, String courseIntroduction,
			String classHour, String teacherName, String teacherIntroduction,
			String classify, String imagePath, Data gmt_creat, Data gmt_modifed) {
		super();
		this.id = id;
		this.courseTitle = courseTitle;
		this.courseIntroduction = courseIntroduction;
		this.classHour = classHour;
		this.teacherName = teacherName;
		this.teacherIntroduction = teacherIntroduction;
		this.classify = classify;
		this.imagePath = imagePath;
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
	public String getCourseIntroduction() {
		return courseIntroduction;
	}
	public void setCourseIntroduction(String courseIntroduction) {
		this.courseIntroduction = courseIntroduction;
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
	public String getTeacherIntroduction() {
		return teacherIntroduction;
	}
	public void setTeacherIntroduction(String teacherIntroduction) {
		this.teacherIntroduction = teacherIntroduction;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
				+ ", courseIntroduction=" + courseIntroduction + ", classHour="
				+ classHour + ", teacherName=" + teacherName
				+ ", teacherIntroduction=" + teacherIntroduction
				+ ", classify=" + classify + ", imagePath=" + imagePath
				+ ", gmt_creat=" + gmt_creat + ", gmt_modifed=" + gmt_modifed
				+ "]";
	}
	
}
