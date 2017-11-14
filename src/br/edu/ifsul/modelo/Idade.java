/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "idade")
public class Idade implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_idade", sequenceName = "seq_idade_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_idade", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "descricao", nullable = false, length = 100)
    @NotBlank(message = "Descricao deve ser informada")
    @NotNull(message = "Descricao não pode ser nula")
    @Length(max = 100, message = "O nome não pode ter mais de {max} caracteres")
    private String descricao;
    
    @Column(name = "mes_inicial", nullable = false, length = 2)
    //@NotBlank(message = "Mês inicial deve ser informado")
    @NotNull(message = "Mês inicial não pode ser nulo")
    //@Length(max = 2, message = "O Mês inicial não pode ter mais de {max} caracteres")
    private Integer mes_inicial;
    
    @Column(name = "mes_final", nullable = false, length = 2)
    //@NotBlank(message = "Mês final deve ser informado")
    @NotNull(message = "Mês final não pode ser nulo")
    //@Length(max = 2, message = "O Mês final não pode ter mais de {max} caracteres")
    private Integer mes_final;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vacinas",
            joinColumns = 
                    @JoinColumn(name = "Idade", referencedColumnName = "descricao", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "Vacina", referencedColumnName = "nome", nullable = false),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"Idade","Vacina"})})
    
    private List<Vacina> vacinas = new ArrayList<>();

    public Idade() {
    }

    public void adicionarVacina(Vacina obj){
        this.vacinas.add(obj);
    }
    
    public void removerVacina(int index){
        this.vacinas.remove(index);
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
     * @return the mes_inicial
     */
    public Integer getMes_inicial() {
        return mes_inicial;
    }

    /**
     * @param mes_inicial the mes_inicial to set
     */
    public void setMes_inicial(Integer mes_inicial) {
        this.mes_inicial = mes_inicial;
    }

    /**
     * @return the mes_final
     */
    public Integer getMes_final() {
        return mes_final;
    }

    /**
     * @param mes_final the mes_final to set
     */
    public void setMes_final(Integer mes_final) {
        this.mes_final = mes_final;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Idade other = (Idade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the vacinas
     */
    public List<Vacina> getVacinas() {
        return vacinas;
    }

    /**
     * @param vacinas the vacinas to set
     */
    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

}
