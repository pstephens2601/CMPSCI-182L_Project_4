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
public class LinkedList {
    
    protected Link first;
    protected Link last;
    protected int numElements;
    
    public LinkedList() {
        
    }
    
    public void insertFirst(Link newLink) {
        newLink.setNext(null);
        newLink.setPrevious(null);
        
        if (first != null) {
            newLink.setNext(first);
            newLink.getNext().setPrevious(newLink);
        }
        else {
            last = newLink;
        }
        first = newLink;
        numElements++;
    }
    
    public void insertLast(Link newLink) {
        newLink.setNext(null);
        newLink.setPrevious(null);
        
        if (last != null) {
            newLink.setPrevious(last);
        }
        else {
            first = newLink;
        }
        last = newLink;
        numElements++;
    }
    
    public Link getFirst() {
        return first;
    }
    
    public Link getLast() {
        return last;
    }
    
    public void delete(int num) {
        Link target = getNth(num);
        
        if (numElements > 0) {
            if (numElements > 1) {
                if (target != first && target != last) {
                     Link previous = target.getPrevious();
                     Link next = target.getNext();

                     previous.setNext(target.getNext());
                     next.setPrevious(target.getPrevious());
                     numElements--;
                }
                else if (target == first) {
                    deleteFirst();
                }
                else {
                    deleteLast();
                }
            }
            else {
                first = null;
                last = null;
                numElements--;
            }
        }
    }
    
    public int getNumElements() {
        return numElements;
    }
    
    public void deleteFirst() {
        if (numElements > 0) {
            if (numElements > 1) {
                Link secondLink = first.getNext();
                secondLink.setPrevious(null);
                first = secondLink;
                numElements--;
            }
            else {
                first = null;
                last = null;
                numElements--;
            }
         }
    }
    
    public void deleteLast() {
        if (!isEmpty()) {
            if (first != last) {
                last.getPrevious().setNext(null);
                numElements--;
            }
            else {
                first = null;
                last = null;
                numElements--;
            }       
        }   
    }
    
    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public Link getNth(int num) {
        
        Link foundLink;
        Link currentLink = first;
        
        if (num < numElements) {
            for (int i = 0; i < num - 1; i++) {
                if (currentLink.getNext() != null) {
                    currentLink = currentLink.getNext();
                }
            }
        }
        
        foundLink = currentLink;
        
        return foundLink;
    }
}
