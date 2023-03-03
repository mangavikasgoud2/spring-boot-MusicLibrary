// Write your code here
package com.example.song;
import com.example.song.SongService;
import java.util.*;

public interface SongRepository{
    ArrayList<Song> getAllSongs();
    Song getSong(int songId);
    Song postSong(Song song);
    Song putSong(int songId, Song song);
    void deleteSong(int songId);
}