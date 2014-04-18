/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author Owner
 */
public class Link {
    
    private Link next;
    private Link previous;
    
    public Link() {
        
    }
    
    public Link(Link newPrevious) {
        previous = newPrevious;
        next = null;
    }
    
    public void setNext(Link newNext) {
        next = newNext;
    }
    
    public Link getNext() {
        return next;
    }
    
    public void setPrevious(Link newPrevious) {
        previous = newPrevious;
    }
    
    public Link getPrevious() {
        return previous;
    } 
}
