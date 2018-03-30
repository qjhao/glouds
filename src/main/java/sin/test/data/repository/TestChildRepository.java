package sin.test.data.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import sin.test.data.entity.TestChild;

@org.springframework.stereotype.Repository
public interface TestChildRepository extends Repository<TestChild, Integer> {

	List<TestChild> findAll();
}
