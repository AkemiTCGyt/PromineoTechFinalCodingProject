package com.promineotech.ddr.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.ddr.entity.DDRSong;
import com.promineotech.ddr.service.DDRService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultDDRController implements DDRController {

  @Autowired
  private DDRService ddrService;
  
  //GET (read all of the songs in the database)
  
  @Override
  public List<DDRSong> fetchSongList(){
    log.info("The fetchSongList method was called");
    
    return ddrService.fetchSongList();
  }
  
  
  //GET (read song data)
  
  @Override
  public List<DDRSong> fetchSongData(String song_name){
    log.info("The fetchSongs method was called with song_name={}",
        song_name);
    
    return ddrService.fetchSongData(song_name);
  }
  
  //Post (create new song)
  @Override
  public Optional<DDRSong> createDDRSong(Long ddr_song_id_pk, String genre,
      String mix, String song_name, String artist, String bpm,
      int beginner, int basic, int difficult, int expert, Long challenge, boolean has_shock) {
    //to input log info
    
    return ddrService.createDDRSong(ddr_song_id_pk, genre, mix, song_name, artist,
        bpm, beginner, basic, difficult, expert, challenge, has_shock);
  }
  
  //PUT (update an existing ddr song)
  
  @Override
  public Optional<DDRSong> updateDDRSong(Long ddr_song_id_pk, String genre,
      String mix, String song_name, String artist, String bpm,
      int beginner, int basic, int difficult, int expert, Long challenge, boolean has_shock) {
    //to input log info
    
    return ddrService.createDDRSong(ddr_song_id_pk, genre, mix, song_name, artist,
        bpm, beginner, basic, difficult, expert, challenge, has_shock);
  }
  
  //DELETE (deletes an existing ddr song)
  
  @Override
  public Optional<DDRSong> deleteDDRSong(Long ddr_song_id_pk) {
    log.info("ddr_song_id_pk={}" , ddr_song_id_pk);
    
    return ddrService.deleteDDRSong(ddr_song_id_pk);
  }
}
