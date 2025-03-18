package com.pgq.Controllers;

import java.lang.ProcessHandle.Info;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pgq.Models.User;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private List<User> users = new ArrayList<>();

	public LoginController() {
		users.add(new User("user1", "password1","nguyen van t",2004,"male"));
        users.add(new User("admin", "adminpass","nguyen van a",2002,"male"));
	}
	@GetMapping
	public String showLoginForm() {
		return "login";
	}
	
	@PostMapping
	public String processLogin
	(@RequestParam String id,
	 @RequestParam String password, 
	 ModelMap m) {
		User user = findUser(id, password);
		if(id.equals(user.getId()) && password.equals(user.getPassword())) {
			m.addAttribute("message","Đăng nhập thành công");
			return "redirect:/home";
		}
		else {
			m.addAttribute("message","Sai thông tin đăng nhập");
		}
		return "login";
	}
	private User findUser(String id, String password) {
        for (User user : users) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}