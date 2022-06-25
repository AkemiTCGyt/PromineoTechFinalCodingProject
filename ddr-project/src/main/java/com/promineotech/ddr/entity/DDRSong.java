package com.promineotech.ddr.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DDRSong {
  private long ddr_song_id_pk;
  private String genre; //The genre of the song
  private String mix; //The respective game the song came from
  private String song_name; //The song name
  private String artist;
  private String bpm; //beats per minute of the song
  private int beginner; //difficulties are beginner, basic, difficult, expert, and challenge. There isn't a challenge difficulty for every song.
  private int basic;
  private int difficult;
  private int expert;
  private Long challenge; 
  private boolean has_shock; //true if shock arrows exist within any difficulty of the selected song
  
  public long getDdr_song_id_pk() {
    return ddr_song_id_pk;
  }
  public void setDdr_song_id_pk(int ddr_song_id_pk) {
    this.ddr_song_id_pk = ddr_song_id_pk;
  }
  public String getGenre() {
    return genre;
  }
  public void setGenre(String genre) {
    this.genre = genre;
  }
  public String getMix() {
    return mix;
  }
  public void setMix(String mix) {
    this.mix = mix;
  }
  public String getSong_name() {
    return song_name;
  }
  public void setSong_name(String song_name) {
    this.song_name = song_name;
  }
  public String getArtist() {
    return artist;
  }
  public void setArtist(String artist) {
    this.artist = artist;
  }
  public String getBpm() {
    return bpm;
  }
  public void setBpm(String bpm) {
    this.bpm = bpm;
  }
  public int getBeginner(int beginner) {
    return beginner;
  }
  public void setBeginner(int beginner) {
    this.beginner = beginner;
  }
  public int getBasic(int basic) {
    return basic;
  }
  public void setBasic(int basic) {
    this.basic = basic;
  }
  public int getDifficult(int difficult) {
    return difficult;
  }
  public void setDifficult(int difficult) {
    this.difficult = difficult;
  }
  public int getExpert(int expert) {
    return expert;
  }
  public void setExpert(int expert) {
    this.expert = expert;
  }
  public Long getChallenge(Long challenge) {
    return challenge;
  }
  public void setChallenge(Long challenge) {
    this.challenge = challenge;
  }
  public boolean hasShock(boolean has_shock) {
    return has_shock;
  }
  public void setHas_shock(boolean has_shock) {
    this.has_shock = has_shock;
  }
  
  /**
   * Checks to see if the ddr song is valid.
   * @param validates by checking the song_name, artist, and bpm. They must all exist for each song.
   * @return True if value, otherwise returns false.
   */
  @JsonIgnore
  public boolean isValid() {
    if ((getSong_name() == null) || (getSong_name().isEmpty())) {
      return false;
    }
    if ((getArtist() == null) || (getArtist().isEmpty())) {
      return false;
    }
    if ((getBpm() == null) || (getBpm().isEmpty())) {
      return false;
    }
    return true;
  }
}
