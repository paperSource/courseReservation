package cn.edu.chenggong.po;

import javax.xml.crypto.Data;

public class SelectionResults {
	private int id;// ID
	private int usersId;// 用户ID
	private String usersName;// 用户姓名
	private int courseId;// 课程ID
	private String courseTitle;// 课程名称
	private String classHour;// 课程时长
	private String teacherName;// 授课教师
	private String classify;// 课程分类
	private Data gmt_creat;// 创建时间
	private Data gmt_modifed;// 修改时间 
	public SelectionResults() {
		super();
	}
	public SelectionResults(int id, int usersId, String usersName,
			int courseId, String courseTitle, String classHour,
			String teacherName, String classify, Data gmt_creat,
			Data gmt_modifed) {
		super();
		this.id = id;
		this.usersId = usersId;
		this.usersName = usersName;
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.classHour = classHour;
		this.teacherName = teacherName;
		this.classify = classify;
		this.gmt_creat = gmt_creat;
		this.gmt_modifed = gmt_modifed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
		return "SelectionResults [id=" + id + ", usersId=" + usersId
				+ ", usersName=" + usersName + ", courseId=" + courseId
				+ ", courseTitle=" + courseTitle + ", classHour=" + classHour
				+ ", teacherName=" + teacherName + ", classify=" + classify
				+ ", gmt_creat=" + gmt_creat + ", gmt_modifed=" + gmt_modifed
				+ "]";
	}
	
	
	
}
