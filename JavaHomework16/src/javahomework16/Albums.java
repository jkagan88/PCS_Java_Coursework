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
public class Albums implements PlayerBase
{
    SongArray songArray = new SongArray();
    public void play(String s)
    {
        for (int i = 0; i < songArray.getSongList().length; i++ )
        {
            if (songArray.songList[i] == null)
            {
                break;
            }
            if (s == songArray.songList[i].getAlbum())
            {
                System.out.println(songArray.songList[i].getLyrics());
            }
        }
    }
}
