/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */
 package com.example.song;
 import org.springframework.web.bind.annotation.*;
 import java.util.*;

// Write your code here
@RestController
public class SongController{
    SongService songService = new SongService();

    @GetMapping("/songs")
    public ArrayList<Song> getAllSongs(){
        return songService.getAllSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSong(@PathVariable int songId){
        return songService.getSong(songId);
    }

    @PostMapping("/songs")
    public Song postSong(@RequestBody Song song){
        return songService.postSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song putSong(@PathVariable int songId, @RequestBody Song song){
        return songService.putSong(songId,song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable int songId){
        songService.deleteSong(songId);
    }

}