/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;


import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Crianca;
import br.edu.ifsul.modelo.Idade;
import br.edu.ifsul.modelo.Usuario;
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
public class TestePersistirUsuario {
    
    EntityManager em;
    
    public TestePersistirUsuario() {
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
            Usuario u = new Usuario();
            u.setLogin("anderson");
            u.setSenha("123");
            u.setTelefone("999428498");
            u.setEmail("anderson.azebeiro@gmail.com");
            u.setAdministrador(Boolean.TRUE);
            u.setAtivo(Boolean.TRUE);
            //u.setCriancas(em.find(Crianca.class, 1));
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            
       } catch (Exception e) {
           exception =  true;
           e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
