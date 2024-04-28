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

/**
 * This class iterates from size - 1 to 0
 * 
 * @author tai
 */
import java.util.NoSuchElementException;

public class BackwardSongIterator implements Iterator<Song> {
  private LinkedNode<Song> next; // reference to the next linked node in a list of nodes

  /**
   * Constructor for backwards song iterator
   * 
   * @param last
   */
  public BackwardSongIterator(LinkedNode<Song> last) {
    this.next = last;
  }

  /**
   * Checks to see if an object has a next node
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
    next = next.getPrev();
    return data;
  }

}
