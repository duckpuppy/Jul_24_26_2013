package com.lab06.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lab06.domain.Topic;

@Repository
public class TopicDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Topic> getAllTopics(){
		List<Topic> topics = null;
		topics = jdbcTemplate.query("select * from topics", new RowMapper<Topic>(){
			public Topic mapRow(ResultSet rs, int index) throws SQLException {
				Topic topic = new Topic(rs.getInt("id"),rs.getString("title"),rs.getInt("duration"));
				return topic;
			}
		});
		return topics;
	}
	public Topic select(int id){
		Topic topic = null;
		Map<String,Object>  map = jdbcTemplate.queryForMap("select * from topics where id=?",id);
		if(map != null && map.size() == 3)
			topic = new Topic((Integer)map.get("id"),map.get("title").toString(),(Integer)map.get("duration"));
		return topic;
	}
	public int insert(String title,int duration){
		return jdbcTemplate.update("insert into topics(title,duration) values(?,?)",title,duration);
	}
}
