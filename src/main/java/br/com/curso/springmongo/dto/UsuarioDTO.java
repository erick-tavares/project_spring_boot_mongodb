package br.com.curso.springmongo.dto;

import br.com.curso.springmongo.domain.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO implements Serializable {

    private String id;
    private String nome;
    private String email;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioDTO of(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail());
    }

    public List<UsuarioDTO> of(List<Usuario> usuarioList) {
        List<UsuarioDTO> dtoList = new ArrayList<>();

        for (Usuario usuario : usuarioList) {
            UsuarioDTO dto = new UsuarioDTO().of(usuario);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
