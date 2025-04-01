package thiGK.ntu64132022.PhamGiaQuynh_thigk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/")
	public String trangChu() {
		return "home";
	}
	
	@GetMapping("/about")
	public String about(ModelMap modelmap) {
	    modelmap.addAttribute("hoten", "pham gia quynh");
	    modelmap.addAttribute("avatar", "images/avatar.png");
	    modelmap.addAttribute("lop", "64.CNTT-CLC2");
	    modelmap.addAttribute("msvv", "64132022");
	    return "about";
	}

}
