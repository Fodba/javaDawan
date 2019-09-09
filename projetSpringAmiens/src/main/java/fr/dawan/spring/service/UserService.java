package fr.dawan.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.spring.dao.UserDao;
import fr.dawan.spring.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	public void create(User user) {
		userDao.create(user);
	}

	@Transactional
	public List<User> readAll() {
		return userDao.readAll();
	}

	@Transactional
	public User readById(long id) {
		return userDao.readById(id);
	}

	@Transactional
	public User readByEmail(String email) {
		return userDao.readByEmail(email);
	}

	@Transactional
	public void delete(User user) {
		userDao.delete(user);
	}

	@Transactional
	public void update(User user) {
		userDao.update(user);
	}

	@Transactional
	public void count() {
		userDao.count();
	}

	@Transactional
	public List<User> readPartial(int start, int nbElements) {
		return userDao.readPartial(start, nbElements);
	}

}
