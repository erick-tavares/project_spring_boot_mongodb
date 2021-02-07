package br.com.curso.springmongo.resources;

import br.com.curso.springmongo.domain.Post;
import br.com.curso.springmongo.resources.util.URLUtil;
import br.com.curso.springmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostRest {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity <Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);

        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titulo")
    public ResponseEntity <List<Post>> findByTitulo(@RequestParam (value="txt", defaultValue="") String txt) {
        txt = URLUtil.decodeParam(txt);
        List<Post> posts = postService.findByTitulo(txt);

        return ResponseEntity.ok().body(posts);
    }


    @GetMapping(value = "/tituloquery")
    public ResponseEntity <List<Post>> searchByTitulo(@RequestParam (value="txt", defaultValue="") String txt) {
        txt = URLUtil.decodeParam(txt);
        List<Post> posts = postService.searchByTitulo(txt);

        return ResponseEntity.ok().body(posts);
    }
}
