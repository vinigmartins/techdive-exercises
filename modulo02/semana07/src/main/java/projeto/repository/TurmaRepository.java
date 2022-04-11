package projeto.repository;

import projeto.dto.EstudanteDTO;
import projeto.dto.TurmaDTO;
import projeto.entity.Turma;

import java.util.List;

public class TurmaRepository extends GenericRepository {

    public List<TurmaDTO> consultarTurmas() {
        return entityManager.createNamedQuery(Turma.GET_TURMASDTO, TurmaDTO.class)
                .getResultList();
    }

    public List<EstudanteDTO> consultarEstudantesSemTurmas() {
        return entityManager.createQuery("SELECT new projeto.dto.EstudanteDTO(e) " +
                        "FROM Estudante e " +
                        "WHERE e.turma is null", EstudanteDTO.class)
                .getResultList();
    }
}
