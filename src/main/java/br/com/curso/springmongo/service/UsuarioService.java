package br.com.curso.springmongo.service;

import br.com.curso.springmongo.domain.Usuario;
import br.com.curso.springmongo.dto.UsuarioDTO;
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
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        throw new ObjectNotFoundException("Usuario não encontrado");
    }

    public Usuario insert(Usuario usuario){
        return usuarioRepository.insert(usuario);
    }

    public Usuario fromDTO(UsuarioDTO usuario) {
        return new Usuario(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail());
    }
}
