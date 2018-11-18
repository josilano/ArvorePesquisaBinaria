/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import TAD.TADNo;


/**
 *
 * @author LaNo
 */
public class No implements TADNo<No>{
    
    //atributos do No
    private No parent;
    private No leftChild;
    private No rightChild;
    private Object element;
    private int key;
    
    public No(No parent, Object o, No leftChild, No rightChild, int key){
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.element = o;
        this.key = key;
    }
    //getters and setters
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public No getParent() {
        return parent;
    }
    @Override
    public void setParent(No parent) {
        this.parent = parent;
    }

    public No getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(No leftChild) {
        this.leftChild = leftChild;
    }

    public No getRightChild() {
        return rightChild;
    }

    public void setRightChild(No rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public Object getElement() {
        return element;
    }

    @Override
    public void setElement(Object element) {
        this.element = element;
    }
    
    //TAD NoAVL
    public No parent(No v){
        return v.getParent();
    }
    
    public No leftChild(No v){
        return v.getLeftChild();
    }
    
    public No rightChild(No v){
        return v.getRightChild();
    }
}
