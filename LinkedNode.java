//////////////// FILE HEADER //////////////////////////
//
// Title: P07 Iterable Song Player
// Course: CS 300 Spring 2022
//
// Author: Tai-Long Riddle
// Email: mlriddle@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: piazza
// Online Sources: Piazza :)
//
/////////////////////////////////////////////////////////////////////////////////
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * This class creates Linked Nodes
 * 
 * @author tai
 */
public class LinkedNode<T> {
  private T data;
  private LinkedNode<T> prev;
  private LinkedNode<T> next;

  /**
   * Constructor for LinkedNode
   * 
   * @param prev
   * @param data
   * @param next
   */
  public LinkedNode(LinkedNode<T> prev, T data, LinkedNode<T> next) {
    if (data == null) {
      throw new IllegalArgumentException("Data cannot be null!");
    }

    this.prev = prev;
    this.data = data;
    this.next = next;


  }

  /**
   * Accessor method for prev variable
   * 
   * @return prev
   */
  public LinkedNode<T> getPrev() {
    return prev;
  }

  /**
   * Sets prev to input value
   * 
   * @param prev
   */
  public void setPrev(LinkedNode<T> prev) {
    this.prev = prev;
  }

  /**
   * Accessor method for next variable
   * 
   * @return next
   */
  public LinkedNode<T> getNext() {
    return next;
  }

  /**
   * Sets next to input value
   * 
   * @param next
   */
  public void setNext(LinkedNode<T> next) {
    this.next = next;
  }

  /**
   * Accessor method for data
   * 
   * @return data
   */
  public T getData() {
    return data;
  }



}
