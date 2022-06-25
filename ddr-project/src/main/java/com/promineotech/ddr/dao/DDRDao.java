package com.promineotech.ddr.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.ddr.entity.DDRSong;

public interface DDRDao {
  
//GET method to read all of the songs in the database
  List<DDRSong> fetchSongList();

//GET method to find information about a specific DDR song given the user provided song name
  /**
   * 
   * @param ddr_song_id_pk
   * @param song_name
   * @return
   */
  List<DDRSong> fetchSongData(String song_name);
  
  /**
   * Creates a new ddr song
   * @param ddr_song_id_pk
   * @param genre_name
   * @param mix_name
   * @param song_name
   * @param artist
   * @param bpm
   * @param beginner
   * @param basic
   * @param difficult
   * @param expert
   * @param challenge
   * @param has_shock
   * @return 
   */

  Optional<DDRSong> createDDRSong(Long ddr_song_id_pk, String genre,
      String mix, String song_name, String artist, String bpm,
      int beginner, int basic, int difficult, int expert, Long challenge, boolean has_shock);
  
  
  /**
   * Updates an existing ddr song in the database
   * @param ddr_song_id_pk
   * @param genre
   * @param mix
   * @param song_name
   * @param artist
   * @param bpm
   * @param beginner
   * @param basic
   * @param difficult
   * @param expert
   * @param challenge
   * @param has_shock
   * @return 
   */
  
  Optional<DDRSong> updateDDRSong(Long ddr_song_id_pk, String genre,
      String mix, String song_name, String artist, String bpm,
      int beginner, int basic, int difficult, int expert, Long challenge, boolean has_shock);
  
  /**
   * Deletes an existing ddr song in the database
   * @param ddr_song_id_pk
   * @return
   */
  
  Optional<DDRSong> deleteDDRSong(Long ddr_song_id_pk);
}