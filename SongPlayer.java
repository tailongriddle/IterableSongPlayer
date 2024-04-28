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
 * This class plays a list of songs
 * 
 * @author tai
 */
import java.util.NoSuchElementException;

public class SongPlayer implements Iterable<Song> {
  private int size; // size variable
  private LinkedNode<Song> head; // head of list
  private LinkedNode<Song> tail; // tail of list
  private boolean playingBackward; // boolean for whether or not the list is playing backwards

  /**
   * Constructor for SongPlayer
   */
  public SongPlayer() {

  }

  /**
   * Adds Song as Last Song
   * 
   * @param oneSong
   */
  public void addLast(Song oneSong) {
    if (oneSong == null) { // if the added song is null...
      throw new NullPointerException("Last song cannot be null!"); // throw exception
    }

    LinkedNode<Song> toAdd = new LinkedNode<>(tail, oneSong, null); // creates toAdd w/given song
    if (head == null) { // if there is no first song...
      head = toAdd; // the first song is the added song
    }
    tail = toAdd; // the last song is the added song
    size++; // increment size by one
  }

  /**
   * Adds Song as First Song
   * 
   * @param oneSong
   */
  public void addFirst(Song oneSong) {
    if (oneSong == null) { // if the added song is null...
      throw new NullPointerException("First song cannot be null!"); // throw exception
    }

    LinkedNode<Song> toAdd = new LinkedNode<>(null, oneSong, head); // creates toAdd w/given song

    if (head == null) { // if there is no first song...
      this.head = toAdd; // the first song is the added song
      this.tail = toAdd; // the last song is the added song
    } else { // else...
      this.head.setPrev(toAdd); // set the song before the first song to the added song
      this.head = toAdd; // set the head to the added song
    }

    size++; // increment size by one
  }

  /**
   * Adds Song at given index
   * 
   * @param index
   * @param oneSong
   */
  public void add(int index, Song oneSong) {
    if (oneSong == null) { // if added song is null...
      throw new NullPointerException("Song added cannot be null!"); // throw exception
    }
    if (index < 0 || index > size) { // if the index is out of bounds...
      throw new IndexOutOfBoundsException("Index is out of bounds!"); // throw exception
    }

    if (index == 0) { // if the index is at the beginning of the list...
      addFirst(oneSong); // add to beginning of list
    } else { // else...
      while (index-- != 0) { // while the index de-incremented by one does not equal 0...
        if (index == 0) { // if the index equals 0...

          LinkedNode<Song> newNode = new LinkedNode<Song>(null, oneSong, head.getNext()); // create
                                                                                          // new
                                                                                          // node to
                                                                                          // add


          newNode.setNext(head.getNext()); // set the node after the node to the node after the head


          head.setNext(newNode); // set the node after the head to the new node
          break; // break
        }
        head = head.getNext(); // set head to node after head
      }

      this.size++; // increment size by one
    }
  }

  /**
   * Gets first Song in list of Songs
   * 
   * @return
   */
  public Song getFirst() {
    if (size == 0) { // if size is zero...
      throw new NoSuchElementException("List is empty!"); // throw exception
    }

    return this.head.getData(); // return data at head
  }

  /**
   * Gets last Song in list of Songs
   * 
   * @return
   */
  public Song getLast() {
    if (size == 0) { // if size is zero...
      throw new NoSuchElementException("List is empty!"); // throw exception
    }

    return this.tail.getData(); // return data at tail
  }

  /**
   * Gets Song in list of Songs at given index
   * 
   * @param index
   * @return
   */
  public Song get(int index) {
    if (index < 0 || index > size - 1) { // if index is out of bounds...
      throw new IndexOutOfBoundsException("Index is out of bounds!"); // throw exception
    }

    return this.get(index); // return index

  }

  /**
   * Removes first Song in list and returns it
   * 
   * @return removed song
   */
  public Song removeFirst() {
    if (size == 0) { // if the list is empty...
      throw new NoSuchElementException("List is empty!"); // throw exception
    }

    Song toReturn = this.head.getData(); // create song to return that is copy of head
    this.head.getNext().setPrev(null); // make prev of new head null
    this.head = this.head.getNext(); // set new head to next after head
    return toReturn; // return removed head

  }

  /**
   * Removes last Song in list and returns it
   * 
   * @return removed song
   */
  public Song removeLast() {
    if (size == 0) { // if the list is empty...
      throw new NoSuchElementException("List is empty!"); // throw exception
    }

    Song toReturn = this.tail.getData(); // create song to return that is copy of tail
    this.tail.getPrev().setNext(null); // make next of new tail null
    this.tail = this.tail.getPrev(); // set new tail to prev before tail
    return toReturn; // return removed tail

  }

  /**
   * Removes Song in list at given index and returns it
   * 
   * @param index
   * @return removed song
   */
  public Song remove(int index) {
    if (index < 0 || index > size - 1) { // check if index is out of bounds
      throw new IndexOutOfBoundsException("Index is out of bounds!");
    }
    if (head.getData() == null) { // check if the list is empty
      throw new NullPointerException("List is empty!");
    }
    LinkedNode<Song> temp = head; // temporary node pointing to the head

    int pos = index; // storing the index in pos

    for (int i = 1; i < pos; i++) { // iterate until the desired position
      temp = temp.getNext(); // move to the next node
    }

    if (temp == head) { // if the node to remove is the head
      LinkedNode<Song> toReturn = head; // store the head node
      head = temp.getNext(); // update the head
      size--; // decrement the size
      return toReturn.getData(); // return the removed song
    } else if (temp == tail) { // if the node to remove is the tail
      LinkedNode<Song> toReturn = tail; // store the tail node
      tail = tail.getPrev(); // update the tail
      size--; // decrement the size
      return toReturn.getData(); // return the removed song
    } else { // if the node to remove is neither head nor tail
      temp.getPrev().setNext(temp.getNext()); // set the previous node's next to the next of the
                                              // current node
      temp.getNext().setPrev(temp.getPrev()); // set the next node's previous to the previous of the
                                              // current node
    }
    LinkedNode<Song> toReturn = temp; // store the node to remove
    size--; // decrement the size
    return toReturn.getData(); // return the removed song
  }

  /**
   * Checks to see if list contains given song
   * 
   * @param o the song to check for in the list
   * @return true if song is in list, false if not
   */
  public boolean contains(Song o) {
    for (int i = 0; i < size - 1; i++) { // iterate through the list
      if (this.get(i).equals(o)) { // check if the current song equals the given song
        return true; // if found, return true
      }
    }
    return false; // if not found, return false
  }

  /**
   * Clears list of all songs, setting all values to null
   */
  public void clear() {
    for (int i = 0; i < size - 1; i++) { // iterate through the list
      remove(i); // remove each element
    }
    size = 0; // set size to 0
  }

  /**
   * Checks to see if list is empty
   * 
   * @return true if list is empty, false if not
   */
  public boolean isEmpty() {
    for (int i = 0; i < size - 1; i++) { // iterate through the list
      if (this.get(i) != null) { // check if current element is not null
        return false; // if not null, list is not empty
      }
    }
    return true; // if all elements are null, list is empty
  }

  /**
   * Returns the size of the current list
   * 
   * @return size of current list
   */
  public int size() {
    return this.size; // return the size of the list
  }

  /**
   * Returns iterator to iterate through the songs in this list with respect to playing direction
   * 
   * @return iterator
   */
  public Iterator<Song> iterator() {
    if (playingBackward) { // check if playing in backward direction
      return new BackwardSongIterator(tail); // return backward iterator
    }
    return new ForwardSongIterator(head); // return forward iterator
  }

  /**
   * Switches playing direction to opposite of current value
   */
  public void switchPlayingDirection() {
    if (this.playingBackward) { // check if currently playing backward
      this.playingBackward = false; // switch to playing forward
    }
    this.playingBackward = true; // switch to playing backward
  }

  /**
   * Plays songs in song player in current playing direction
   * 
   * @return string of all songs
   */
  public String play() {
    String toReturn = null; // initialize toReturn
    Iterator<Song> iterable = this.iterator(); // get the iterator
    Iterator<Song> iterator = ((SongPlayer) iterable).iterator(); // cast the iterator

    while (iterator.hasNext()) { // iterate through the songs
      Song t = iterator.next(); // get the next song
      toReturn += (t).toString() + System.lineSeparator(); // add the song to toReturn
    }
    return toReturn; // return the string of all songs
  }
}
