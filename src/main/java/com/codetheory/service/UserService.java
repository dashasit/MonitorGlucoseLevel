package com.codetheory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codetheory.dao.UserDao;
import com.codetheory.model.User;
import com.codetheory.model.UserGlucoseHistory;

@Component
public class UserService {

	@Autowired
	private UserDao userDao;

	public void addUser(User user) {
		int maxId = userDao.getMaxUserId();
		maxId++;

		user.setId(maxId);
		userDao.addUser(user);
	}
	
	public List<UserGlucoseHistory> getUserGlucoseHistory(int userId, String reportType)
	{
		return userDao.getUserGlucoseHistory(userId, reportType);
	}

	public void addUserGlucoseHistory(UserGlucoseHistory history)
			throws Exception {

		List<UserGlucoseHistory> histories = userDao.getHistoryByUserId(history
				.getUserId());

		if (histories != null && histories.size() < 4) {
			int historyId = userDao.getMaxUserGlucoseHistoryId();
			historyId++;
			history.setId(historyId);
			userDao.addUserGlucoseHistory(history);
		} else
			throw new Exception("Day limit of 4 entries exceded.");
	}
}
