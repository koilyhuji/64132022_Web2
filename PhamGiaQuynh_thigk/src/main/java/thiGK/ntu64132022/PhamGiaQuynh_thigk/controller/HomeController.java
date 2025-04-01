package thiGK.ntu64132022.PhamGiaQuynh_thigk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu64132022.PhamGiaQuynh_thigk.model.Page;
import thiGK.ntu64132022.PhamGiaQuynh_thigk.model.Post;

@Controller
public class HomeController {
    public List<Page> Pages = new ArrayList<>(Arrays.asList(
        new Page(1, "pagenam1", "keyword1", "conethineo noi ehnt oiwehoi wenioe noingio oiengo", 1),
        new Page(2, "pagenam2", "keyword1", "conethineo noi ehnt oiwehoi wenioe noingio oiengo", 1),
        new Page(3, "pagenam3", "keyword2", "conethineo noi ehnt oiwehoi wenioe noingio oiengo", 2),
        new Page(4, "pagenam4", "keyword2", "conethineo noi ehnt oiwehoi wenioe noingio oiengo", 3)
        
    ));

    public List<Post> Posts = new ArrayList<>(Arrays.asList(
        new Post(1,"title1", "lorem isum ordor i nfoie iehjfi weiufwhe fiwenfi jifwehf iwenfie fniefn c",1),
        new Post(2,"title2", "lorem isum ordor i nfoie iehjfi weiufwhe fiwenfi jifwehf iwenfie fniefn c",1),
        new Post(3,"title3", "lorem isum ordor i nfoie iehjfi weiufwhe fiwenfi jifwehf iwenfie fniefn c",1),
        new Post(4,"title4", "lorem isum ordor i nfoie iehjfi weiufwhe fiwenfi jifwehf iwenfie fniefn c",1),
        new Post(5,"title5", "lorem isum ordor i nfoie iehjfi weiufwhe fiwenfi jifwehf iwenfie fniefn c",1)
    ));
	@GetMapping("/")
	public String trangChu() {
		return "home";
	}
	
	@GetMapping("/page/all")
    public String pageall(){

        return "pageall";
    }

}
