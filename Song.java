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
 * This class creates a Song
 * 
 * @author tai
 */
public class Song {
  private String songName;
  private String artist;
  private String duration;

  /*
   * Constructor for Song
   */
  public Song(String songName, String artist, String duration) {
    if (songName.isBlank()) {
      throw new IllegalArgumentException("Song name cannot be blank!");
    } else if (artist.isBlank()) {
      throw new IllegalArgumentException("Artist name cannot be blank!");
    } else if (duration.isBlank()) {
      throw new IllegalArgumentException("Duration cannot be blank");
    }
    this.songName = songName;
    this.artist = artist;
    this.duration = duration;



  }

  /**
   * 
   * Accessor method for the song name
   * 
   * @return songName
   */
  public String getSongName() {
    return songName;
  }

  /**
   * 
   * Accessor method for the artist name
   * 
   * @return artist
   */
  public String getArtist() {
    return artist;
  }

  /**
   * Accessor method for the duration
   * 
   * @return duration
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Method that creates string to combine variables
   * 
   * @return String with song name, artist, and duration
   */
  @Override
  public String toString() {
    return songName + "---" + artist + "---" + duration;
  }


  /**
   * Compares two string objects and checks if they both have the same song and artist
   * 
   * @return boolean true or false
   */
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Song) || other == null) {
      return false;
    }


    if (!(this.songName + this.artist)
        .equals(((Song) other).getSongName() + ((Song) (other)).getArtist())) {
      return false;


    }
    return true;

  }
}
