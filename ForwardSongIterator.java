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
 * This class iterates from 0 to size - 1
 * 
 * @author tai
 *
 */
public class ForwardSongIterator implements Iterator<Song> {
  private LinkedNode<Song> next;

  /**
   * Constructor for ForwardSongIterator that will iterate through songs
   * 
   * @param first
   */
  public ForwardSongIterator(LinkedNode<Song> first) {
    next = first;
  }

  /**
   * Checks to see if there is a next element, returns false if not
   * 
   * @return
   */
  @Override
  public boolean hasNext() {
    return next != null;
  }

  /**
   * Gets next object for object
   */
  @Override
  public Song next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more elements in this iteration");
    }
    Song data = next.getData();
    next = next.getNext();
    return data;
  }
}
