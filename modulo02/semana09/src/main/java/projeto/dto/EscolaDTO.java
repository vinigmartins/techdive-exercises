package projeto.dto;

import projeto.entity.Endereco;
import projeto.entity.Escola;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

public class EscolaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idEscola;

    private String nome;

    private Date criacao;

    private Long idEndereco;

    public EscolaDTO() {
    }

    public EscolaDTO(Escola escola) {
        this.idEscola = escola.getIdEscola();
        this.nome = escola.getNome();
        this.criacao = escola.getCriacao();
        this.idEndereco = escola.getEndereco() != null ? escola.getEndereco().getIdEndereco() : null;
    }

    public Long getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(Long idEscola) {
        this.idEscola = idEscola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }
}
