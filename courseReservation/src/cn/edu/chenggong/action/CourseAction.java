package cn.edu.chenggong.action;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.chenggong.biz.CourseBiz;
import cn.edu.chenggong.biz.SelectionResultsBiz;
import cn.edu.chenggong.po.Course;
import cn.edu.chenggong.po.NewsAdvertis;
import cn.edu.chenggong.po.SelectionResults;
import cn.edu.chenggong.po.Users;

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


	@Resource
	private SelectionResultsBiz selectionResultsBiz;

	public SelectionResultsBiz getSelectionResultsBiz() {
		return selectionResultsBiz;
	}

	public void setSelectionResultsBiz(SelectionResultsBiz selectionResultsBiz) {
		this.selectionResultsBiz = selectionResultsBiz;
	}
	
	/**
	 * 添加课程信息
	 * @param users
	 */
	@RequestMapping("/addCourse")
	public String addCourse(MultipartFile file,HttpServletRequest request, NewsAdvertis newsA ,Course course) throws IllegalStateException, IOException  {
		System.out.println(course.getCourseIntroduction());
		String path = request.getSession().getServletContext().getRealPath("fileUpload");// tomcat下的文件路径
		String fileName = file.getOriginalFilename();
		File dir = new File(path, fileName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		file.transferTo(dir);
		String pathFile = "http://localhost:8080/courseReservation/fileUpload/" + fileName;
		course.setImagePath(pathFile);
		List<Course> courseList= courseBiz.insertCourse(course);
		if(courseList.size() == 0 ) {
			
			courseBiz.addCourse(course);
			return "/pages/course/shouyeCourse.jsp";
		}
		return "/pages/course/indexCourse.jsp";
	}
	
	/**
	 * 查询所有课程
	 * @param request
	 * @return
	 */
	 @RequestMapping("/findCourseAll")
	 @ResponseBody
	 public Object findCourseAll(Integer pageSize, Integer pageNo,String genre, ModelMap model, HttpServletRequest request){
		 System.out.println("查询所有");
		 HashMap<String,Object> result=new HashMap<String,Object>();
		 Course course = new Course();
		 course.setClassify(genre);
		 
		 SelectionResults selectionResults = new SelectionResults();
		 HttpSession session = request.getSession(); 
		 Users users = (Users) session.getAttribute("stId");
		 
		 if(users != null){
			 if(users.getUsersState() == 1){
				 selectionResults.setUsersId(users.getId());
				 List<SelectionResults> resultList = selectionResultsBiz.findResultbyId(selectionResults);
				 if(resultList.size()>0){
					 course.setClassHour("");
					 String value = "";
					 value+="'";
					 for(int i = 0; i<resultList.size();i++){
						 value += resultList.get(i).getCourseId();
						 if(i < resultList.size()-1){
							 value+="','";
						 }
					 }
					 value+="'";
					 course.setClassHour(value);
				 }
			 }
		 }
		 List<Course> courseList= courseBiz.findCourseAllByClassify(course);
		 long count = courseList.size();
		 int totalPage = 0;
		 if(count%pageSize==0) {
			totalPage = (int)count/pageSize;
		 } else {
			totalPage = (int)count/pageSize + 1;
		 }
		 if(count == 0) {
			 result.put("result", "error");
		 } else {
			 result.put("result", "success");
			 result.put("count", count);
			 result.put("totalPage", totalPage);
			 result.put("data", courseList);
		 }
		 return result;
	 }
	
	 /**
	  * 通过Id对课程进行删除
	  * @param course
	  * @return
	  */
	 @RequestMapping("/deleteCourseById")
	 public String deleteCourseById(Course course){
		  courseBiz.deleteCourse(course);
		  return "/pages/course/shouyeCourse.jsp";
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
		 return "/pages/course/editCourse.jsp";
	 }
	 
	 /**
	  * 修改课程信息
	  * @param course
	  * @return
	  */
	 @RequestMapping("/updateCourse")
	 public String updateCourse(Course course){
		 courseBiz.updateCourse(course);
		 return "/pages/course/shouyeCourse.jsp";
	 }
	 
	 /**
	  * 通过课程名 查询数据
	  * @param request
	  * @param course
	  * @return
	  */
	 @RequestMapping("/findCourseByName")
	 @ResponseBody
	 public Object findCourseByName(HttpServletRequest request,Integer pageSize, Integer pageNo, String key ,ModelMap model){
		 HashMap<String,Object> result=new HashMap<String,Object>();
		 Course course = new Course();
		 course.setCourseTitle(key);
		 List<Course> courseList= courseBiz.findCourseByName(course);
		 long count = courseList.size();
		 int totalPage = 0;
		 if(count%pageSize==0) {
			totalPage = (int)count/pageSize;
		 } else {
			totalPage = (int)count/pageSize + 1;
		 }
		 if(count == 0) {
			 result.put("result", "error");
		 } else {
			 result.put("result", "success");
			 result.put("count", count);
			 result.put("totalPage", totalPage);
			 result.put("data", courseList);
		 }
		 return result;
	 }
}
