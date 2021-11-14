package com.devcreativa.restful.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcreativa.restful.models.User;
import com.devcreativa.restful.repositories.UserRepository;

@Service
public class UserService implements BaseService<User> {

	// Dependency injection via @Autowrite
	@Autowired
	private UserRepository userRepo;

	@Override
	@Transactional
	public List<User> findAll() throws Exception {

		try {
			List<User> entity = userRepo.findAll();
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public User findById(Long id) throws Exception {
		try {
			Optional<User> user = userRepo.findById(id);
			return user.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public User save(User entity) throws Exception {
		try {
			entity = userRepo.save(entity);
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public User update(Long id, User entity) throws Exception {
		try {
			Optional<User> entityOp = userRepo.findById(id);

			User user = entityOp.get();

			user = userRepo.save(entity);

			return user;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try {
			if (userRepo.existsById(id)) {
				userRepo.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
}
