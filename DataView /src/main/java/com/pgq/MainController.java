package com.pgq;

import java.lang.ProcessHandle.Info;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/profile")
	public String thongtinSV(ModelMap model) {
	        model.addAttribute("hoTen", "miew RYuie UYi");
	        model.addAttribute("namSinh", 2004);
	        model.addAttribute("gioiTinh", "Nam");
	        return "profile";
	}
}
