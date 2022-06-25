package com.promineotech.ddr.service;

import com.promineotech.ddr.dao.DefaultDDRDao;
import com.promineotech.ddr.entity.DDRSong;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j

public class DefaultDDRService implements DDRService {
  
  @Autowired
  private DefaultDDRDao ddrDao;
  
  @Override
  public List<DDRSong> fetchSongList() {
    log.info("The fetchSongs method was called");
    return ddrDao.fetchSongList();
  }
  
  @Override
  public List<DDRSong> fetchSongData(String song_name) {
    log.info("The fetchSongs method was called with " 
        + " song_name = {}, song_name",
         song_name);
    return ddrDao.fetchSongData(song_name);
  }
  
  @Override
  public Optional<DDRSong> createDDRSong(Long ddr_song_id_pk, String genre,
      String mix, String song_name, String artist, String bpm,
      int beginner, int basic, int difficult, int expert, Long challenge, boolean has_shock){
      //to input log info
    
    return ddrDao.createDDRSong(ddr_song_id_pk, genre, mix, song_name, artist, bpm,
        beginner, basic, difficult, expert, challenge, has_shock);
  }
  
  @Override
  public Optional<DDRSong> updateDDRSong(Long ddr_song_id_pk, String genre,
      String mix, String song_name, String artist, String bpm,
      int beginner, int basic, int difficult, int expert, Long challenge, boolean has_shock){
      //to input log info
    
    return ddrDao.updateDDRSong(ddr_song_id_pk, genre, mix, song_name, artist, bpm,
        beginner, basic, difficult, expert, challenge, has_shock);
  }
  
  @Override
  public Optional<DDRSong> deleteDDRSong(Long ddr_song_id_pk){
      log.info("The deleteDDRSong method was called with ddr_song_id_pk={}" + ddr_song_id_pk);
    
    return ddrDao.deleteDDRSong(ddr_song_id_pk);
  }

}
