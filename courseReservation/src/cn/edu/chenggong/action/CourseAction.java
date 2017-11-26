package cn.edu.chenggong.action;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.chenggong.biz.CourseBiz;
import cn.edu.chenggong.po.Course;

@Controller
@RequestMapping("courseAction")
public class CourseAction {
	@Resource
	private CourseBiz courseBiz;

	public CourseBiz getCourseBiz() {
		return courseBiz;
	}

	public void setCourseBiz(CourseBiz courseBiz) {
		this.courseBiz = courseBiz;
	}


	/**
	 * 添加课程信息
	 * @param users
	 */
	@RequestMapping("/addCourse")
	public String addCourse(Course course) {
		courseBiz.addCourse(course);
		return "findCourseAll.action";
	}
	
	/**
	 * 查询所有课程
	 * @param request
	 * @return
	 */
	 @RequestMapping("/findCourseAll")
	 public String findCourseAll(HttpServletRequest request){
		 System.out.println("查询所有");
		 List<Course> courseList= courseBiz.findCourseAll();
		 request.setAttribute("courseList", courseList);
		 return "/shouyeCourse.jsp";
	 }
	
	 /**
	  * 通过Id对课程进行删除
	  * @param course
	  * @return
	  */
	 @RequestMapping("/deleteCourseById")
	 public String deleteCourseById(Course course){
		  int row= courseBiz.deleteCourse(course);
		  return "findCourseAll.action";
	 }
	 /**
	  * 通过Id查询课程信息
	  * @param request
	  * @param course
	  * @return
	  */
	 @RequestMapping("/findCourseById")
	 public String findCourseById(HttpServletRequest request,Course course){
		 Course courseInfo=courseBiz.findCourseById(course);
		 request.setAttribute("courseInfo", courseInfo);
		 return "/editCourse.jsp";
	 }
	 
	 /**
	  * 修改课程信息
	  * @param course
	  * @return
	  */
	 @RequestMapping("/updateCourse")
	 public String updateCourse(Course course){
		 int row =courseBiz.updateCourse(course);
		 return "findCourseAll.action";
	 }
	 
	 /**
	  * 通过课程名 查询数据
	  * @param request
	  * @param course
	  * @return
	  */
	 @RequestMapping("/findCourseByName")
	 public String findCourseByName(HttpServletRequest request,Course course){
		 List<Course> courseList= courseBiz.findCourseByName(course);
		 request.setAttribute("courseList", courseList);
		 return "/shouyeCourse.jsp";
	 }
}
