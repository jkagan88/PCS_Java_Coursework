/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completemp3;

/**
 *
 * @author YYKF
 */
public class Song implements Playable
{
    String name;
    String lyrics;
    Album album;

    public Album getAlbum()
    {
        return album;
    }

    public void setAlbum(Album album)
    {
        if(this.album != null)
            this.album.removeSong(this);

        this.album = album;
        album.addSong(this);
    }

    public Song(String name, String lyrics, Album album)
    {
        this.name = name;
        this.lyrics = lyrics;
        setAlbum(album);
    }

     @Override
    public String toString()
    {
       return name + " - " + lyrics;
    }
    //@Override
    public void play()
    {
        System.out.println(this);
    }
}
