package org.techdive.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class InscricaoReqDTO implements Serializable {

    @NotNull(message = "Campo obrigatório: matricula")
    private Integer matriculaAluno;

    @NotNull(message = "Campo obrigatório: codigo")
    private String codigoCurso;


    public InscricaoReqDTO() { }

    public InscricaoReqDTO(Integer matriculaAluno, String codigoCurso) {
        this.matriculaAluno = matriculaAluno;
        this.codigoCurso = codigoCurso;
    }


    public Integer getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(Integer matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

}
