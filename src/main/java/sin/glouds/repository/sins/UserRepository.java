package sin.glouds.repository.sins;

import org.springframework.data.jpa.repository.JpaRepository;

import sin.glouds.entity.sins.User;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
