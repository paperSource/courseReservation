package cn.edu.chenggong.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.chenggong.biz.NewsAdvertisBiz;
import cn.edu.chenggong.dao.NewsAdvertisMapper;
import cn.edu.chenggong.po.NewsAdvertis;
@Service
public class NewsAdvertisImpl implements NewsAdvertisBiz{
@Resource
private NewsAdvertisMapper newsAdvertM;



public NewsAdvertisMapper getNewsAdvertM() {
	return newsAdvertM;
}



public void setNewsAdvertM(NewsAdvertisMapper newsAdvertM) {
	this.newsAdvertM = newsAdvertM;
}



@Override
public void addNewsAdver(NewsAdvertis newsA) {
	newsAdvertM.addNewsAdver(newsA);
}



@Override
public List<NewsAdvertis> findNewsAdver() {
	return newsAdvertM.findNewsAdver();
}






	

}
