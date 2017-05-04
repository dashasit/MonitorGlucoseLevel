package com.codetheory.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.codetheory.model.UserGlucoseHistory;

public class GlucoseHistoryRowMapper implements RowMapper<UserGlucoseHistory> {

	@Override
	public UserGlucoseHistory mapRow(ResultSet rs, int arg1)
			throws SQLException {
		UserGlucoseHistory history = new UserGlucoseHistory();
		history.setId(rs.getInt("id"));
		history.setUserId(rs.getInt("userid"));
		history.setGlucoseLevel(rs.getInt("glucose_level"));
		history.setLastmodified(rs.getDate("lastmodified"));

		return history;
	}
}
