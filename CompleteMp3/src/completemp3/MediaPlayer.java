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
public class MediaPlayer
{

    /**
     * @param args the command line arguments
     */
    enum Mode {Normal, Repeat};
    
    public static void main(String[] args) 
    {
        Artist mbd = new Artist("MBD");
        Album album = new Album("efshar letaken", mbd);
        Song song1 = new Song("Usid", "usid hakadosh baruch hu lasos", album);
        Song song2 = new Song("Ono Melech", "ono melech malchai hamalchim", album);

        album = new Album("maminim Bnei Maminim", mbd);
        Song song3 = new Song("Torah Hakdosha", "torah hakdosha yischaneni bevakusha", album);
        Song song4 = new Song("Chasoif", "chasoif zeroi kudshechu vekuriev", album);

        
        Artist af = new Artist("Avraham Fried");
        Album chazak = new Album("chazak", af);
        Song songs5 = new Song("Chazak", "chazak chazak vnizchazek", chazak);
        Song songs6 = new Song("lbinyamin", "lbinyomin amar yedid ", chazak);

        
        
        
        
        MediaPlayer player = new MediaPlayer();
        //play Artist
	player.play(af,Mode.Repeat);
        System.out.println();
        //play Album
        player.play(album,Mode.Normal);
        System.out.println();
        //play all Song
        player.play(song1, Mode.Normal);
    }
    
    
    public void play(Playable playable, Mode mode)
    {
        playable.play();
        if(mode == Mode.Repeat)
            playable.play();
    }
    
}
