package com.pgq.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.pgq.Models.User;

@Controller
public class AboutController {
    
    @GetMapping("/about")
    public String about(ModelMap map) {
        
        User user = new User(
            "pham gia quynh ",
            "64132022",
            "sinh vien truong dai hoc nha trang. " +
            "cong nghe thong tin",
            "github.com/koilyhuji",
            "/images/profile.png"
        );
        
        map.addAttribute("user", user);
        
        return "about";
    }
}
