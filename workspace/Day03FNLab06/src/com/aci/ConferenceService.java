package com.aci;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceService implements TopicsDao {
	@Autowired
	private TopicsDao topicsDao;

	@Override
	public List<Topic> getTopics() {
		return topicsDao.getTopics();
	}

	@Override
	public int addTopic(String title, int duration) {
		return topicsDao.addTopic(title, duration);
	}

	@Override
	public Topic getTopic(int id) {
		return topicsDao.getTopic(id);
	}
}
