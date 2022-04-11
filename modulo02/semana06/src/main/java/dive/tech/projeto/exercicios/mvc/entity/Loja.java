package dive.tech.projeto.exercicios.mvc.entity;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Loja implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 3, message = "O nome precisa ter no mínimo 3 caracteres!")
    @Size(max = 20, message = "O nome precisa ter no máximo 20 caracteres!")
    private String nome;

    @NotNull
    private @Valid Tipo tipo;

    public Loja() {
    }

    public Loja(Long id, String nome, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loja loja = (Loja) o;

        return id.equals(loja.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
