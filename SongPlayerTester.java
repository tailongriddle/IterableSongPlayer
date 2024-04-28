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
 * This class implements unit test methods to check the correctness of Song, LinkedNode, SongPlayer
 * ForwardSongIterator and BackwardSongIterator classes in P07 Iterable Song Player assignment.
 * 
 * @author tai
 */
public class SongPlayerTester {
  /**
   * This method test and make use of the Song constructor, an accessor (getter) method, overridden
   * method toString() and equal() method defined in the Song class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSong() {
    Song test = new Song("song", "artist", "duration");
    Song compare = new Song("song", "cat", "duration");
    if (!(test.getArtist().equals("artist"))) {
      System.out.println(test.getArtist());
      return false;
    } else if (!(test.getSongName().equals("song"))) {
      System.out.println(test.getSongName());
      return false;
    } else if (!(test.getDuration().equals("duration"))) {
      System.out.println(test.getDuration());
      return false;
    }

    if (!test.toString().equals("song---artist---duration")) {
      System.out.println(test.toString());
      return false;
    } else if (test.equals(compare)) {
      return false;
    }

    return true;
  }

  /**
   * This method test and make use of the LinkedNode constructor, an accessor (getter) method, and a
   * mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedNode() {
    LinkedNode<Song> next = null;
    LinkedNode<Song> head = null;
    LinkedNode<Song> change = null;


    Song A = new Song("Bodys", "Car Seat Headrest", "6:46");
    Song B = new Song("Geyser", "Mitski", "2:22");
    Song C = new Song("No Shade in the Shadow of the Cross", "Sufjan Stevens", "2:59");


    next = new LinkedNode<Song>(head, B, new LinkedNode<Song>(next, C, null));
    head = new LinkedNode<Song>(null, A, next);

    if (head.getPrev() != null) {
      return false;
    } else if (head.getData() != A) {
      return false;
    } else if (head.getNext() != next) {
      return false;
    }
    head.setNext(change);
    head.setPrev(change);
    if (head.getNext() != null) {
      return false;
    } else if (head.getPrev() != null) {
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of addFirst(), addLast() and add(int index) method in
   * SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerAdd() {
    SongPlayer test = new SongPlayer();
    Song add = new Song("Car Seat Headrest", "Bodys", "2:22");
    test.addFirst(add);
    if (test.getFirst() != add) {
      return false;
    }
    return true;

  }



  /**
   * This method checks for the correctness of removeFirst(), removeLast() and remove(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerRemove() {
    SongPlayer test = new SongPlayer();
    Song add = new Song("Car Seat Headrest", "Bodys", "2:22");
    Song add2 = new Song("Don't Wanna Fall In Love", "KYLE", "3:52");
    test.addFirst(add);
    test.add(1, add2);
    test.remove(0);
    if (test.getFirst() == add) {
      System.out.println(test.getFirst());
      return false;
    } else if (test.size() != 1) {
      System.out.print(test.size());
      return false;
    }
    test.addFirst(add);
    test.remove(1);
    

    return true;
  }

  /**
   * This method checks for the correctness of ForwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testForwardSongIterator() {
    try {
      // define tester scenarios
      // 1. Iterate through an empty list giving its head
      Iterator<Song> iterator = new ForwardSongIterator(null);
      if (iterator.hasNext()) {
        System.out.println("Your hasNext() is broken!");
        return false;
      }

      try {
        iterator.next();
        System.out.println("Your next() is broken!");
        return false;
      } catch (NoSuchElementException e1) {
        // expected behavior
      }

      LinkedNode<Song> head = null;
      LinkedNode<Song> next = null;


      Song A = new Song("Bodys", "Car Seat Headrest", "6:46");
      Song B = new Song("Geyser", "Mitski", "2:22");
      Song C = new Song("No Shade in the Shadow of the Cross", "Sufjan Stevens", "2:59");

      // 2. Iterate through a non-empty list giving its head
      next = new LinkedNode<Song>(head, B, new LinkedNode<Song>(next, C, null));
      head = new LinkedNode<Song>(null, A, next);


      iterator = new ForwardSongIterator(head);

      if (!iterator.hasNext()) {
        System.out.println("1. Your next() is broken!");
        return false;
      }
      if (iterator.next() != (A)) {
        System.out.println("2. Your next() is broken!");
        return false;
      }
      if (!iterator.hasNext()) {
        System.out.println("3. Your next() is broken!");
        return false;
      }
      if (iterator.next() != (B)) {
        System.out.println("4. Your next() is broken!");
        return false;
      }
      if (!iterator.hasNext()) {
        System.out.println("5.Your next() is broken!");
        return false;
      }
      if (iterator.next() != (C)) {
        System.out.println("6. Your next() is broken!");
        return false;
      }



    } catch (Exception e) {
      // catch unexpected exceptions
      e.printStackTrace();
      return false;
    }
    return true; // no bug detected
  }



  /**
   * This method checks for the correctness of BackwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBackwardSongIterator() {
    try {
      // define tester scenarios
      // 1. Iterate through an empty list giving its head
      Iterator<Song> iterator = new ForwardSongIterator(null);
      if (iterator.hasNext()) {
        System.out.println("Your hasNext() is broken!");
        return false;
      }

      try {
        iterator.next();
        System.out.println("Your next() is broken!");
        return false;
      } catch (NoSuchElementException e1) {
        // expected behavior
      }

      LinkedNode<Song> head = null;
      LinkedNode<Song> next = null;


      Song A = new Song("Bodys", "Car Seat Headrest", "6:46");
      Song B = new Song("Geyser", "Mitski", "2:22");
      Song C = new Song("No Shade in the Shadow of the Cross", "Sufjan Stevens", "2:59");

      // 2. Iterate through a non-empty list giving its head
      next = new LinkedNode<Song>(head, B, new LinkedNode<Song>(next, C, null));
      head = new LinkedNode<Song>(null, A, next);


      iterator = new ForwardSongIterator(head);

      if (!iterator.hasNext()) {
        System.out.println("1. Your next() is broken!");
        return false;
      }
      if (iterator.next() != (A)) {
        System.out.println("2. Your next() is broken!");
        return false;
      }
      if (!iterator.hasNext()) {
        System.out.println("3. Your next() is broken!");
        return false;
      }
      if (iterator.next() != (B)) {
        System.out.println("4. Your next() is broken!");
        return false;
      }
      if (!iterator.hasNext()) {
        System.out.println("5.Your next() is broken!");
        return false;
      }
      if (iterator.next() != (C)) {
        System.out.println("6. Your next() is broken!");
        return false;
      }



    } catch (Exception e) {
      // catch unexpected exceptions
      e.printStackTrace();
      return false;
    }
    return true; // no bug detected

  }

  /**
   * Driver method defined in this SongPlayerTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    System.out.println(testSong());
    System.out.println(testLinkedNode());
    System.out.println(testForwardSongIterator());
    System.out.println(testBackwardSongIterator());
    System.out.println(testSongPlayerAdd());
    System.out.println(testSongPlayerRemove());
  }
}
