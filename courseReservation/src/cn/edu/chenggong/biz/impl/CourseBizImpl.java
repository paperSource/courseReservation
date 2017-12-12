package cn.edu.chenggong.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.chenggong.biz.CourseBiz;
import cn.edu.chenggong.dao.CourseMapper;
import cn.edu.chenggong.po.Course;



@Service
public class CourseBizImpl implements CourseBiz {
	@Resource
	private CourseMapper courseMapper;

	public CourseMapper getCourseMapper() {
		return courseMapper;
	}

	public void setCourseMapper(CourseMapper courseMapper) {
		this.courseMapper = courseMapper;
	}


	/**
	 * 添加课程信息
	 * @param course
	 */
	public void addCourse(Course course) {
		courseMapper.addCourse(course);
	}
	
	/**
	 * 查询所有课程
	 * @return List
	 */
	public List<Course> findCourseAllByClassify(Course course) {
		return courseMapper.findCourseAllByClassify(course);
	}

	/**
	 * 删除用户信息
	 * @param course
	 * @return
	 */
	public int deleteCourse(Course course) {
		return courseMapper.deleteCourse(course);
	}
	
	/**
	    * 通过Id查询数据
	    * @param course
	    * @return
	    */
	   public Course findCourseById(Course course){
		   return courseMapper.findCourseById(course);
	   }
	
	/**
	 * 修改课程信息
	 * @param course
	 */
    public int updateCourse(Course course) {
    	return courseMapper.updateCourse(course);
    }
    
    /**
     * 通过课程名 查询数据
     * @param course
     * @return
     */
    public List<Course> findCourseByName(Course course) {
    	return courseMapper.findCourseByName(course);
    }

    /**
     * 通过课程名 查询数据
     * @param course
     * @return
     */
	public List<Course> insertCourse(Course course) {
		return courseMapper.insertCourse(course);
	}

	
}
