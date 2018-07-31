package sin.glouds.repository.sins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sin.glouds.entity.sins.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
