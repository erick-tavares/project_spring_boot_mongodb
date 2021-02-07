package br.com.curso.springmongo.resources;

import br.com.curso.springmongo.domain.Post;
import br.com.curso.springmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
