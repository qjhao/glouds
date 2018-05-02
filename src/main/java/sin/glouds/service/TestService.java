package sin.glouds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sin.glouds.entity.sins.Test;
import sin.glouds.repository.sins.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;
	
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void increase() {
		Test test = testRepository.findOne(1);
		System.out.println(test.getValue());
		test.setValue(test.getValue() + 1);
		testRepository.save(test);
	}
	
}
