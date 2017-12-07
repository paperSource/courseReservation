package cn.edu.chenggong.postings.dao;

import java.util.List;
import java.util.Map;

import cn.edu.chenggong.postings.model.Topic;
public interface TopicDao {
	/**
	 * 保存一条帖子信息
	 * @param topic
	 * @throws Exception
	 */
	public void add(Topic topic) throws Exception;
	/**
	 * 删除帖子
	 * @param topic
	 * @throws Exception
	 */
	public void delete(Topic topic) throws Exception;
	/**
	 * 修改帖子信息
	 * @param topic
	 * @throws Exception
	 */
	public void update(Topic topic) throws Exception;
	/**
	 * 根据ID查询帖子信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Topic queryById(int id) throws Exception;
	/**
	 * 根据标题查询
	 * @param title
	 * @return
	 * @throws Exception
	 */
	public List<Topic> queryByTitle(String title) throws Exception;
	/**
	 * 查询全部帖子信息
	 * @return
	 * @throws Exception
	 */
	public List<Topic> queryList() throws Exception;
	/**
	 * 分页查询
	 * @param map 分页信息
	 * @return
	 * @throws Exception
	 */
	public List<Topic> queryPag(Map<String, Object> map) throws Exception;
	/**
	 * 点赞
	 * @param id
	 * @throws Exception
	 */
	public void addUpvote(int id) throws Exception;
}
