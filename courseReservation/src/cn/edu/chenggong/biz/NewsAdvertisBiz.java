package cn.edu.chenggong.biz;

import java.util.List;

import cn.edu.chenggong.po.NewsAdvertis;

public interface NewsAdvertisBiz {
	
	/**
	 * 添加文件及广告信息
	 * @param newsA
	 */
	public void addNewsAdver(NewsAdvertis newsA);
	
	/**
	 * 查询文件和新闻信息
	 * @return
	 */
	public List<NewsAdvertis> findNewsAdver();
	
}
