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
	@Override
	public void add(Reply reply) throws Exception {
		replyDao.add(reply);
	}
	@Override
	public void delete(int id) throws Exception {
		replyDao.delete(id);
	}
	@Override
	public Reply queryByID(int id) throws Exception {
		return replyDao.queryByID(id);
	}
	@Override
	public List<Reply> queryByUID(int uid) throws Exception {
		return replyDao.queryByUID(uid);
	}
	@Override
	public List<Reply> queryByUTid(int uid, int tid) throws Exception {
		return replyDao.queryByUTid(uid, tid);
	}
	@Override
	public List<Reply> queryByTopicIDList(int tid) throws Exception {
		return replyDao.queryByTopicIDList(tid);
	}
	@Override
	public List<Reply> queryByTopicID(int tid, int start,int number) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tid", tid);
		map.put("start", start);
		map.put("number", number);
		return replyDao.queryByTopicID(map);
	}
	@Override
	public void addFlowers(int id) throws Exception {
		replyDao.addFlowers(id);
	}
	@Override
	public void addEggs(int id) throws Exception {
		replyDao.addEggs(id);
	}

}
