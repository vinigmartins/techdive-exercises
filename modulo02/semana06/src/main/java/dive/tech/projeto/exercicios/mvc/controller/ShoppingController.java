package dive.tech.projeto.exercicios.mvc.controller;

import dive.tech.projeto.exercicios.mvc.entity.Shopping;
import dive.tech.projeto.exercicios.mvc.service.ShoppingService;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/mvc/shopping")
@ApplicationScoped
public class ShoppingController {

    private final ShoppingService shoppingService = new ShoppingService();

    @GET
    @Produces("application/json")
    public Response listarShoppingsAtivos(@HeaderParam("Authorization") String authorization) {
        if (!isAuthorized(authorization))
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(shoppingService.listarShoppingAtivos()).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criarShopping(@Valid Shopping shopping,
                                  @HeaderParam("Authorization") String authorization) {
        if (!isAuthorized(authorization))
            return Response.status(Response.Status.NOT_FOUND).build();

        try {
            shoppingService.criarShopping(shopping);
            return Response.ok(shopping).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response alterarShopping(@PathParam("id") Long id,
                                    @Valid Shopping shopping,
                                    @HeaderParam("Authorization") String authorization) {
        if (!isAuthorized(authorization))
            return Response.status(Response.Status.NOT_FOUND).build();

        try {
            shopping.setId(id);
            shoppingService.alterarShopping(shopping);
            return Response.ok(shopping).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response alterarShopping(@PathParam("id") Long id,
                                    @HeaderParam("Authorization") String authorization) {
        if (!isAuthorized(authorization))
            return Response.status(Response.Status.NOT_FOUND).build();

        try {
            shoppingService.deletarShopping(id);
            return Response.ok("Deletado").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("{id}/loja")
    @Produces("application/json")
    public Response listarLojas(@PathParam("id") Long id,
                                @HeaderParam("Authorization") String authorization) {
        if (!isAuthorized(authorization))
            return Response.status(Response.Status.NOT_FOUND).build();

        try {
            return Response.ok(shoppingService.listarLojas(id)).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("{id}/loja/{idLoja}/tipo")
    @Produces("application/json")
    public Response listarTipos(@PathParam("id") Long id,
                                @PathParam("idLoja") Long idLoja,
                                @HeaderParam("Authorization") String authorization) {
        if (!isAuthorized(authorization))
            return Response.status(Response.Status.NOT_FOUND).build();

        try {
            return Response.ok(shoppingService.obterTipoLoja(id, idLoja)).build();
        } catch (RuntimeException e) {
            return Response.status(404, e.getMessage()).build();
        }
    }

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public Response listarShoppingsHtml(@HeaderParam("Authorization") String authorization) {
        if (!isAuthorized(authorization))
            return Response.status(Response.Status.NOT_FOUND).build();

        StringBuilder html = new StringBuilder("<html><ul>");
        List<Shopping> shoppings = shoppingService.listarShopping();

        for (Shopping shopping : shoppings) {
            html.append("<li>").append(shopping.getId()).append(", ").append(shopping.getNome()).append("</li>");
        }

        html.append("</ul></html>");

        return Response.ok(html.toString()).build();
    }

    private boolean isAuthorized(String authorization) {
        return authorization.equals("Bearer codigo123");
    }

}
