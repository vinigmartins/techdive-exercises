package dive.tech.projeto.exercicios.dao;

import dive.tech.projeto.exercicios.entity.Curso;
import dive.tech.projeto.exercicios.entity.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class CursoDao {

    public List<Curso> obterCursos() {
        List<Curso> cursos = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            Curso curso = new Curso(i);

            for (int j = 1; j < 4; j++) {
                Disciplina disciplina = new Disciplina(curso.getNome(), j);
                curso.getDisciplinas().add(disciplina);
            }

            cursos.add(curso);
        }
        return cursos;
    }

    public Curso criarCurso(Curso curso) {
        curso.setId(1L);
        return curso;
    }
}
