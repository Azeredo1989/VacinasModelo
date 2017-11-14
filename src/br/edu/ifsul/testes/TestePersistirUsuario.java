/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Crianca;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Anderson
 */
public class TestePersistirUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Usuario u = new Usuario();
        u.setLogin("lisa");
        u.setSenha("lisa");
        u.setEmail("lizandrapsc@hotmail.com");
        u.setTelefone("999923326");
        u.setAdministrador(Boolean.TRUE);
        u.setAtivo(Boolean.TRUE);
        //u.setCriancas(em.find(Crianca.class, 4));
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }
    
}
