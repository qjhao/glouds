package sin.gen.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sin.glouds.jdao.connector.JConnector;

@Service
public class GenService {

	public List<TableName> geTableNames() throws SQLException {
		Connection conn = JConnector.getConnection();
		ResultSet resultSet = conn.getMetaData().getTables(null, null, "", null);
		int index = 1;
		List<TableName> names = new ArrayList<>();
		while (resultSet.next()) {
			names.add(new TableName(index++, resultSet.getString("TABLE_NAME")));
		}
		return names;
	}

}

class TableName {
	private int id;
	private String name;

	public TableName(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
