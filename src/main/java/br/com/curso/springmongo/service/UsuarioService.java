package br.com.curso.springmongo.service;

import br.com.curso.springmongo.domain.Usuario;
import br.com.curso.springmongo.repository.UsuarioRepository;
import br.com.curso.springmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(String id){
        Usuario usuario = usuarioRepository.findOne(id);
        if(usuario == null){
            throw new ObjectNotFoundException("Usuario não encontrado");
        }
        return usuario;

    }
}
