/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;


import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Crianca;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import javafx.scene.control.Alert;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Anderson
 */
public class TestePersistirCrianca {
    
    EntityManager em;
    
    public TestePersistirCrianca() {
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
            Crianca c = new Crianca();
            c.setNome("Laura");
            c.setNascimento(Calendar.getInstance());
            c.setSexo("Feminino");
            c.setNomePais("Anderson, Lisandra");
            c.setUsuario(em.find(Usuario.class, 4));
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
