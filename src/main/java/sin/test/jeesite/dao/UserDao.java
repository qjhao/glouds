/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package sin.test.jeesite.dao;

import java.util.List;

import sin.test.jeesite.entity.User;

public interface UserDao {
	List<User> findList();
	
	List<User> findList2();
	
	void update(User user);
}
