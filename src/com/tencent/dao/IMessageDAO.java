package com.tencent.dao;

import java.util.List;

import com.tencent.model.Message;
import com.tencent.model.User;

public interface IMessageDAO extends IDao<Message> {
	public Message findByTopic(String topic);

	public List<Message> listOutDate(User user, boolean isOutdate);

	public List<Message> listOutDate(User user, boolean isOutdate,
			int firstResult, int maxSize);
}
