package br.com.curso.springmongo.repository;

import br.com.curso.springmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTituloContainingIgnoreCase(String txt);

    @Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitulo(String txt);

    //Busca por texto em titulo, corpo ou comentario, entre intervalo de datas
    @Query("{ $and: [ { data: {$gte: ?1} }, { data: {$lte: ?2} } , " +
            "{ $or: [ { 'titulo': { $regex: ?0, $options: 'i' } } , { 'corpo': { $regex: ?0, $options: 'i' } }, " +
            "{ 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch (String txt, Date minDate, Date maxDate);
}
