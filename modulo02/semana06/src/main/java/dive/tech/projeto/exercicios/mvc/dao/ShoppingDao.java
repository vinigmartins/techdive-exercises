package dive.tech.projeto.exercicios.mvc.dao;

import dive.tech.projeto.exercicios.mvc.entity.Loja;
import dive.tech.projeto.exercicios.mvc.entity.Shopping;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ShoppingDao {
    List<Shopping> shoppings = new ArrayList<>();

    public void criarShopping(Shopping shopping) {
        shoppings.add(shopping);
    }

    public Shopping obterShopping(Long id) {
        for (Shopping shopping : shoppings)
            if (shopping.getId().equals(id))
                return shopping;

        return null;
    }

    public void deletarShopping(Shopping shopping) {
        shopping.setAtivo(false);
        alterarShopping(shopping);
    }

    public void deletarShopping(Long id) {
       Shopping shopping = obterShopping(id);
       deletarShopping(shopping);
    }

    public List<Shopping> listarShoppings() {
        return shoppings;
    }

    public List<Shopping> listarShoppingsAtivos() {
        return shoppings.stream()
                        .filter(Shopping::isAtivo)
                        .collect(Collectors.toList());
    }

    public List<Loja> listarLojas(Long id) {
        return obterShopping(id).getLojas();
    }

    public void alterarShopping(Shopping shopping) {
        int index = shoppings.indexOf(shopping);

        shoppings.get(index).setAtivo(shopping.isAtivo());
        shoppings.get(index).setNome(shopping.getNome());
    }
}
