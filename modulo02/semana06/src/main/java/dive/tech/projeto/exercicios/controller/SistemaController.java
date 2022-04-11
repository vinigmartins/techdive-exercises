package dive.tech.projeto.exercicios.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/sistema")
public class SistemaController {

    @GET
    @Path("/cabecalho")
    @Produces(MediaType.TEXT_PLAIN)
    public String exibirCabecalho(@Context HttpHeaders headers) {
        StringBuilder cabecalhos = new StringBuilder();

        for (String nome : headers.getRequestHeaders().keySet()) {
            String valor = headers.getRequestHeaders().getFirst(nome);
            cabecalhos.append(nome).append(": ").append(valor).append("\n");
        }
        return cabecalhos.toString();
    }

    @GET
    @Path("/cookie")
    @Produces(MediaType.APPLICATION_JSON)
    public String exibirCookie(@HeaderParam("Cookie") String cookies) {
        return "Cookies encontrados:\n" + cookies;
    }

    @POST
    @Path("/cookie")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postarCookie(String valorCookie) {
        NewCookie cookie = new NewCookie("meuCookie", valorCookie);

        return Response.ok("Novo cookie").cookie(cookie).build();
    }
}
