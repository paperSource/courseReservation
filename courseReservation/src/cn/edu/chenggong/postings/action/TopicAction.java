package cn.edu.chenggong.postings.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.chenggong.postings.service.Interface.ITopicSV;

@Controller
@RequestMapping("topicAction")
public class TopicAction {
	@Resource
	private ITopicSV topicSVImpl;
	public void setTopicSVImpl(ITopicSV topicSVImpl) {
		this.topicSVImpl = topicSVImpl;
	}
	public ITopicSV getTopicSVImpl() {
		return topicSVImpl;
	}
	@RequestMapping("addTopic")
	public void addTopic() throws Exception{
		
	}
}
