package br.com.curso.springmongo.resources;

import br.com.curso.springmongo.domain.Usuario;
import br.com.curso.springmongo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity <List<Usuario>> getAll() {
        List<Usuario> usuarioList = usuarioService.findAll();

        return ResponseEntity.ok().body(usuarioList);
    }

}
