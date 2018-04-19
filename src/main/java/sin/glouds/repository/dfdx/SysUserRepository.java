package sin.glouds.repository.dfdx;

import org.springframework.data.jpa.repository.JpaRepository;

import sin.glouds.entity.dfdx.SysUser;


@org.springframework.stereotype.Repository("dfdxUserRepository")
public interface SysUserRepository extends JpaRepository<SysUser, String> {

}
