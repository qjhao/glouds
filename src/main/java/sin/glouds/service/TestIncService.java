package sin.glouds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sin.glouds.entity.sins.TestInc;
import sin.glouds.repository.sins.TestIncRepository;

@Service
public class TestIncService {

	@Autowired
	private TestIncRepository testIncRepository;
	@Autowired
	private TestService testService;
	
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
}
