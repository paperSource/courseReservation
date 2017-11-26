package cn.edu.chenggong.biz;

import java.util.List;

import cn.edu.chenggong.po.Course;


public interface CourseBiz {
	
	/**
	 * 添加课程讯息
	 * @param course
	 */
	public void addCourse(Course course);
	
	/**
	 * 查询所有课程
	 * @return List
	 */
	public List<Course> findCourseAll();
	
	/**
    * 删除用户信息
    * @param course
    * @return
    */
   public int deleteCourse(Course course);
   
   /**
    * 通过Id查询数据
    * @param course
    * @return
    */
   public Course findCourseById(Course course);
   
   /**
    * 修改课程信息
    * @param course
    */
   public int updateCourse(Course course);
   
   /**
    * 通过课程名 查询数据
    * @param course
    * @return
    */
   public List<Course> findCourseByName(Course course);
}
