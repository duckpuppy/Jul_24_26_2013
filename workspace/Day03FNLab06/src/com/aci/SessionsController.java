package com.aci;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionsController {
	@Autowired
	private ConferenceService conferenceService;

	@RequestMapping(value = "/topic/add/{title}/{duration}", method = RequestMethod.GET)
	@ResponseBody
	public String addTopic(@PathVariable("title") String title,
			@PathVariable("duration") int duration) {
		int id = conferenceService.addTopic(title, duration);
		return String
				.format("%s successfully added to db: Id is %s", title, id);
	}

	@RequestMapping(value = "/topic/show/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String showTopic(@PathVariable("id") int id) {
		Topic topic = conferenceService.getTopic(id);
		return topic == null ? "Invalid topic id" : String.format("%s (%s minutes)", topic.getTitle(),
				topic.getDuration());
	}

	@RequestMapping(value = "/topic/list", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public List<Topic> listTopics() {
		return conferenceService.getTopics();
	}
}
