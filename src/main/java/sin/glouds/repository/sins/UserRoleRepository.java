package sin.glouds.repository.sins;

import org.springframework.data.jpa.repository.JpaRepository;

import sin.glouds.entity.sins.UserRole;

@org.springframework.stereotype.Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
