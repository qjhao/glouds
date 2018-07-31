//package sin.glouds.repository.test;
//
//import java.util.List;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import sin.glouds.entity.test.TestParent;
//
//@org.springframework.stereotype.Repository
//public interface TestParentRepository extends JpaRepository<TestParent, Integer> {
//
//	List<TestParent> findAll();
//	
//	Page<TestParent> findAll(Pageable pageable);
//	
//	@Override
//	default TestParent findOne(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	TestParent getOneByTitle(String title);
//	
//	List<TestParent> findByFlag(boolean flag);
//
//	@SuppressWarnings("unchecked")
//	TestParent save(TestParent testParent);
//
//	boolean exists(Integer id);
//
//	long count();
//
//	TestParent getOne(Integer id);
//	
//	List<TestParent> findBySomeNumberAndTitleLike(Double someNumbber, String title);
//	
//	TestParent findOneBySomeNumberAndFlagAndTitleLike(Double someNumber, boolean flag, String title);
//}
