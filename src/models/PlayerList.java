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
public class PlayerList extends LinkedList {
    
    public void add(Player newPlayer) {
        insertFirst(newPlayer);
    } 
}


