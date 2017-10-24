package com.br.pontu.entity;

import com.br.pontu.enums.Departamento;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.br.pontu.enums.EstadoCivil;
import com.br.pontu.enums.Role;
import java.util.Objects;

/**
 * Entidade que é responsável pelo dados dos usuários Sendo eles de carater
 * administrador ou funcionários Sendo separados por niveis de acesso em suas
 * funções
 *
 * @author Alves
 */
@Entity
@Table(name = "usuario")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //  Atributos Inicio   =========================================================================
    private Long id;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String cpf;
    private String carteiraDeTrabalho;
    private String rg;
    private String celular;
    private String fixo;
    private EstadoCivil estadoCivil;
    private String email;
    private String cargo;
    private String matricula;

    private String password;

    private Role acesso;
    private Adress endereco;
//        private List<PontoDataHora> ponto;
    private Departamento departamento;

    // FIM ========================================================================================
    /**
     * Getters And Setters Contendo as anotações de verificação
     * =======================================================
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 5)
    public String getMatricula() {
        return matricula;
    }

        public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 15)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 60)
    @Column(nullable = false, length = 60)
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @NotNull
    @Column(name = "data_nascimento", nullable = false)
    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @NotNull
    @NotEmpty
    @Size(min = 13, max = 13)
    @Column(nullable = false, length = 13, unique = true)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20, unique = true)
    public String getCarteiraDeTrabalho() {
        return carteiraDeTrabalho;
    }

    public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
        this.carteiraDeTrabalho = carteiraDeTrabalho;
    }

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20, unique = true)
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 16)
    @Column(nullable = false, length = 16)
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    // Este Atributo pode ser opcional, sendo não é necessário
    // Validação
    @Size(max = 16)
    @Column(length = 16)
    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 60)
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @NotNull
    @NotEmpty
    @Email
    @Size(min = 7, max = 90)
    @Column(nullable = false, length = 90, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    @NotEmpty
    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//	 @NotNull
//	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//	 public List<PontoDataHora> getPonto() {
//			return ponto;
//	}
//	public void setPonto(List<PontoDataHora> ponto) {
//			this.ponto = ponto;
//	}
    @Embedded
    public Adress getEndereco() {
        return endereco;
    }

    public void setEndereco(Adress endereco) {
        this.endereco = endereco;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public Role getAcesso() {
        return acesso;
    }

    public void setAcesso(Role acesso) {
        this.acesso = acesso;
    }

    @NotNull
    @NotEmpty
    @Column(name = "cargo", nullable = false, length = 60)
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 60)
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * FIM
     * ====================================================================================
     */
    // Equals and Hash Code -------------------------------------------------------------------
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((carteiraDeTrabalho == null) ? 0 : carteiraDeTrabalho.hashCode());
        result = prime * result + ((celular == null) ? 0 : celular.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((rg == null) ? 0 : rg.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        if (carteiraDeTrabalho == null) {
            if (other.carteiraDeTrabalho != null) {
                return false;
            }
        } else if (!carteiraDeTrabalho.equals(other.carteiraDeTrabalho)) {
            return false;
        }
        if (celular == null) {
            if (other.celular != null) {
                return false;
            }
        } else if (!celular.equals(other.celular)) {
            return false;
        }
        if (cpf == null) {
            if (other.cpf != null) {
                return false;
            }
        } else if (!cpf.equals(other.cpf)) {
            return false;
        }
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (rg == null) {
            if (other.rg != null) {
                return false;
            }
        } else if (!rg.equals(other.rg)) {
            return false;
        }
        return true;
    }
    //------------------------------------------------------------------------------------------

    /**
     * Métodos Auxiliares
     * ---------------------------------------------------------------------
     */
}
