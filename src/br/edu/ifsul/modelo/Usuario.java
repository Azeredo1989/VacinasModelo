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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

    /**
     * @return the criancas
     */
    public List<Crianca> getCriancas() {
        return criancas;
    }

    /**
     * @param criancas the criancas to set
     */
    public void setCriancas(List<Crianca> criancas) {
        this.criancas = criancas;
    }
    @Id
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 20, message = "Login não pode ter mais de {max} caracteres")
    @NotNull(message = "Login não pode ser nulo")
    @NotBlank(message = "Login deve ser informado")
    @Column(name = "login", nullable = false, length = 20, unique = true )
    private String login;
    
    @Length(max = 20, message = "A senha não pode ter mais de {max} caracteres")
    @NotNull(message = "A senha não pode ser nula")
    @NotBlank(message = "A senha deve ser informada")
    @Column(name = "senha", nullable = false, length = 20)
    private String senha;
    
    @NotNull(message = "O campo e-mail não pode ser nulo")
    @NotBlank(message = "O campo e-mail deve ser preenchido")
    @Email
    @Column(name = "email", nullable = false, length = 80)
    private String email;
    
    @NotNull(message = "O campo adiministrador deve ser informado")
    @Column(name = "administrador", nullable = false)
    private Boolean administrador;
    
    @NotNull(message = "O campo ativo deve ser informado")
    @Column(name = "ativo",nullable = false)
    private Boolean ativo;
    
    @NotNull(message = "O campo telefone não pode ser nulo")
    @NotBlank(message = "O campo telefone deve ser preenchido")
    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Crianca> criancas = new ArrayList<>();
    
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL,
	      orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AcessoUsuario> acessos = new ArrayList<>();
    
    public void adicionarAcesso(AcessoUsuario acesso){
        acesso.setUsuario(this);
        this.acessos.add(acesso);
    }
    //colocar lista de crianças

    public Usuario() {
        
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the administrador
     */
    public Boolean getAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the acessos
     */
    public List<AcessoUsuario> getAcessos() {
        return acessos;
    }

    /**
     * @param acessos the acessos to set
     */
    public void setAcessos(List<AcessoUsuario> acessos) {
        this.acessos = acessos;
    }
    
}
