package com.aci;

import java.util.List;

public interface TopicsDao {
	List<Topic> getTopics();
	int addTopic(String title, int duration);
	Topic getTopic(int id);
}
