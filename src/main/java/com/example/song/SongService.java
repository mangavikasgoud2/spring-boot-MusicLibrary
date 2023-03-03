/*

 * You can use the following import statements
  
 * import org.springframework.http.HttpStatus;
 * import org.springframework.web.server.ResponseStatusException;

 */

package com.example.song;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.song.Song;
import com.example.song.SongRepository;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    
    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    // Don't modify the above code
    // Write your code here
    public int UniqueId = 6;

    public ArrayList<Song> getAllSongs(){
        Collection<Song> allSongs = playlist.values();
        ArrayList<Song> AllSongs = new ArrayList<>(allSongs);
        return AllSongs;
    }

    public Song getSong(int songId){
        Song song = playlist.get(songId);
        if(song == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return song;
    }

    public Song postSong(Song song){
        song.setSongId(UniqueId);
        playlist.put(UniqueId,song);
        UniqueId+=1;
        return song;

    }
    public Song putSong(int songId, Song song){
        Song songGet = playlist.get(songId);
        if(songGet == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
        if(song.getSongName() != null){
            songGet.setSongName(song.getSongName());
        }
        if(song.getLyricist() != null){
            songGet.setLyricist(song.getLyricist());
        }
        if(song.getSinger() != null){
            songGet.setSinger(song.getSinger());
        }
        if(song.getMusicDirector() != null){
            songGet.setMusicDirector(song.getMusicDirector());
        }
        return songGet;

    }

    public void deleteSong(int songId){
        Song song = playlist.get(songId);
        if(song == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }


    

}