package sin.glouds.config.filter.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import sin.glouds.entity.sins.Permission;
import sin.glouds.entity.sins.Role;
import sin.glouds.entity.sins.User;
import sin.glouds.service.UserService;

@Component
public class MyShiroRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("领。。。。。");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User user = (User)principals.getPrimaryPrincipal();
		for(Role role : user.getRoles()) {
			authorizationInfo.addRole(role.getRole());
			for(Permission permission : role.getPermissions()) {
				authorizationInfo.addStringPermission(permission.getPermission());
			}
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("领证。。。。。。。。。。。。。。。");
		String username = (String) token.getPrincipal();
		User user = userService.getByUsername(username);
		if(user == null)
			return null;
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes((user.getUsername() + user.getSalt()).getBytes()),getName());
		return authenticationInfo;
	}

}
