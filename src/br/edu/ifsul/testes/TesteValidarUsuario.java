/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Usuario;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Anderson
 */
public class TesteValidarUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VACINAModelPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = new Usuario();
        u.setLogin("abc");
        u.setSenha("1234567");
        u.setEmail("motorola@yahoo.com.br");
        u.setTelefone("342");
        em.getTransaction().begin();
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Usuario>> erros = validador.validate(u);
        if(erros.size()>0){
            for(ConstraintViolation<Usuario> erro : erros){
                System.out.println("Erro: "+erro.getMessage());
            }
        }else{
            em.persist(u);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
