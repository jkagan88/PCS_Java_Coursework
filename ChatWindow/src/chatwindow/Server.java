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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Chatter
{
    ServerSocket serverSocket;
    ChatWindow window;
    String name;
    ArrayList<ChatClient> clients = new ArrayList();

    public class ChatClient implements Runnable
    {
        Socket s;
        PrintWriter writer;
        BufferedReader reader;
        public ChatClient(Socket s)
        {
            this.s = s;  
        }

        @Override
        public void run()
        {
            try
            {
                reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                writer = new PrintWriter(s.getOutputStream(),true);
                addClient(this);
                String clientInput;
                while((clientInput = reader.readLine()) != null)
                {
                    receiveMessage(clientInput);
                }
            } catch (IOException ex)
            {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public Server(ChatWindow window, String name, int port)
    {
        this.window = window;
        this.name = name;
        try
        {
            serverSocket = new ServerSocket(port);
            new Thread(new Runnable() {
                @Override
                public void run()
                {
                    Socket clientSocket = null;
                    try 
                    {
                        clientSocket = serverSocket.accept();//wait for connections
                    } catch (IOException ex)
                    {}
                    ChatClient chatClient = new ChatClient(clientSocket);
                    new Thread(chatClient).start();
                }
            }).start(); 
        } catch (IOException ex)
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addClient(ChatClient client)
    {
        clients.add(client);
    }
    public synchronized void receiveMessage(String message)
    {
        window.receiveChat(message);
        for (ChatClient client : clients)
        {
            client.writer.println(message);
        }
    }
    public void sendChatter(String message)
    {
        String formattedString = name + ": " +message;
        receiveMessage(formattedString);
    }
}
