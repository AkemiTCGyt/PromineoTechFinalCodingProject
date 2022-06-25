package com.promineotech.ddr.service;

import java.util.List;
import com.promineotech.ddr.entity.DDRSong;
import java.util.Optional;

public interface DDRService {
  
  /**
   * Returns all of the songs in the database
   * @return
   */
  List<DDRSong> fetchSongList();
  
  /**
   * Returns song information for required song_name
   * @param ddr_song_id_pk
   * @param song_name
   * @return The song information
   */
  List<DDRSong> fetchSongData(String song_name);
  
  /**
   * Creates a ddr song with the user inputted information
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

  Optional<DDRSong> createDDRSong(Long ddr_song_id_pk, String genre,
      String mix, String song_name, String artist, String bpm,
      int beginner, int basic, int difficult, int expert, Long challenge, boolean has_shock);
  
  /**
   * Updates a ddr song with the id specified with the user inputted information
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
   * Deletes a ddr song with the corresponding ddr_song_id_pk
   * @param ddr_song_id_pk
   * @return
   */
  Optional<DDRSong> deleteDDRSong(Long ddr_song_id_pk);
}
