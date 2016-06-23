/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completemp3;

import java.util.Vector;

/**
 *
 * @author YYKF
 */
public class Album implements Playable
{
    private String name;
    private Artist artist;
    private Vector songs = new Vector();

    public Album(String name, Artist artist)
    {
        this.name = name;
        setArtist(artist);
    }

    public Artist getArtist()
    {
        return artist;
    }

    public void setArtist(Artist artist)
    {
        if(this.artist != null)
        {
            this.artist.removeAlbum(this);
        }
        this.artist = artist;
        this.artist.addAlbum(this);
    }
    
    public void addSong(Song song)
    {
        songs.add(song);
    }
    
    public void removeSong(Song song)
    {
        songs.remove(song);
    }

    @Override
    public String toString()
    {
       return "Album: " + name + " by " + artist;
    }
    @Override
    public void play()
    {
        System.out.println("Album: " + name + " by " + artist);
        for (Object song : songs)
        {
            Song s = (Song) song;
            s.play();
        }
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
