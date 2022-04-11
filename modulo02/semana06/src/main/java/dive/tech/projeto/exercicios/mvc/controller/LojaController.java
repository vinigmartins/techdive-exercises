package dive.tech.projeto.exercicios.mvc.controller;

import dive.tech.projeto.exercicios.mvc.service.LojaService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;

@Path("/mvc/loja")
@ApplicationScoped
public class LojaController {
    private LojaService lojaService = new LojaService();
}
