package thiGK.ntu64132022.PhamGiaQuynh_thigk.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu64132022.PhamGiaQuynh_thigk.model.Page;

@Controller
public class PageController {
    public List<Page> Pages = new ArrayList<>(Arrays.asList(
        new Page(1, "pagenam1", "keyword1", "conethineo noi ehnt oiwehoi wenioe noingio oiengo", 1),
        new Page(2, "pagenam2", "keyword1", "conethineo noi ehnt oiwehoi wenioe noingio oiengo", 1),
        new Page(3, "pagenam3", "keyword2", "conethineo noi ehnt oiwehoi wenioe noingio oiengo", 2),
        new Page(4, "pagenam4", "keyword2", "conethineo noi ehnt oiwehoi wenioe noingio oiengo", 3)
        
    ));

    @GetMapping("/page/new")
    public String shownewForm(ModelMap model) {
        
        return "pagenew";
    }

    @PostMapping("/page/new")
    public String addPage(
    @RequestParam("pagename") String pagename,
    @RequestParam("keyword") String keyword,
    @RequestParam("content") String content,
    @RequestParam("pageParentId") int pageParentId) {
        
        int newId = Pages.stream().mapToInt(Page::getId).max().orElse(0) + 1;
  
        Pages.add(new Page(newId,pagename,keyword,content,pageParentId));
        return "redirect:/page/all";
    }
    @GetMapping("/page/all")
    public String pageall(ModelMap modelmap){
        modelmap.addAttribute("Pages", Pages);
        return "pageall";
    }

    @GetMapping("/page/view/{id}")
    public String viewPage(@PathVariable("id") int id, ModelMap model) {
        Page page = new Page();
        for(Page page2 : Pages){
            if(page2.getId() == id){
                page = page2;
            }

        }
        model.addAttribute("page", page);
        return "pageview";
    }

    // Show delete confirmation
    @GetMapping("/page/delete/{id}")
    public String showDeleteForm(@PathVariable("id") int id, ModelMap model) {
        Page page = Pages.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Invalid page Id:" + id));
        model.addAttribute("page", page);
        return "pagedelete";
    }

    @PostMapping("/page/delete/{id}")
    public String deletePage(@PathVariable("id") int id) {
        Pages.removeIf(page -> page.getId() == id);
        return "redirect:/page/all";
    }
}
