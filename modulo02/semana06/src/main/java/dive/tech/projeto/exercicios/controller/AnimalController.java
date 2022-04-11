package dive.tech.projeto.exercicios.controller;

import dive.tech.projeto.exercicios.entity.Animal;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/animal")
public class AnimalController {

    @GET
    @Produces("application/json")
    public List<String> listarEspecies() {

        List<String> response = new ArrayList<>();
        response.add("Godzilliidae");
        response.add("Pimoa Cthulhu");
        response.add("Darthvaderum");

        return response;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response buscarAnimalPorId(@PathParam("id") Long id) {

        if (id == 1) {
            return Response.ok("Macaco").build();
        } else if (id == 2) {
            return Response.ok("Cachorro").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/filtro")
    @Produces("application/json")
    public Response filtrarAnimais(@QueryParam("nome") String nome,
                                   @QueryParam("especie") String especie) {

        List<Animal> animais = criarListaDeAnimais();

        List<Animal> response = animais
                                .stream()
                                .filter(animal -> (nome == null || nome.isBlank()    || animal.getNome().equalsIgnoreCase(nome))
                                            && (especie == null || especie.isBlank() || animal.getEspecie().equalsIgnoreCase(especie)))
                                .collect(Collectors.toList());

        return (response.isEmpty() ? Response.status(Response.Status.NOT_FOUND) : Response.ok(response)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvarAnimal(Animal animal, @HeaderParam("Authorization") String authorization) {
        if (!authorization.equals("codigo123"))
            return Response.status(Response.Status.FORBIDDEN).build();

        animal.setId(55L);
        return Response.ok(animal).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response alterAnimal(@Valid Animal animal) {
        List<Animal> animais = criarListaDeAnimais();

        int animalIndex = animais.indexOf(animal);

        if (animalIndex == -1)
            return Response.status(Response.Status.NOT_FOUND).build();

        animais.get(animalIndex).setNome(animal.getNome());
        animais.get(animalIndex).setEspecie(animal.getEspecie());

        return Response.ok(animais.get(animalIndex)).build();
    }

    private List<Animal> criarListaDeAnimais() {
        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal(1L, "Abu", "Macaco"));
        animais.add(new Animal(2L, "Marcel", "Macaco"));
        animais.add(new Animal(3L, "Bob", "Cachorro"));
        animais.add(new Animal(4L, "Sagua", "Gato"));
        return animais;
    }

}
