/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;


import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Idade;
import br.edu.ifsul.modelo.Vacina;
import br.edu.ifsul.modelo.Vacinacao;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Anderson
 */
public class TestePersistirIdade {
    
    EntityManager em;
    
    public TestePersistirIdade() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
     
    @Test
    public void teste(){
        boolean exception = false;
        try {
            Idade i = new Idade();
            i.setDescricao("Adulto");
            i.setMes_inicial(144);
            i.setMes_final(600);
            //i.setVacinas(em.find(Vacina.class, i));
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
            
       } catch (Exception e) {
           exception =  true;
           e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
