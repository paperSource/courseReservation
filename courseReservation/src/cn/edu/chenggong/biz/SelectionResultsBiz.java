package cn.edu.chenggong.biz;

import java.util.List;

import cn.edu.chenggong.po.SelectionResults;


public interface SelectionResultsBiz {
	
	/**
	 * 添加选课信息
	 * @param selectionResult
	 */
	public void addSelectionResults(SelectionResults selectionResults);
	
	/**
	 * 通过用户id查询已选课程
	 * @param selectionResults
	 * @return
	 */
	public List<SelectionResults> findResultbyId(SelectionResults selectionResults);
	
	/**
	 * 通过id删除选课信息
	 * @param course
	 * @return
	 */
	public int deleteResultbyId(SelectionResults selectionResults);
	
	/**
	 * 通过用户id查询用户选课数
	 * @param selectionResults
	 * @return
	 */
	public int getSelectCountByUsersId(SelectionResults selectionResults);
	
	/**
	 * 通过courseId查询课程是否已选
	 * @param selectionResults
	 * @return
	 */
	public List<SelectionResults> getResultByCourseId(SelectionResults selectionResults);
}
