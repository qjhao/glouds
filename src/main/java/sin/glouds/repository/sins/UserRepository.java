package sin.glouds.repository.sins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sin.glouds.entity.sins.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findOneByUsername(String username);
}
