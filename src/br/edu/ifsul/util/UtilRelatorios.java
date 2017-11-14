/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Idade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kalif
 */
public class UtilRelatorios {
    public static List<Idade> listaIdades(){
        List<Idade> lista = new ArrayList<>();
        Idade i1 = new Idade();
        i1.setDescricao("Criança");
        i1.setMes_inicial(48);
        i1.setMes_final(108);
        lista.add(i1);
        return lista;
    }
}
