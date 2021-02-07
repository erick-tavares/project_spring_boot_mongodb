package br.com.curso.springmongo.dto;

import br.com.curso.springmongo.domain.Usuario;

import java.io.Serializable;

public class AutorDTO implements Serializable {
    private String id;
    private String nome;

    public AutorDTO() {
    }

    public AutorDTO (Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
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
}
