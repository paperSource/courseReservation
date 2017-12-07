package cn.edu.chenggong.postings.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.chenggong.postings.dao.TopicDao;
import cn.edu.chenggong.postings.model.Topic;
import cn.edu.chenggong.postings.service.Interface.ITopicSV;

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
	public void add(Topic topic) throws Exception {
		topicDao.add(topic);
		
	}
	public void delete(Topic topic) throws Exception {
		topicDao.delete(topic);
		
	}
	public void update(Topic topic) throws Exception {
		topicDao.update(topic);
		
	}
	public Topic queryById(int id) throws Exception {
		return topicDao.queryById(id);
	}
	
	public List<Topic> queryByTitle(String title) throws Exception {
		return topicDao.queryByTitle(title);
	}
	
	public List<Topic> queryList() throws Exception {
		return topicDao.queryList();
	}
	
	public List<Topic> queryPag(int start, int number) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("number", number);
		return topicDao.queryPag(map);
	}
	public void addUpvote(int id) throws Exception {
		topicDao.addUpvote(id);
	}
	
	
}
