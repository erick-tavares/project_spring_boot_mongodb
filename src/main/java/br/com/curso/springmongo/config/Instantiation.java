package br.com.curso.springmongo.config;

import br.com.curso.springmongo.domain.Post;
import br.com.curso.springmongo.domain.Usuario;
import br.com.curso.springmongo.dto.AutorDTO;
import br.com.curso.springmongo.dto.ComentarioDTO;
import br.com.curso.springmongo.repository.PostRepository;
import br.com.curso.springmongo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        usuarioRepository.deleteAll();
        postRepository.deleteAll();

        Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
        Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

        usuarioRepository.save(maria);
        usuarioRepository.save(alex);
        usuarioRepository.save(bob);

        Post post1 = new Post(null, sdf.parse("07/02/2021"), "Partiu viagem","vou para São Paulo", new AutorDTO(maria));
        Post post2 = new Post(null, sdf.parse("05/02/2021"), "Bom dia","Que lindo dia", new AutorDTO(alex));

        ComentarioDTO comment1 = new ComentarioDTO("Boa viagem",sdf.parse("07/02/2021"), new AutorDTO(alex));
        ComentarioDTO comment2 = new ComentarioDTO("Aproveite",sdf.parse("07/02/2021"), new AutorDTO(maria));
        ComentarioDTO comment3 = new ComentarioDTO("Bom dia",sdf.parse("05/02/2021"), new AutorDTO(bob));

        post1.getComentarios().addAll(Arrays.asList(comment1,comment2));
        post2.getComentarios().add(comment3);

        postRepository.save(post1);
        postRepository.save(post2);

        maria.getPosts().addAll(Arrays.asList(post1,post2));

        usuarioRepository.save(maria);





    }
}
