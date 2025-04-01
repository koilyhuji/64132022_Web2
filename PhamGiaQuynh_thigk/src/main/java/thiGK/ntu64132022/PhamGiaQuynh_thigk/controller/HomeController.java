package thiGK.ntu64132022.PhamGiaQuynh_thigk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu64132022.PhamGiaQuynh_thigk.model.Page;
import thiGK.ntu64132022.PhamGiaQuynh_thigk.model.Post;

@Controller
public class HomeController {
    
    
	@GetMapping("/")
	public String trangChu() {
		return "home";
	}
	
	

   

}
