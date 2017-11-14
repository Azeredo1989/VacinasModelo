/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;



import br.edu.ifsul.modelo.Vacinacao;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Anderson
 */
public class TestePersistirVacinacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VACINAModelPU");
        EntityManager em = emf.createEntityManager();
        Vacinacao v = new Vacinacao();
        v.setNome("pneumococica conjugada");
        v.setData_previsao(Calendar.getInstance());
        v.setData_realizacao(Calendar.getInstance());
        v.setUnidade("UBS");
        v.setProfissional("Mariana");
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
