package sg.edu.iss.inventory.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.inventory.model.User;
import sg.edu.iss.inventory.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see sg.edu.iss.inventory.service.StudentService#findAllUser()
	 */
	@Override
	@Transactional
	public ArrayList<User> findAllUser()
	{
		ArrayList<User> userList = (ArrayList<User>)userRepository.findAll();
		return userList;
	}
	
	@Transactional
	public User authenticate(String userId, String password) {
		User u = userRepository.findUserByNamePwd(userId, password);
		return u;
	}
	

}
