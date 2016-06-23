/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework16;

import java.util.Vector;

/**
 *
 * @author YYKF
 */
public class SongArray
{    
    public Songs [] songList = new Songs[9];

    //Add to vector song, artist, album, lyrics
        public SongArray()
        {
        //getSongList().add(new Songs("Boi BeShalom", "Carlebach", "Shabbos", "boi1"));
            Songs song1 = new Songs("Boi BeShalom", "Carlebach", "Shabbos", "boi1");
            songList[0] = song1;
            Songs song2 = new Songs( "Boi BeShalom2", "Carlebach", "Shabbos", "boi2");
            songList[1] = song2;
            Songs song3 = new Songs("Boi BeShalom3", "Carlebach", "Shabbos", "boi3");
            songList[2] = song3;
            Songs song4 = new Songs("Borchi Nafshi", "Carlebach", "cd2", "borchi_nafshi");
            songList[3] = song4;
            Songs song5 = new Songs("Hamavdil", "Carlebach", "cd2", "hamavdil");
            songList[4] = song5;
            Songs song6 = new Songs("Lecha Dodi", "Carlebach", "cd2", "lecha");
            songList[5] = song6;
            Songs song7 = new Songs("Song1", "MBD", "Album1", "la");
            songList[6] = song7;
            Songs song8 = new Songs("Song2", "MBD", "Album1", "lala");
            songList[7] = song8;
            Songs song9 = new Songs("Song3", "MBD", "Album2", "lalala");
            songList[8] = song9;
        }

    /**
     * @param songList the songList to set
     */
    public void setSongList(Songs[] songList) {
        this.setSongList(songList);
    }

    /**
     * @return the songList
     */
    public Songs[] getSongList() {
        return songList;
    }


}
