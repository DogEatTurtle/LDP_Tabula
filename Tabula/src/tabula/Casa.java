/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabula;

import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class Casa {
    
    public int id;
    ArrayList<Peca> posicao;
    
    public Casa(int id){
        this.id=id;
        posicao = new ArrayList<>();
    }
}
