/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework13;

/**
 *
 * @author YYKF
 */
public class Song
{
    private String songName;
    private String lyrics;
    private String artist;
    private MusicArray musicArray;
    
    public Song display()
    {
        Song song = new Song();[[][][[][0        for (int j = 0; j <100; j++)
        {
            if(musicArray.songArray[j] == null)
            {
                break;
            }
            if (song.lyrics == musicArray.songArray[j].lyrics)
            {
                System.out.println(musicArray.songArray[j].songName);
                break;
            }
        }
        return song;
    }
    
    public Song()
    {
        
    }
    
    public Song(String artist, String lyrics, String songName)
    {
        this.artist = artist;
        this.lyrics = lyrics;
        this.songName = songName;
    }


    /**
     * @return the songName
     */
    public String getSongName() {
        return songName;
    }

    /**
     * @param songName the songName to set
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * @return the lyrics
     */
    public String getLyrics() {
        return lyrics;
    }

    /**
     * @param lyrics the lyrics to set
     */
    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    /**
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * @return the musicArray
     */
    public MusicArray getMusicArray() {
        return musicArray;
    }

    /**
     * @param musicArray the musicArray to set
     */
    public void setMusicArray(MusicArray musicArray) {
        this.musicArray = musicArray;
    }
}
