package com.giftcard.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giftcard.entitys.ShippingAddress;
import com.giftcard.entitys.User;
import com.giftcard.exceptionutility.BadRequestException;
import com.giftcard.repos.UserRepository;
import com.giftcard.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	@Override
	public Optional<User> getByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public Boolean saveUser(User user) {
		if (user == null) {
			throw new BadRequestException("user details is mandatory");
		}
		Optional<User> userDetails = getByUsername(user.getUsername());
		if (userDetails.isPresent()) {
			throw new BadRequestException("user name already exists");
		}
		user.setUserBlocked(Boolean.FALSE);
		this.userRepository.save(user);
		return null ;
	}

	@Override
	public void blockOrUnblockUser(String userName,Boolean value) {

		Optional<User> userDetails = getByUsername(userName);
		if (!userDetails.isPresent()) {
			throw new BadRequestException("user not available or already blocked");
		}
		userDetails.get().setUserBlocked(value);
		this.userRepository.save(userDetails.get());
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return Boolean.TRUE;
	}

	@Override
	public boolean login(String userName, String password) {
		// TODO Auto-generated method stub
		return Boolean.TRUE;
	}

	@Override
	public boolean resetPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return Boolean.TRUE;
	}

	@Override
	public void placeOrder(ShippingAddress shippingAddress, Long giftAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean sendGiftcard(String emailId) {
		// TODO Auto-generated method stub
		return Boolean.TRUE;
	}

	@Override
	public boolean deleteOrderById(String orderId) {
		// TODO Auto-generated method stub
		return false;
	}
}
