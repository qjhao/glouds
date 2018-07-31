package sin.glouds.repository.sins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sin.glouds.entity.sins.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
