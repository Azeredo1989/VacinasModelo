/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Crianca;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
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
public class TesteValidarCrianca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VACINAModelPU");
        EntityManager em = emf.createEntityManager();
        Crianca c = new Crianca();
        c.setNome("Carol");
        c.setSexo("Feminino");
        c.setNascimento(Calendar.getInstance());
        c.setNomePais("Nere");
        c.setUsuario(em.find(Usuario.class, 2));
        em.getTransaction().begin();
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Crianca>> erros = validador.validate(c);
        if(erros.size()>0){
            for(ConstraintViolation<Crianca> erro : erros){
                System.out.println("Erro: "+erro.getMessage());
            }
        }else{
            em.persist(c);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
