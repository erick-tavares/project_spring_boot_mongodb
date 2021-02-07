package br.com.curso.springmongo.repository;

import br.com.curso.springmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTituloContainingIgnoreCase(String txt);

    @Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitulo(String txt);
}
