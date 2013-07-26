package com.lab06;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lab06.dao.TopicDao;
import com.lab06.domain.Topic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:WebContent/WEB-INF/applicationContext.xml")
public class TopicDaoTest {

	private TopicDao topicDao;
	private ApplicationContext applicationContext;
	
	@Before
	public void tearDown(){
		JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
		jdbcTemplate.update("delete from topics");
	}
	
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Autowired
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	@Test
	public void testTopicDaoNotNull() {
		assertTrue(topicDao != null);
	}
	
	@Test
	public void testLoadAllTopics() {
		JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
		jdbcTemplate.update("insert into topics(title,duration) values(?,?)","Test1",30);
		jdbcTemplate.update("insert into topics(title,duration) values(?,?)","Test2",40);
		
		List<Topic> topics = topicDao.getAllTopics();
		assertNotNull(topics.size() == 2);
	}
	
	@Test
	public void testLoadTopic() {
		JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
		jdbcTemplate.update("insert into topics(title,duration) values(?,?)","Test1",30);
		int id = jdbcTemplate.queryForObject("select max(id) from topics",Integer.class);
		Topic topic = topicDao.select(id);
		assertNotNull(topic);
	}
	@Test
	public void testInsertTopic() {
		int num = topicDao.insert("Ruby", 50);
		assertTrue(num == 1);
	}

}
