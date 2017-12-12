package cn.edu.chenggong.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.chenggong.biz.IReplySV;
import cn.edu.chenggong.dao.ReplyDao;
import cn.edu.chenggong.po.Reply;
@Service
public class ReplySVImpl implements IReplySV{
	@Resource
	private ReplyDao replyDao;
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	public ReplyDao getReplyDao() {
		return replyDao;
	}
	public void add(Reply reply) throws Exception {
		replyDao.add(reply);
	}
	public void delete(int id) throws Exception {
		replyDao.delete(id);
	}
	public Reply queryByID(int id) throws Exception {
		return replyDao.queryByID(id);
	}
	public List<Reply> queryByUID(int uid) throws Exception {
		return replyDao.queryByUID(uid);
	}
	public List<Reply> queryByUTid(int uid, int tid) throws Exception {
		return replyDao.queryByUTid(uid, tid);
	}
	public List<Reply> queryByTopicIDList(int tid) throws Exception {
		return replyDao.queryByTopicIDList(tid);
	}
	public List<Reply> queryByTopicID(int tid, int start,int number) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tid", tid);
		map.put("start", start);
		map.put("number", number);
		return replyDao.queryByTopicID(map);
	}
	public void addFlowers(int id) throws Exception {
		replyDao.addFlowers(id);
	}
	public void addEggs(int id) throws Exception {
		replyDao.addEggs(id);
	}

}
