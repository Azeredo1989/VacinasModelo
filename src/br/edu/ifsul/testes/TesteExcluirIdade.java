/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Idade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Anderson
 */
public class TesteExcluirIdade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VACINAModelPU");
        EntityManager em = emf.createEntityManager();
        Idade i = em.find(Idade.class, 9);
        em.getTransaction().begin();
        em.remove(i);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
