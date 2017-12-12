package cn.edu.chenggong.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.chenggong.biz.ITopicSV;
import cn.edu.chenggong.dao.TopicDao;
import cn.edu.chenggong.po.Topic;

@Service
public class TopicSVImpl implements ITopicSV{
	@Resource
	private TopicDao topicDao;
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}
	public TopicDao getTopicDao() {
		return topicDao;
	}
	@Override
	public void add(Topic topic) throws Exception {
		topicDao.add(topic);
		
	}
	@Override
	public void delete(Topic topic) throws Exception {
		topicDao.delete(topic);
		
	}
	@Override
	public void update(Topic topic) throws Exception {
		topicDao.update(topic);
		
	}
	@Override
	public Topic queryById(int id) throws Exception {
		return topicDao.queryById(id);
	}
	
	@Override
	public List<Topic> queryByTitle(String title) throws Exception {
		return topicDao.queryByTitle(title);
	}
	
	@Override
	public List<Topic> queryList() throws Exception {
		return topicDao.queryList();
	}
	
	@Override
	public List<Topic> queryPag(int start, int number) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("number", number);
		return topicDao.queryPag(map);
	}
	@Override
	public void addUpvote(int id) throws Exception {
		topicDao.addUpvote(id);
	}
	
	
}
