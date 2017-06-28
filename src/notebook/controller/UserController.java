package notebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import notebook.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value = "/login")
	public ModelAndView login(User user){
		return new ModelAndView();
	}
	
	@RequestMapping(value = "/signup")
	public ModelAndView signUp(User user){
		return new ModelAndView();
	}
	
	@RequestMapping(value = "/profile")
	public ModelAndView showProfile(){
		return new ModelAndView();
	}
	
	@RequestMapping(value = "/edit")
	public ModelAndView editProfile(User user){
		return new ModelAndView();
	}
	
	@RequestMapping(value = "/delete")
	public ModelAndView deleteProfile(){
		return new ModelAndView();
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(User user){
		return new ModelAndView();
	}
	
}
