package dive.tech.projeto.exercicios.mvc.service;

import dive.tech.projeto.exercicios.mvc.dao.TipoDao;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoService {
    private TipoDao tipoDao = new TipoDao();
}
