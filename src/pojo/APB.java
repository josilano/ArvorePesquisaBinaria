/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import TAD.TADArvoreBinaria;
import java.util.Iterator;

/**
 *
 * @author LaNo
 */
public class APB implements TADArvoreBinaria<No>{

    private No root;
    
    public APB(No v){
        this.root = v;
    }
    
    @Override
    public No leftchild(No v) {
        return v.getLeftChild();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int height() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return (this.root == null);
    }

    @Override
    public Iterator elements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator no() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public No parent(No v) {
        return v.getParent();
    }

    @Override
    public boolean isInternal(No v) {
        return (leftchild(v) != null | rightchild(v) != null);
    }

    @Override
    public boolean isExternal(No v) {
        return (leftchild(v) == null & rightchild(v) == null);
    }

    @Override
    public boolean isRoot(No v) {
        return (v.equals(this.root()));
    }

    @Override
    public No rightchild(No v) {
        return v.getRightChild();
    }

    @Override
    public boolean hasLeft(No v) {
        return (v.getLeftChild() == null);
    }

    @Override
    public boolean hasRight(No v) {
        return (v.getRightChild() == null);
    }

    @Override
    public Iterator children(No v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int depth(No v) {        
        if (this.isRoot(v)) return 0;
        else return 1 + this.depth(parent(v));
    }

    @Override
    public Object replace(No v, Object o) {
        v.setElement(o);
        return v;
    }

    @Override
    public No root() {
        return this.root;
    }
    
    public void setRoot(No v){
        this.root = v;
    }
    
    public int key(No v){
        return v.getKey();
    }
    
    public No inOrder(No v){
        if (isInternal(v)) inOrder(leftchild(v));
        System.out.println(v.getElement());
        if (isInternal(v)) inOrder(rightchild(v));
        return null;
    }
    //cormem pg 205
    public void inOrderTreeWalk(No v){
        if (v != null){
            inOrderTreeWalk(leftchild(v));
            System.out.println(key(v));
            inOrderTreeWalk(rightchild(v));
        }
    }
    
    public No treeSearch(int k, No v){
        if (isExternal(v)) return v;
        if (k < v.getKey()) return treeSearch(k, leftchild(v));
        else if (k == v.getKey()) return v;
        else return treeSearch(k, rightchild(v));
    }
    
    //cormem pg 207
    public No treeSearch(No v, int k){
        if (v == null || k == key(v)) return v;
        if (k < key(v)) return treeSearch(leftchild(v), k);
        else return treeSearch(rightchild(v), k);
    }
    
    //cormem pg 208
    public No iterativeTreeSearch(No v, int k){
        while(v != null && k != key(v)){
            if (k < key(v)) v = leftchild(v);
            else v = rightchild(v);
        }
        return v;
    }
    
    //cormem pg 208
    public No treeMinimum(No v){
        while (leftchild(v) != null)
            v = leftchild(v);
        return v;
    }
    
    //cormem pg 208
    public No treeMaximum(No v){
        while (rightchild(v) != null)
            v = rightchild(v);
        return v;
    }
    
    //cormem pg 208
    public No treeSuccessor(No v){
        if (rightchild(v) != null) return treeMinimum(rightchild(v));
        No pai = parent(v);
        while (pai != null && v.equals(rightchild(pai))){
            v = pai;
            pai = parent(pai);
        }
        return pai;
    }
    
    public No treePredecessor(No v){
        if (leftchild(v) != null) return treeMaximum(leftchild(v));
        No pai = parent(v);
        while (pai != null && v.equals(leftchild(pai))){
            v = pai;
            pai = parent(pai);
        }
        return pai;
    }
    
    //cormem pg 210
    public void treeInsert(APB t, No v){
        No pai = null;
        No ponteiroNoFolha = t.root();
        while (ponteiroNoFolha != null){
            pai = ponteiroNoFolha;
            if (key(v) < key(ponteiroNoFolha)) ponteiroNoFolha = leftchild(ponteiroNoFolha);
            else ponteiroNoFolha = rightchild(ponteiroNoFolha);
        }
        v.setParent(pai);
        if (pai == null) t.setRoot(v);
        else if (key(v) < key(pai)) pai.setLeftChild(v);
        else pai.setRightChild(v);
    }
    
    //cormem pg 211
    public No treeDelete(APB t, No v){
        No noPaiExcluido;
        No filho;
        if (leftchild(v) == null | rightchild(v) == null) noPaiExcluido = v;
        else noPaiExcluido = treeSuccessor(v);
        if (leftchild(noPaiExcluido) != null) filho = leftchild(noPaiExcluido);
        else filho = rightchild(noPaiExcluido);
        if (filho != null) filho.setParent(parent(noPaiExcluido));
        if (parent(noPaiExcluido) == null) t.setRoot(filho);
        else if (noPaiExcluido.equals(leftchild(parent(noPaiExcluido)))) parent(noPaiExcluido).setLeftChild(filho);
        else parent(noPaiExcluido).setRightChild(filho);
        if (!noPaiExcluido.equals(v)) {
            v.setKey(key(noPaiExcluido));
            replace(v, noPaiExcluido.getElement());
        }
        return noPaiExcluido;
    }
}
