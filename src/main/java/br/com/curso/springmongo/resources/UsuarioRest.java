package br.com.curso.springmongo.resources;

import br.com.curso.springmongo.domain.Usuario;
import br.com.curso.springmongo.dto.UsuarioDTO;
import br.com.curso.springmongo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity <List<UsuarioDTO>> getAll() {
        List<Usuario> usuarioList = usuarioService.findAll();
        //Lambda
        //List<UsuarioDTO> dtoList = usuarioList.stream().map(x -> new UsuarioDTO()).collect(Collectors.toList());
        List<UsuarioDTO> dtoList = new ArrayList<>();

        for(Usuario user : usuarioList){
            UsuarioDTO dto = new UsuarioDTO().of(user);
            dtoList.add(dto);
        }
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <UsuarioDTO> findById(@PathVariable String id) {
        Usuario usuario = usuarioService.findById(id);

        return ResponseEntity.ok().body(new UsuarioDTO().of(usuario));
    }

}
