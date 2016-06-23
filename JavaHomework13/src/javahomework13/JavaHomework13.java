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
public class JavaHomework13
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        MusicArray musicArray = new MusicArray();
        
        System.out.print(musicArray.songArray[0].getLyrics());
        Song song1 = musicArray.songArray[0];
        song1.display();
    }
    
}
