/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework16;

/**
 *
 * @author YYKF
 */
public class Songs implements PlayerBase
{
    private String song;
    private String artist;
    private String album;
    private String lyrics;
    SongArray songArray = new SongArray();
    
    
    
    public Songs(String song, String artist, String album, String lyrics)
    {
        this.song = song;
        this.artist = artist;
        this.album = album;
        this.lyrics = lyrics;
    }
    
    public void play(String song)
    {
        for (int i = 0; i < songArray.getSongList().length; i++ )
        {
            if (songArray.songList[i] == null)
            {
                break;
            }
            if (song == songArray.songList[i].getArtist())
            {
                System.out.println(songArray.songList[i].getLyrics());
            }
        }
    }

    /**
     * @return the song
     */
    public String getSong() {
        return song;
    }

    /**
     * @param song the song to set
     */
    public void setSong(String song) {
        this.song = song;
    }

    /**
     * @return the Artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param Artist the Artist to set
     */
    public void setArtist(String Artist) {
        this.artist = Artist;
    }

    /**
     * @return the Album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * @param Album the Album to set
     */
    public void setAlbum(String Album) {
        this.album = Album;
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
}
