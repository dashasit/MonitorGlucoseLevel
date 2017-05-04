package com.codetheory.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codetheory.model.User;
import com.codetheory.model.UserGlucoseHistory;
import com.codetheory.rowmapper.GlucoseHistoryRowMapper;
import com.efi.inventory.rowmapper.InventoryRowMapper;

@Repository
public class UserDao extends JdbcDaoSupport {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void initialize() {
		setJdbcTemplate(jdbcTemplate);
	}

	public int getMaxUserId() {
		String query = "select max(id) from user";
		Integer maxId = (Integer) jdbcTemplate.queryForObject(query,
				Integer.class);

		return maxId.intValue();
	}

	public int getMaxUserGlucoseHistoryId() {
		String query = "select max(id) from UserGlucoseHistory";
		Integer maxId = (Integer) jdbcTemplate.queryForObject(query,
				Integer.class);

		return maxId.intValue();
	}

	public List<UserGlucoseHistory> getHistoryByUserId(int userId) {
		String query = "select id, userid, glucose_level, lastmodified from UserGlucoseHistory where lastmodified=?";

		Object[] inputs = new Object[] { new Date() };

		return jdbcTemplate.query(query, inputs, new GlucoseHistoryRowMapper());
	}

	@Transactional
	public int addUser(User user) {
		String insert = "insert into user(id, first_name, last_name, dob, login_id, password) values(?,?,?,?,?,?)";

		return jdbcTemplate.update(insert, user.getId(), user.getFirstName(),
				user.getLastName(), user.getDob(), user.getLoginId(),
				user.getPassword());
	}

	@Transactional
	public int addUserGlucoseHistory(UserGlucoseHistory history) {
		String insert = "insert into UserGlucoseHistory(id, userid, glucose_level, lastmodified) values(?,?,?,?)";

		return jdbcTemplate.update(insert, history.getId(),
				history.getUserId(), history.getGlucoseLevel(), new Date());
	}

}
