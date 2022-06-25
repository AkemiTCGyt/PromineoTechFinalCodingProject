package com.promineotech.ddr.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.promineotech.ddr.entity.DDRSong;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Service
public class DefaultDDRDao implements DDRDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  // GET method to get a list of all of the songs in the databse
  @Override
  public List<DDRSong> fetchSongList() {
    
    String sql = ""
        + "SELECT *  "
        + "FROM ddr_songs ";
    
    //Maps every column name to the corresponding variables in the ddr_songs table
    
    Map<String, Object> params = new HashMap<>();
    return jdbcTemplate.query(sql,  params,
        new RowMapper<>() {

          @Override
          public DDRSong mapRow(ResultSet rs, int rowNum) throws SQLException {
            
            return DDRSong.builder()
                .ddr_song_id_pk(rs.getLong("ddr_song_id_pk"))
                .genre(rs.getString("genre"))
                .mix(rs.getString("mix"))
                .song_name(rs.getString("song_name"))
                .artist(rs.getString("artist"))
                .bpm(rs.getString("bpm"))
                .beginner(rs.getInt("beginner"))
                .basic(rs.getInt("basic"))
                .difficult(rs.getInt("difficult"))
                .expert(rs.getInt("expert"))
                .challenge(rs.getLong("challenge"))
                .has_shock(rs.getBoolean("has_shock"))
                .build();
          }});
    
  }
  
  // GET method to get information about a song
  
  @Override
  public List<DDRSong> fetchSongData(String song_name) {
    log.debug("DAO: song_name{});", song_name);
    
    String sql = ""
        + "SELECT * "
        + "FROM ddr_songs "
        + "WHERE song_name = :song_name";
    
    //Maps every column name to the corresponding variables in the ddr_songs table
    
    Map<String, Object> params = new HashMap<>();
    params.put("song_name", song_name);
    
    return jdbcTemplate.query(sql,  params,
        new RowMapper<>() {

          @Override
          public DDRSong mapRow(ResultSet rs, int rowNum) throws SQLException {
            
            return DDRSong.builder()
                .ddr_song_id_pk(rs.getLong("ddr_song_id_pk"))
                .genre(rs.getString("genre"))
                .mix(rs.getString("mix"))
                .song_name(rs.getString("song_name"))
                .artist(rs.getString("artist"))
                .bpm(rs.getString("bpm"))
                .beginner(rs.getInt("beginner"))
                .basic(rs.getInt("basic"))
                .difficult(rs.getInt("difficult"))
                .expert(rs.getInt("expert"))
                .challenge(rs.getLong("challenge"))
                .has_shock(rs.getBoolean("has_shock"))
                .build();
          }});
    
  }
  
  // 
  
  // POST method to create a new DDR Song in the ddr_songs table
  
  @Override
  public Optional<DDRSong> createDDRSong(Long ddr_song_id_pk, String genre,
      String mix, String song_name, String artist, String bpm,
      int beginner, int basic, int difficult, int expert, Long challenge, boolean has_shock) {
    //to input log info
    
    String sql = ""
        + "INSERT INTO ddr_songs ("
        + "ddr_song_id_pk, genre, mix, song_name, artist, bpm, beginner, basic, "
        + "difficult, expert, challenge, has_shock"
        + ") VALUES ("
        + " :ddr_song_id_pk, :genre, :mix, :song_name, :artist, :bpm, :beginner,"
        + " :basic, :difficult, :expert, :challenge, :has_shock)";
    
    Map<String, Object> params = new HashMap<>();
    params.put("ddr_song_id_pk", ddr_song_id_pk);
    params.put("genre", genre); 
    params.put("mix", mix);
    params.put("song_name", song_name);
    params.put("artist", artist);
    params.put("bpm", bpm); 
    params.put("beginner", beginner);
    params.put("basic", basic);
    params.put("difficult", difficult); 
    params.put("expert", expert);
    params.put("challenge", challenge);
    params.put("has_shock", has_shock);
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(DDRSong.builder()
        .ddr_song_id_pk(ddr_song_id_pk)
        .genre(genre)
        .mix(mix)
        .song_name(song_name)
        .artist(artist)
        .bpm(bpm)
        .beginner(beginner)
        .basic(basic)
        .difficult(difficult)
        .expert(expert)
        .challenge(challenge)
        .has_shock(has_shock)
        .build());
    }
    
    // PUT method to update an existing DDR Song in the ddr_songs table
        
    @Override
    public Optional<DDRSong> updateDDRSong(Long ddr_song_id_pk, String genre,
        String mix, String song_name, String artist, String bpm,
        int beginner, int basic, int difficult, int expert, Long challenge, boolean has_shock){
      
     //to input log info
     
      String sql = ""
          + "UPDATE ddr_songs SET"
          + "ddr_song_id_pk = :new_ddr_song_id_pk, "
          + "genre = :new_genre, "
          + "mix = :new_mix, "
          + "song_name = :new_song_name, "
          + "artist = :new_artist, "
          + "bpm = :new_bpm, "
          + "beginner = :new_beginner, "
          + "basic = :new_basic, "
          + "difficult = :new_difficult, "
          + "expert = :new_expert, "
          + "challenge = :new_challenge,"
          + "has_shock = :new_has_shock "
          + "WHERE "
          + "ddr_song_id_pk = :ddr_song_id_pk AND "
          + "genre = :genre AND "
          + "mix = :mix AND "
          + "song_name = :song_name AND "
          + "artist = :artist AND "
          + "bpm = :bpm AND "
          + "beginner = :beginner AND "
          + "basic = :basic AND "
          + "difficult = :difficult AND "
          + "expert = : expert AND "
          + "challenge = :challenge AND "
          + "has_shock = :has_shock ";
      
      Map<String, Object> params = new HashMap<>();
      params.put("ddr_song_id_pk", ddr_song_id_pk);
      params.put("genre", genre); 
      params.put("mix", mix);
      params.put("song_name", song_name);
      params.put("artist", artist);
      params.put("bpm", bpm); 
      params.put("beginner", beginner);
      params.put("basic", basic);
      params.put("difficult", difficult); 
      params.put("expert", expert);
      params.put("challenge", challenge);
      params.put("has_shock", has_shock);
      
      jdbcTemplate.update(sql, params);
      return Optional.ofNullable(DDRSong.builder()
          .ddr_song_id_pk(ddr_song_id_pk)
          .genre(genre)
          .mix(mix)
          .song_name(song_name)
          .artist(artist)
          .bpm(bpm)
          .beginner(beginner)
          .basic(basic)
          .difficult(difficult)
          .expert(expert)
          .challenge(challenge)
          .has_shock(has_shock)
          .build());
      }
    
    // DELETE method to remove an existing DDR Song in the ddr_songs table
    
    @Override
    public Optional<DDRSong> deleteDDRSong(Long ddr_song_id_pk) {
      log.debug("DAO: ddr_song_id_pk{}", ddr_song_id_pk);
      
      String sql = ""
          + "DELETE FROM ddr_songs WHERE "
          + "ddr_song_id_pk = :ddr_song_id_pk";
      
      Map<String, Object> params = new HashMap<>();
      params.put("ddr_song_id_pk", ddr_song_id_pk);
      
      jdbcTemplate.update(sql,  params); //returns number of rows affected which should be one
      return Optional.ofNullable(DDRSong.builder().ddr_song_id_pk(ddr_song_id_pk).build());
    }
    
  }
