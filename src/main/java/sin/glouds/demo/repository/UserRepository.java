package sin.glouds.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sin.glouds.demo.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	public User findOne(Long id);
	
	@SuppressWarnings("unchecked")
	public User save(User user);
	
	@Query("select t from User t where t.username=:name")
	public User findUserByName(@Param("name")String usernname);
}
