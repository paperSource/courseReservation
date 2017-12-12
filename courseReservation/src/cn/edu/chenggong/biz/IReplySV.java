package cn.edu.chenggong.biz;

import java.util.List;

import cn.edu.chenggong.po.Reply;



public interface IReplySV {
	/**
	 * 添加一条回复
	 * @param reply
	 * @throws Exception
	 */
	public void add(Reply reply) throws Exception;
	/**
	 * 删除回复
	 * @param id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception;
	/**
	 * 根据ID查询回复信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Reply queryByID(int id) throws Exception;
	/**
	 * 根据用户ID查询回复信息
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public List<Reply> queryByUID(int uid) throws Exception;
	/**
	 * 根据主题帖ID和用户ID查询回复信息
	 * @return
	 * @throws Exception
	 */
	public List<Reply> queryByUTid(int uid, int tid) throws Exception;
	/**
	 * 根据帖子ID查询全部回复
	 * @param tid
	 * @return
	 * @throws Exception
	 */
	public List<Reply> queryByTopicIDList(int tid) throws Exception;
	/**
	 * 根据帖子ID分页查询回复
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Reply> queryByTopicID(int tid, int start,int number) throws Exception;
	/**
	 * 送花
	 * @param id
	 * @throws Exception
	 */
	public void addFlowers(int id) throws Exception;
	/**
	 * 丢蛋
	 * @param id
	 * @throws Exception
	 */
	public void addEggs(int id) throws Exception;
}
