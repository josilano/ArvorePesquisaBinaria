/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorepesquisabinaria;

import pojo.APB;
import pojo.No;

/**
 *
 * @author LaNo
 */
public class ArvorePesquisaBinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        APB apb = new APB(new No(null, "gohan", null, null, 100));
        //System.out.println(avl.root().getKey());
        System.out.println(apb.inOrder(apb.root()));
        System.out.println("saida: ");
        apb.inOrderTreeWalk(apb.root());
        System.out.println("---------");
        apb.treeInsert(apb, new No(null, "goku", null, null, 200));
        apb.inOrderTreeWalk(apb.root());
        System.out.println("---------");
        apb.treeInsert(apb, new No(null, "goten", null, null, 40));
        apb.inOrderTreeWalk(apb.root());
        System.out.println("---------");
        apb.treeInsert(apb, new No(null, "pan", null, null, 3));
        apb.inOrderTreeWalk(apb.root());
        System.out.println("---------");
        apb.treeInsert(apb, new No(null, "piccolo", null, null, 20));
        apb.inOrderTreeWalk(apb.root());
        System.out.println("---------");
        apb.treeInsert(apb, new No(null, "vegeta", null, null, 190));
        apb.inOrderTreeWalk(apb.root());
        System.out.println("---------");
        No noKuririn = new No(null, "kuririn", null, null, 15);
        apb.treeInsert(apb, noKuririn);
        apb.inOrderTreeWalk(apb.root());
        System.out.println("---------");
        No noKami = new No(null, "kami", null, null, 5);
        apb.treeInsert(apb, noKami);
        apb.inOrderTreeWalk(apb.root());
        System.out.println("---------");
        No noYamcha = new No(null, "yamcha", null, null, 1);
        apb.treeInsert(apb, noYamcha);
        apb.inOrderTreeWalk(apb.root());
        System.out.println("---------");
        apb.treeDelete(apb, noYamcha);
        apb.inOrderTreeWalk(apb.root());
        System.out.println("---------");
        apb.treeDelete(apb, noKami);
        apb.inOrderTreeWalk(apb.root());
        System.out.println("---------");
        apb.treeDelete(apb, noKuririn);
        apb.inOrderTreeWalk(apb.root());
        System.out.println("---------");
    }
    
}
