package sin.glouds.jdao.entity;

import sin.glouds.jdao.connector.JSession;

public class JDao<T> {
	
	private JSession session;
	
	public void save(T t) {
		getSession().save(t);
	}
	
	protected JSession getSession() {
		if(session == null)
			session = new JSession();
		return session;
	}
}