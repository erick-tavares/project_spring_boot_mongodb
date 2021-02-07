package br.com.curso.springmongo.service;

import br.com.curso.springmongo.domain.Post;
import br.com.curso.springmongo.repository.PostRepository;
import br.com.curso.springmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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

    //Consulta com Spring Data
    public List<Post> findByTitulo(String txt){
        return this.postRepository.findByTituloContainingIgnoreCase(txt);
    }

    //Consulta com @Query
    public List<Post> searchByTitulo(String txt){
        return this.postRepository.findByTitulo(txt);
    }

    public List<Post> fullSearch(String txt, Date minData, Date maxData){
        return this.postRepository.fullSearch(txt,minData, finalDia(maxData));
    }

    public Date finalDia(Date data){
        return new Date(data.getTime() + (24 * 60 * 60 * 1000));
    }
}
