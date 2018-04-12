package sin.glouds.repository.yige;

import org.springframework.data.jpa.repository.JpaRepository;

import sin.glouds.entity.yige.SysUser;

@org.springframework.stereotype.Repository
public interface SysUserRepository extends JpaRepository<SysUser, String> {

}
