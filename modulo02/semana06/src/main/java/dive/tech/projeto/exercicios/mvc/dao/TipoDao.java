package dive.tech.projeto.exercicios.mvc.dao;

import dive.tech.projeto.exercicios.mvc.entity.Tipo;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TipoDao {

    private final List<Tipo> tipos = new ArrayList<>();
}
