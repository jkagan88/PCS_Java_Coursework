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
import java.util.ArrayList;
import java.util.Vector;

public class Artist implements Playable
{
    private String name;
    //private Vector albums = new Vector();
    private ArrayList<Album> albums = new ArrayList<Album>();
    
    public Artist(String name)
    {
        this.name = name;
    }

    public Artist()
    {

    }
    public void removeAlbum(Album album)
    {
        albums.remove(album);
    }
    public void addAlbum(Album album)
    {
        albums.add(album);
    }
    
     @Override
    public String toString()
    {
       return name;
    }
    
    public void play()
    {
        for (int i = 0; i < albums.size(); i++)
        {
           albums.get(i).play();
        }
    }
}
