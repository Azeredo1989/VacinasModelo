/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;


import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Crianca;
import br.edu.ifsul.modelo.Vacina;
import br.edu.ifsul.modelo.Vacinacao;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Anderson
 */
public class TestePersistirVacinacao {
    
    EntityManager em;
    
    public TestePersistirVacinacao() {
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
            Crianca c = em.find(Crianca.class, 5);
            Vacinacao v = new Vacinacao();
            v.setNome("Gripe");
            v.setProfissional("Teste");
            v.setUnidade("Cais Hipica");
            v.setData_previsao(Calendar.getInstance());
            v.setData_realizacao(Calendar.getInstance());
            v.setCrianca(em.find(Crianca.class, 1));
            v.setVacina(em.find(Vacina.class, 1));
            c.adicionarVacinacao(v);
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            
       } catch (Exception e) {
           exception =  true;
           e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
