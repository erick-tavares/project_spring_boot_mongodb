package br.com.curso.springmongo.config;

import br.com.curso.springmongo.domain.Usuario;
import br.com.curso.springmongo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        usuarioRepository.deleteAll();

        Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
        Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

        usuarioRepository.save(maria);
        usuarioRepository.save(alex);
        usuarioRepository.save(bob);
    }
}
