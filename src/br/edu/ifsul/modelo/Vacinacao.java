/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "vacinacao")
public class Vacinacao implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_vacinacao", sequenceName = "seq_vacinacao_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_vacinacao",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome", nullable = false, length = 150)
    @Length(max = 150, message = "O nome não pode ter mais de {max} caracteres")
//  @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome deve ser informado")
    private String nome;
    
    @Column(name = "data_previsao", nullable = false)
    @Temporal(value = TemporalType.DATE)
//    @NotNull(message = "A data de previsão não pode ser nula")
    private Calendar data_previsao;
    
//    @Column(name = "data_realizacao")
//    @Temporal(value = TemporalType.DATE)
    private Calendar data_realizacao;
    
//    @Column(name = "unidade",  length = 100)
//    @Length(max = 100, message = "A unidade não pode ter mais de {max} caracteres")
    
    private String unidade;
    
//    @Column(name = "profissional", length = 150)
//    @Length(max = 150, message = "O profissional não pode ter mais de {max} caracteres")
    private String profissional;
    
    @NotNull(message = "A Criança deve ser informada")
    @ManyToOne
    @JoinColumn(name = "crianca_id", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_crianca_id")
    private Crianca crianca;
    
    @NotNull(message = "A vacina deve ser informada")
    @ManyToOne
    @JoinColumn(name = "vacina_id", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_vacina_id")
    private Vacina vacina;

    public Vacinacao() {
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Vacinacao other = (Vacinacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
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
     * @return the data_previsao
     */
    public Calendar getData_previsao() {
        return data_previsao;
    }

    /**
     * @param data_previsao the data_previsao to set
     */
    public void setData_previsao(Calendar data_previsao) {
        this.data_previsao = data_previsao;
    }

    /**
     * @return the data_realizacao
     */
    public Calendar getData_realizacao() {
        return data_realizacao;
    }

    /**
     * @param data_realizacao the data_realizacao to set
     */
    public void setData_realizacao(Calendar data_realizacao) {
        this.data_realizacao = data_realizacao;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the profissional
     */
    public String getProfissional() {
        return profissional;
    }

    /**
     * @param profissional the profissional to set
     */
    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    /**
     * @return the crianca
     */
    public Crianca getCrianca() {
        return crianca;
    }

    /**
     * @param crianca the crianca to set
     */
    public void setCrianca(Crianca crianca) {
        this.crianca = crianca;
    }

    /**
     * @return the vacina
     */
    public Vacina getVacina() {
        return vacina;
    }

    /**
     * @param vacina the vacina to set
     */
    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }
    
    
}
