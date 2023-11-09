/*comparativos
https://github.com/jrxxjr/jpa_hibernate_comparativo/blob/master/src/main/java/br/com/tidicas/dao/Dao.java
https://github.com/jrxxjr/jpa_eclipselink_comparativo/tree/master/src
*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.utfpr.config;

import br.edu.utfpr.Controller.MainController;
import br.edu.utfpr.model.Produto;
import br.edu.utfpr.model.ProdutoDAO;
import java.util.HashMap;
//import br.edu.utfpr.model.tipos.BancoDeDados;
import java.util.List;

/**
 *
 * @author kelly
 */
public class Main {

    public static HashMap<String, String> parametros = new HashMap<>();
    
    public static void main(String[] args) {
        
        MainController.inicio(parametros);
        
    }
    
}
