package cn.edu.chenggong.biz;

import java.util.List;

import cn.edu.chenggong.po.Topic;

public interface ITopicSV {
	/**
	 * 新增一条帖子
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
	 * @param start 开始
	 * @param number 记录数
	 * @return
	 * @throws Exception
	 */
	public List<Topic> queryPag(int start,int number) throws Exception;
	/**
	 * 点赞
	 * @param id
	 * @throws Exception
	 */
	public void addUpvote(int id) throws Exception;
}
