/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Crianca;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Anderson
 */
public class TesteAlterarCrianca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VACINAModelPU");
        EntityManager em = emf.createEntityManager();
        Crianca c = em.find(Crianca.class, 2);
        c.setNome("Luan");
        c.setNascimento(Calendar.getInstance());
        c.setSexo("Masculino");
        c.setNomePais("Empresario, Grêmio");
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
