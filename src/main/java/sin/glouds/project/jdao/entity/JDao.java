package sin.glouds.project.jdao.entity;

import sin.glouds.project.jdao.connector.JSession;

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