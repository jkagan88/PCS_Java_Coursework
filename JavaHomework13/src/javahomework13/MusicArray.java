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
public class MusicArray
{
    Song [] songArray = new Song [100];
    
    public MusicArray()
    {
        for (int i = 0; i<songArray.length; i++)
        {
            songArray[i] = new Song("testArtist","testLyrics","testSong");
        }
        songArray[0] = new Song("joe","Shabbos","Boi Beshalom");
        songArray[1] = new Song("joe","LaLaLa","song1");
        songArray[2] = new Song("Carlebach","","song1");
        songArray[3] = new Song("joe","LaLaLa","song1");
        songArray[4] = new Song("MBD","LaLaLa","Borchi Nafshi");
        songArray[5] = new Song("joe","LaLaLa","Hamavdil");
        songArray[6] = new Song("joe","LaLaLa","song1");
        songArray[7] = new Song("Carlebach","LaLaLa","song1");
        songArray[8] = new Song("joe","LaLaLa","Shabbos");
        songArray[9] = new Song("Carlebach","LaLaLa","song1");
    }
}
