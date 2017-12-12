package cn.edu.chenggong.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.chenggong.biz.SelectionResultsBiz;
import cn.edu.chenggong.dao.SelectionResultsMapper;
import cn.edu.chenggong.po.SelectionResults;

@Service
public class SelectionResultsBizImpl implements SelectionResultsBiz {
	@Resource
	private SelectionResultsMapper selectionResultsMapper;

	public SelectionResultsMapper getSelectionResultsMapper() {
		return selectionResultsMapper;
	}

	public void setSelectionResultsMapper(
			SelectionResultsMapper selectionResultsMapper) {
		this.selectionResultsMapper = selectionResultsMapper;
	}

	/**
	 * 添加选课信息
	 * @param selectionResult
	 */
	@Override
	public void addSelectionResults(SelectionResults selectionResults) {
		selectionResultsMapper.addSelectionResults(selectionResults);
	}

	/**
	 * 通过用户id查询已选课程
	 * @param selectionResults
	 * @return
	 */
	@Override
	public List<SelectionResults> findResultbyId(SelectionResults selectionResults) {
		return selectionResultsMapper.findResultbyId(selectionResults);
	}
	
	/**
	 * 通过id删除选课信息
	 * @param course
	 * @return
	 */
	@Override
	public int deleteResultbyId(SelectionResults selectionResults) {
		return selectionResultsMapper.deleteResultbyId(selectionResults);
	}
	
	/**
	 * 通过用户id查询用户选课数
	 * @param selectionResults
	 * @return
	 */
	@Override
	public int getSelectCountByUsersId(SelectionResults selectionResults) {
		return selectionResultsMapper.getSelectCountByUsersId(selectionResults);
	}
	
	/**
	 * 通过courseId查询课程是否已选
	 * @param selectionResults
	 * @return
	 */
	@Override
	public List<SelectionResults> getResultByCourseId(SelectionResults selectionResults) {
		return selectionResultsMapper.getResultByCourseId(selectionResults);
	}
}
