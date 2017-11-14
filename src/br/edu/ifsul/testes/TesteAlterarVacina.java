/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Vacina;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Anderson
 */
public class TesteAlterarVacina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VACINAModelPU");
        EntityManager em = emf.createEntityManager();
        Vacina v = em.find(Vacina.class, 2);
        v.setNome("Meningo B");
        v.setDescricao("Vacina para prevenção");
        v.setMes(24);
        em.getTransaction().begin();
        em.merge(v);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
