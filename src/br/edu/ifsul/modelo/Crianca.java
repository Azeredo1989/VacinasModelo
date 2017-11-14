/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "crianca")
public class Crianca implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_crianca", sequenceName = "seq_crianca_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_crianca", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @NotNull(message = "O nome nã pode ser nulo")
    @Length(max = 100, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @Temporal(value = TemporalType.DATE)
    //@NotBlank(message = "O nascimento deve ser informado")
    @NotNull(message = "O nascimento não pode ser nulo")
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    
    @NotNull(message = "Sexo não pode ser nulo")
    @NotBlank(message = "Sexo deve ser informado")
    @Length(max = 15, message = "Sexo não deve ter mais do que {max} caracteres")
    @Column(name = "sexo", nullable = false, length = 15)
    private String sexo;
    
    @NotBlank(message = "O nome dos pais deve ser informado")
    @NotNull(message = "O nome dos pais não pode ser nulo")
    @Length(max = 200, message = "O nome dos pais não deve ter mais de {max}caracteres")
    @Column(name = "nomePais", nullable = false, length = 200)
    private String nomePais;
    
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_usuario")
    @NotNull(message = "O usuario não pode ser nulo")
    //@NotBlank(message = "O usuario deve ser informado")
    private Usuario usuario;
    
    @OneToMany(mappedBy = "crianca", cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Vacinacao> vacinacao = new ArrayList<>();

    /**
     * @return the id
     */
    
    
    
    public Crianca() {
    }
    
    public void adicionarVacinacao(Vacinacao obj){
        obj.setCrianca(this);
        this.vacinacao.add(obj);
    }
    
    
    public void removeVacinacao(int index){
        this.vacinacao.remove(index);
    }

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
     * @return the nascimento
     */
    public Calendar getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the nomePais
     */
    public String getNomePais() {
        return nomePais;
    }

    /**
     * @param nomePais the nomePais to set
     */
    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Crianca other = (Crianca) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the vacinacao
     */
    public List<Vacinacao> getVacinacao() {
        return vacinacao;
    }

    /**
     * @param vacinacao the vacinacao to set
     */
    public void setVacinacao(List<Vacinacao> vacinacao) {
        this.vacinacao = vacinacao;
    }
    
    
}
