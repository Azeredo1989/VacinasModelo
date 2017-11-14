/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "vacina")
public class Vacina implements  Serializable{
    @Id
    @SequenceGenerator(name = "seq_vacina", sequenceName = "seq_vacina_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_vacina",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome deve ser preenchido")
    @Length(max = 100, message = "O campo nome não deve ter mais de {max} caracter")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @Column(name = "descricao", nullable = false, length = 500)
    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descricao deve ser preenchido")
    @Length(max = 500, message = "O campo descricao não deve ter mais de {max} caracter")
    private String descricao;
    
    @Column(name = "mes", nullable = false, length = 2)
    @NotNull(message = "O campo mes não pode ser nulo")
    //@NotBlank(message = "O campo mes deve ser preenchido")
    //@Length(max = 2, message = "O campo mes não deve ter mais de {max} caracter")
    private Integer mes;

    public Vacina() {
    }

    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the mes
     */
    public Integer getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(Integer mes) {
        this.mes = mes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
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
        final Vacina other = (Vacina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
