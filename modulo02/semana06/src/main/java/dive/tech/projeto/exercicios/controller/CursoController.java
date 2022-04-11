package dive.tech.projeto.exercicios.controller;

import dive.tech.projeto.exercicios.entity.Curso;
import dive.tech.projeto.exercicios.service.CursoService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/curso")
public class CursoController {

    private final CursoService cursoService = new CursoService();

    @GET
    @Produces("application/json")
    public List<Curso> listarCursos() {
        return cursoService.obterCursos();
    }

    @GET
    @Produces("application/json")
    public List<Curso> listarCursosPorNome(@QueryParam("nome") String nome) {
        return cursoService.obterCursos()
                .stream()
                .filter(curso -> curso.getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criarCurso(Curso curso, @HeaderParam("Authorization") String authorization) {
        if (!authorization.equals("senha123"))
            return Response.status(Response.Status.FORBIDDEN).build();

        curso = cursoService.criarCurso(curso);

        return Response.ok(curso)
                .status(201)
                .build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response buscarCursoPorId(@PathParam("id") Long id) {
        Optional<Curso> cursoEncontrado = cursoService.obterCursos()
                .stream()
                .filter(curso -> curso.getId().equals(id))
                .findFirst();
        if (cursoEncontrado.isPresent())
            return Response.ok(cursoEncontrado).build();

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response editarCurso(Curso curso) {
        Optional<Curso> cursoEncontrado = cursoService.obterCursos()
                .stream()
                .filter(c -> c.getId().equals(curso.getId()))
                .findFirst();

        if (cursoEncontrado.isPresent()) {
            cursoEncontrado.get().setNome(curso.getNome());
            cursoEncontrado.get().setDisciplinas(curso.getDisciplinas());
            return Response.ok(cursoEncontrado).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response deletarCursoPorId(@PathParam("id") Long id) {
        List<Curso> cursos = cursoService.obterCursos()
                .stream()
                .filter(curso -> !curso.getId().equals(id))
                .collect(Collectors.toList());
        if (!cursos.isEmpty())
            return Response.ok(cursos).build();

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
