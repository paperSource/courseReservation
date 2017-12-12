package cn.edu.chenggong.dao;

import java.util.List;

import cn.edu.chenggong.po.NewsAdvertis;

public interface NewsAdvertisMapper {
public void addNewsAdver(NewsAdvertis newsA);//添加文件及广告信息
public List<NewsAdvertis> findNewsAdver();//查询文件和新闻信息
}
