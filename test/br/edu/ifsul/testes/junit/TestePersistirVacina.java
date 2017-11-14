/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;


import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.modelo.Vacina;
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
public class TestePersistirVacina {
    
    EntityManager em;
    
    public TestePersistirVacina() {
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
            Vacina v1 = new Vacina();
            v1.setNome("Anti Rabica");
            v1.setMes(72);
            v1.setDescricao("Para evitar a tranmissão do virus da raiva");
            Vacina v2 = new Vacina();
            v2.setNome("");
            v2.setMes(29);
            v2.setDescricao("Para evitar o sarampo");
            em.getTransaction().begin();
            em.persist(v2);
            em.getTransaction().commit();
            
       } catch (Exception e) {
           exception =  true;
           e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
