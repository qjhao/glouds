package sin.glouds.project.gen.table2.bean;

import sin.glouds.project.gen.table2.core.DatabaseType;

public class DatabaseInfo {

	private DatabaseType databaseType;
	private String url;
	private String username;
	private String password;
	private String driverClassName;

	public DatabaseType getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(DatabaseType databaseType) {
		this.databaseType = databaseType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public static class Builder {
		private DatabaseType databaseType;
		private String url;
		private String username;
		private String password;
		private String driverClassName;
		
		public static Builder mysql = new Builder(DatabaseType.MYSQL);
		public static Builder oracle = new Builder(DatabaseType.ORACLE);
		public static Builder sqlserver = new Builder(DatabaseType.SQLSERVER);
		
		private Builder(DatabaseType type) {
			this.databaseType = type;
			switch (type) {
			case MYSQL:
				this.driverClassName = "com.mysql.jdbc.Driver";
				break;
			case ORACLE:
				this.driverClassName = "oracle.jdbc.OracleDriver";
				break;
			case SQLSERVER:
				this.driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				break;

			default:
				break;
			}
		}

		public Builder url(String url) {
			this.url = url;
			return this;
		}


		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder driverClassName(String driverClassName) {
			this.driverClassName = driverClassName;
			return this;
		}
		
		public DatabaseInfo build() {
			if(databaseType != null && databaseType != DatabaseType.OTHERS && url != null
				&& !url.isEmpty() && username != null && !username.isEmpty()
				&& password != null && !password.isEmpty()) {
				DatabaseInfo info = new DatabaseInfo();
				info.setDatabaseType(databaseType);
				info.setDriverClassName(driverClassName);
				info.setPassword(password);
				info.setUrl(url);
				info.setUsername(username);
				return info;
			}
			throw new RuntimeException("构建数据库信息失败，请重新确认连接信息");
		}
	}
}
