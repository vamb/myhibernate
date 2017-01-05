package com.pear.zcp.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pear.zcp.Util.HirFactory;
import com.pear.zcp.entity.User;
import com.pear.zcp.service.UserService;

public class UserServiceImpl implements UserService {
	
	private SessionFactory sessionFactory = HirFactory.sessionFactory;

	@Override
	public void addUser(User user) {
		if (user != null) {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			session.close();
		}
		return;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		List<User> users = null;
		Session session = sessionFactory.openSession();
		users = session.createQuery("from User").list();
		session.close();
		return users;
	}

	public static void main(String[] args) {
//		for (User user : new UserServiceImpl().getAllUser()) {
//			System.out.println(user.getName());
//		}
//		new UserServiceImpl().addUser(new User("zhangcaiping",(byte) 1,new Date()));
		
		UserServiceImpl impl = new UserServiceImpl();
		List<User> users = impl.getAllUser();
		for(User user: users){
			System.out.print(user.getId()+ " "+ user.getGender()+ " "+ user.getName()+ " "+ user.getBirthday());
			System.out.println(" ");
		}
	}
	
}
