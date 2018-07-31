//package sin.test.jeesite.service;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//
//import sin.glouds.bean.Page;
//import sin.glouds.service.BaseService;
//import sin.test.jeesite.dao.UserDao;
//import sin.test.jeesite.entity.User;
//
//@Service
//public class UserService extends BaseService {
//
//	@Resource
//	private UserDao userDao;
//	
//	public List<User> findList() {
//		return userDao.findList();
//	}
//	
//	public Page<User> findPage(int pageNum, int pageSize) {
//		startPage(pageNum, pageSize);
//		return super.findPage(userDao.findList());
//	}
//}
