package dive.tech.projeto.exercicios.mvc.service;

import dive.tech.projeto.exercicios.mvc.dao.LojaDao;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LojaService {
    private LojaDao lojaDao = new LojaDao();
}
