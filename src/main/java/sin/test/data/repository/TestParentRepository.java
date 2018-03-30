package sin.test.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sin.test.data.entity.TestParent;

@org.springframework.stereotype.Repository
public interface TestParentRepository extends JpaRepository<TestParent, Integer> {

	List<TestParent> findAll();
	
	Page<TestParent> findAll(Pageable pageable);
	
	@Query("from TestParent where id=?")
	TestParent get(Integer id);
	
	TestParent getOneByTitle(String title);
	
	List<TestParent> findByFlag(boolean flag);

	@SuppressWarnings("unchecked")
	TestParent save(TestParent testParent);

	boolean exists(Integer id);

	long count();

	TestParent getOne(Integer id);
	
	List<TestParent> findBySomeNumberAndTitleLike(Double id, String title);
}
