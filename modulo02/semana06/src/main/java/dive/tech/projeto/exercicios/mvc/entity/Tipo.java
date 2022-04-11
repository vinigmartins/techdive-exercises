package dive.tech.projeto.exercicios.mvc.entity;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Tipo implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 3, message = "O tipo precisa ter no mínimo 3 caracteres!")
    @Size(max = 20, message = "O tipo precisa ter no máximo 20 caracteres!")
    private String tipo;

    public Tipo() {
    }

    public Tipo(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tipo tipo = (Tipo) o;

        return id.equals(tipo.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
