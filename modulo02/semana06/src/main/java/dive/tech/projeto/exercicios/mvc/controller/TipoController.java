package dive.tech.projeto.exercicios.mvc.controller;

import dive.tech.projeto.exercicios.mvc.service.TipoService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;

@Path("/mvc/tipo")
@ApplicationScoped
public class TipoController {
    private TipoService tipoService = new TipoService();
}
