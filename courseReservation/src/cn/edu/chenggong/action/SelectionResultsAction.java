package cn.edu.chenggong.action;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.chenggong.biz.SelectionResultsBiz;
import cn.edu.chenggong.po.SelectionResults;
import cn.edu.chenggong.po.Users;

@Controller
@RequestMapping("selectionResultsAction")
public class SelectionResultsAction {
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
	@RequestMapping("/addSelectionResults")
	public Object addSelectionResults(HttpServletRequest request, SelectionResults selectionResults) {
		
		HttpSession session = request.getSession(); 
		Users users = (Users) session.getAttribute("stId");
		if(users!=null){
			selectionResults.setUsersId(users.getId());
			
			int selectCount = selectionResultsBiz.getSelectCountByUsersId(selectionResults);
			
			if(selectCount<3){
				selectionResults.setUsersName(users.getUsersName());
				selectionResults.setCourseId(Integer.parseInt(request.getParameter("courseId")));
				List<SelectionResults> selectResultList = selectionResultsBiz.getResultByCourseId(selectionResults);
				if(selectResultList.size()==0){
					selectionResults.setCourseTitle(request.getParameter("courseTitle"));
					selectionResults.setClassHour(request.getParameter("classHour"));
					selectionResults.setTeacherName(request.getParameter("teacherName"));
					selectionResults.setClassify(request.getParameter("classify"));
					selectionResultsBiz.addSelectionResults(selectionResults);
					return "/pages/selectCourse/selectCourse.jsp";
					
				}else {
					return "/pages/error/error.jsp";
				}
			}else {
				return "/pages/selectCourse/personalResult.jsp";
			}
		}
		return "/pages/error/error.jsp";
	}
	
	/**
	 * 通过用户Id查询所选课程
	 * @return
	 */
	@RequestMapping("/findResultbyId")
	@ResponseBody
	public Object findResultbyId(Integer pageSize, Integer pageNo,String genre, ModelMap model,SelectionResults selectionResults){
		 HashMap<String,Object> result=new HashMap<String,Object>();
		 List<SelectionResults> resultsList= selectionResultsBiz.findResultbyId(selectionResults);
		 long count = resultsList.size();
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
			 result.put("data", resultsList);
		 }
		 return result;
	}
	
	/**
	  * 通过Id对课程进行删除
	  * @param course
	  * @return
	  */
	 @RequestMapping("/deleteResultbyId")
	 public String deleteResultbyId(SelectionResults selectionResults){
		  int row= selectionResultsBiz.deleteResultbyId(selectionResults);
		  return "/pages/selectCourse/personalResult.jsp";
	 }
	
	 public Object getDataCount(HttpServletRequest request, SelectionResults selectionResults){
		 HttpSession session = request.getSession(); 
			Users users = (Users) session.getAttribute("stId");
			HashMap<String,Object> result=new HashMap<String,Object>();
			int count=0;
			if(users!=null){
				selectionResults.setUsersId(users.getId());
				count = selectionResultsBiz.getSelectCountByUsersId(selectionResults);
			}
		 List<SelectionResults> resultsList= selectionResultsBiz.findResultbyId(selectionResults);
		
		 if(count == 0) {
			 result.put("result", "error");
		 } else {
			 result.put("result", "success");
			 result.put("count", count);
		 }
		 return result;
	 }
}
