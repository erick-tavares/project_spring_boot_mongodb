package br.com.curso.springmongo.service;

import br.com.curso.springmongo.domain.Post;
import br.com.curso.springmongo.repository.PostRepository;
import br.com.curso.springmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = this.postRepository.findById(id);
        if (post.isPresent()) {
            return post.get();
        }
        throw new ObjectNotFoundException("Postagem não encontrada");
    }


}
