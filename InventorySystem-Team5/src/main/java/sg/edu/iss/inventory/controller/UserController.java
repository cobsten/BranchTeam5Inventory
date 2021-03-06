package sg.edu.iss.inventory.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.iss.inventory.model.User;
import sg.edu.iss.inventory.service.UserService;
import sg.edu.iss.inventory.validator.UserValidator;

@RequestMapping(value="user")
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	private UserValidator uValidator;

/*	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
	}*/
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView userListPage() {
		ModelAndView mav = new ModelAndView("user-list");
		ArrayList<User> userList = (ArrayList<User>)userService.findAllUser();
		mav.addObject("userList", userList);
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String newUserPage(Model model) {
		User user = new User();
		model.addAttribute(user);
		return "user-new";
	}
	
//	@RequestMapping(value="/create",method= RequestMethod.POST)
//	public ModelAndView createNewUser(@ModelAttribute UserController user,BiBindingResult result,final RedirectAttributes redirectAttributes)
//	{
////		if(result.hasError())
////		{
////			return new ModelAndView("user-new");
////		}
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		return modelAndView;
//	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logic(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model,HttpSession session) {
		session.invalidate();
		return "redirect:/user/login";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors())
			return mav;
		UserSession us = new UserSession();
		if (user.getUserId() != null && user.getPassword() != null) {
			User u = userService.authenticate(user.getUserId(), user.getPassword());
			if(u != null)
			{
				us.setUser(u);
				// PUT CODE FOR SETTING SESSION ID
				us.setSessionId(session.getId());
				mav = new ModelAndView("redirect:/product/list");
			}
			else
			{		
				return mav;
			}
			
		}
		else
		{		
			return mav;
		}
		session.setAttribute("USERSESSION", us);
		return mav;
	}
}
