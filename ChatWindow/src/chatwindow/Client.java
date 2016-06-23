/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatwindow;

/**
 *
 * @author YYKF
 */

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Chatter
{
    Socket socket;
    String name;
    ChatWindow window;
    String serverAddress;
    PrintWriter writer;
    BufferedReader reader;

    public Client(final ChatWindow window, String name, String serverAddress, int port)
    {
        this.name = name;
        this.window = window;
        this.serverAddress = serverAddress;
        try
        {
            socket = new Socket(serverAddress, port);
            try
            {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
                new Thread(new Runnable(){

                    @Override
                    public void run()
                    {
                        String clientInput; 
                        try
                        {
                            while((clientInput = reader.readLine()) != null)
                            {
                                window.receiveChat(clientInput);
                            }
                        } catch (IOException ex)
                        {
                            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }).start();  
            } catch (IOException ex){
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }  
        } catch (IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void sendChatter(String message)
    {
        String formattedMessage = name + ": " + message;
        writer.println(formattedMessage);
        writer.flush();
    } 
}
