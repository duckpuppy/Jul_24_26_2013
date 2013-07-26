package com.aci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TopicClient {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/applicationContext.xml");
		TopicsDao topicsdao = context.getBean("topicsDao", TopicsDao.class);
		
		topicsdao.addTopic("Ruby", 45);
		System.out.println(topicsdao.getTopic(1));
		System.out.println(topicsdao.getTopics());
	}

}
