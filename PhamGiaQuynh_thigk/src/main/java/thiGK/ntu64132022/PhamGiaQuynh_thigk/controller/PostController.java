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


import thiGK.ntu64132022.PhamGiaQuynh_thigk.model.Post;

@Controller
public class PostController {
    public List<Post> Posts = new ArrayList<>(Arrays.asList(
        new Post(1,"title1", "lorem isum ordor i nfoie iehjfi weiufwhe fiwenfi jifwehf iwenfie fniefn c",1),
        new Post(2,"title2", "lorem isum ordor i nfoie iehjfi weiufwhe fiwenfi jifwehf iwenfie fniefn c",1),
        new Post(3,"title3", "lorem isum ordor i nfoie iehjfi weiufwhe fiwenfi jifwehf iwenfie fniefn c",1),
        new Post(4,"title4", "lorem isum ordor i nfoie iehjfi weiufwhe fiwenfi jifwehf iwenfie fniefn c",1),
        new Post(5,"title5", "lorem isum ordor i nfoie iehjfi weiufwhe fiwenfi jifwehf iwenfie fniefn c",1)
    ));

    @GetMapping("/post/new")
    public String shownewForm(ModelMap model) {
        
        return "postnew";
    }

    @PostMapping("/post/new")
    public String addpost(
    @RequestParam("title") String title,
    @RequestParam("content") String content,
    @RequestParam("categoryId") int categoryId) {
        
        int newId = Posts.stream().mapToInt(Post::getId).max().orElse(0) + 1;
  
        Posts.add(new Post(newId,title,content,categoryId));
        return "redirect:/post/all";
    }
    @GetMapping("/post/all")
    public String postall(ModelMap modelmap){
        modelmap.addAttribute("Posts", Posts);
        return "postall";
    }

    @GetMapping("/post/view/{id}")
    public String viewpost(@PathVariable("id") int id, ModelMap model) {
        Post post = new Post();
        for(Post post2 : Posts){
            if(post2.getId() == id){
                post = post2;
            }

        }
        model.addAttribute("post", post);
        return "postview";
    }

    // Show delete confirmation
    @GetMapping("/post/delete/{id}")
    public String showDeleteForm(@PathVariable("id") int id, ModelMap model) {
        Post Post = Posts.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Invalid Post Id:" + id));
        model.addAttribute("Post", Post);
        return "Postdelete";
    }


    @PostMapping("/Post/delete/{id}")
    public String deletePost(@PathVariable("id") int id) {
        Posts.removeIf(Post -> Post.getId() == id);
        return "redirect:/Post/all";
    }
}
