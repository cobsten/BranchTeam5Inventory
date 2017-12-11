package sg.edu.iss.inventory.service;

import java.util.ArrayList;

import sg.edu.iss.inventory.model.User;

public interface UserService {

	ArrayList<User> findAllUser();

	User authenticate(String uname, String pwd);
}