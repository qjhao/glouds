package sin.glouds.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sin.glouds.entity.sins.TestInc;
import sin.glouds.repository.sins.TestIncRepository;
import sin.test.jeesite.dao.UserDao;
import sin.test.jeesite.entity.User;

@Service
public class TestIncService {

	@Autowired
	private TestIncRepository testIncRepository;
	@Autowired
	private TestService testService;
	@Resource
	private UserDao userDao;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void increase() {
		TestInc testInc = testIncRepository.findOne(1);
		System.out.println(testInc.getValue());
		testInc.setValue(testInc.getValue() + 1);
		testIncRepository.save(testInc);
		testService.increase();
		throw new RuntimeException();
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW,readOnly = false)
	public void increase2() {
		TestInc testInc = testIncRepository.findOne(2);
		System.out.println(testInc.getValue());
		testInc.setValue(testInc.getValue() + 1);
		testIncRepository.save(testInc);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void test() {
		List<User> users = userDao.findList();
		User user = users.get(0);
		System.out.println(user.getName() + " : " + user.getRemarks());
		user.setRemarks("test");
		userDao.update(user);
		testService.increase();
		throw new RuntimeException();
	}
}
