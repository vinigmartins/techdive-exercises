package dive.tech.projeto.exercicios.mvc.service;

import dive.tech.projeto.exercicios.mvc.dao.ShoppingDao;
import dive.tech.projeto.exercicios.mvc.entity.Loja;
import dive.tech.projeto.exercicios.mvc.entity.Shopping;
import dive.tech.projeto.exercicios.mvc.entity.Tipo;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ShoppingService {
    private ShoppingDao shoppingDao = new ShoppingDao();

    public void criarShopping(Shopping shopping) {
        if (validarIdExistente(shopping)) throw new RuntimeException("Id Ja cadastrado");
        shoppingDao.criarShopping(shopping);
    }

    public List<Shopping> listarShopping() {
        return shoppingDao.listarShoppings();
    }

    public List<Shopping> listarShoppingAtivos() {
        return shoppingDao.listarShoppingsAtivos();
    }

    public List<Loja> listarLojas(Long id) {
        if (shoppingDao.obterShopping(id) == null) throw new RuntimeException("Id não cadastrado");
        return shoppingDao.listarLojas(id);
    }

    public Tipo obterTipoLoja(Long id, Long idLoja) {
        List<Loja> lojas = listarLojas(id);

        for (Loja loja : lojas)
            if (loja.getId().equals(idLoja))
                return loja.getTipo();

        throw new RuntimeException("ID da loja não cadastrado");
    }

    public void deletarShopping(Long id) {
        if (shoppingDao.obterShopping(id) == null) throw new RuntimeException("Id não cadastrado");
        shoppingDao.deletarShopping(id);
    }

    public void alterarShopping(Shopping shopping) {
        if (!validarIdExistente(shopping)) throw new RuntimeException("Id não cadastrado");
        shoppingDao.alterarShopping(shopping);
    }

    private boolean validarIdExistente(Shopping shopping) {
        return listarShopping().contains(shopping);
    }
}
