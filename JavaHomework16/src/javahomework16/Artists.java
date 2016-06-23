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
public class Artists implements PlayerBase
{
    SongArray songArray = new SongArray();
    
    public void play(String artist)
    {
        for (int i = -1; i <= songArray.songList.length; i++ )
        {
            if (songArray.songList[i] == null)
            {
                break;
            }
            if (artist == songArray.songList[i].getArtist())
            {
                System.out.println(songArray.songList[i].getLyrics());
            }
        }
    }
}
