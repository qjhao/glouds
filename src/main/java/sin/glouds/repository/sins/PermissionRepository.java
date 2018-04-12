package sin.glouds.repository.sins;

import org.springframework.data.jpa.repository.JpaRepository;

import sin.glouds.entity.sins.Permission;

@org.springframework.stereotype.Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
