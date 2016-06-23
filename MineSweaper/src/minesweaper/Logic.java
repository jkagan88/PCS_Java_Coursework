/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweaper;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author YYKF
 */
public class Logic// implements Runnable
{
    int numOfBombs = 15;
    private static int winCount;
    Long winTime;
    Long startTime;
    private boolean won;
    private boolean firstClick = true;
    private int counter = 0;
    private boolean gameOver;
    String time;
    
    public void gameWon(MineSquare ms, MineSquare [][] mineBoard)
    { setBombs(mineBoard);
        for (int k = 0; k<mineBoard.length; k++)
            {
                for (int j = 0; j<mineBoard[0].length; j++)
                {
                    if (mineBoard[k][j].isPressable() == false && mineBoard[k][j].isBomb())
                    {
                        winCount++;
                    }
                    if (mineBoard[k][j].isPressable() == false && mineBoard[k][j].isBomb() == false)
                    {
                        winCount--;
                    }
                    if (mineBoard[k][j].isPressable() && mineBoard[k][j].isCalled() == false)
                    {
                        winCount--;
                    }
                }
                
            }

        if (winCount == numOfBombs)
        {
            for (int k = 0; k<mineBoard.length; k++)
            {
                for (int j = 0; j<mineBoard[0].length; j++)
                {
                    mineBoard[k][j].setCalled(true);
                }
                
            }
            
            //Setting the highscore
            if (won != true)
            {
                winTime = (System.currentTimeMillis() - startTime) / 1000;
                System.out.println(winTime);
            }
            won = true;
            gameOver = true;
            
            
            
            String property = "user.home";
            String userPath = System.getProperty(property);
            File file = new File(userPath + File.separatorChar + "Documents/Tester/Another/Another/HighScores.txt");
            try
            {   
                if (!file.exists())
                {
                    File folder = new File(userPath + File.separatorChar + "Documents/Tester/Another/Another");
                    //make the folders
                    boolean mkdirSuccess = folder.mkdirs();
                    System.out.println("creating folders " + (mkdirSuccess ? "successfull" : "unsuccessfull"));
                    boolean fileSuccess = file.createNewFile();
                    System.out.println("creating file " + (fileSuccess ? "successfull" : "unsuccessfull"));
                    //check file's modified date
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
                    String format = sdf.format(file.lastModified());
                    System.out.println("Last formated: " + format);
                }

            }
            catch (IOException ex)
            {
                System.out.println("EXCEPTION: " + ex.getMessage());
                //Logger.getLogger(UsingIO.class.getName()).log(Level.SEVERE, null, ex);
            } 
            writeDataOutputStream(file);
            
        }
        winCount = 0; 
        
        
    }
    
    public void timer()
    {
        if (isFirstClick())
        {
            Runnable runnable = new Runnable() {

                @Override
                public void run() 
                {
                    while (!won && !gameOver)
                    {
                        try
                        {
                            
                            Thread.sleep(1000);  
                            ++counter;       
                            SwingUtilities.invokeLater(new Runnable(){

                                @Override
                                public void run() 
                                {
                                    
                                    if (!won)
                                    time = String.format("%02d:%02d", counter/60, counter%60); 
                                    MineSweaperGUI.topLabel.setText(time);
                                }
                            });
                            System.out.println(getCounter());
                        } catch (InterruptedException ex)
                        {
                            
                        } 
                    }
                }
            }; 
            Thread thread = new Thread(runnable);
            thread.start();
        }
        
    }
    
    public void writeDataOutputStream(File file)
    {
        DataOutputStream dataOut = null;
        DataInputStream dataIn = null;
        try
        {
            String mycontent = "This is my Data #2 which needs\n"
                    + " to be written into the file by DataOutputStream";
            int myint = 7890;
            boolean myBool = false;
            double myDouble = 67.98;

            FileOutputStream fw = new FileOutputStream(file);

            dataOut = new DataOutputStream(fw);
            dataOut.writeUTF(mycontent);
            dataOut.writeInt(myint);
            dataOut.writeBoolean(myBool);
            dataOut.writeDouble(myDouble);
            System.out.println("File Written Successfully");
            //Reading data from the same file
            dataIn = new DataInputStream(new FileInputStream(file));

            while (dataIn.available() > 0)
            {

                String readUTF = dataIn.readUTF();
                int readInt = dataIn.readInt();
                boolean readBoolean = dataIn.readBoolean();
                double readDouble = dataIn.readDouble();
                System.out.print(readUTF + ", " + readInt + ", " + readBoolean + ", " + readDouble);
            }
        } catch (FileNotFoundException ex)
        {
            
        } catch (IOException ex)
        {
            
        } finally
        {
            try
            {
                dataOut.close();
                dataIn.close();
            } catch (IOException ex)
            {
                
            }
        }
    }

    
    public void gameLost(MineSquare [][] mineBoard)
    {
        for (int i = 0; i<mineBoard.length; i++)
        {
            for (int j = 0; j<mineBoard[i].length; j++)
            {
                mineBoard[i][j].setPressable(false);
            }
        }
        gameOver = true;
    }
    
    public void bordering(int i, int j , MineSquare [][] mineBoard)
    { 
        for (int yy = -1; yy <2; yy++)
                {
                    for (int jj = -1; jj<2; jj++)
                    {
                        if(i-yy >=0 && j-jj >=0 && i-yy<mineBoard.length && j-jj<mineBoard[0].length &&
                                mineBoard[i-yy][j-jj].isPressable())
                        {
                            mineBoard[i-yy][j-jj].setIcon(null);
                            
                            
                            if (mineBoard[i-yy][j-jj].getTouching() != 0)
                            {
                                mineBoard[i-yy][j-jj].setCalled(true);
                                mineBoard[i-yy][j-jj].setText(Integer.toString(mineBoard[i-yy][j-jj].getTouching()));
                            }
                            if(mineBoard[i-yy][j-jj].isCalled() == false && mineBoard[i-yy][j-jj].getTouching() == 0)
                            {
                                mineBoard[i-yy][j-jj].setCalled(true);
                                bordering(i-yy, j-jj, mineBoard);
                            }
                        }
                    }
                }
    }
    
    
    public void checkIfEmpty(MineSquare ms)
    {
        if (ms.getTouching() == 0)
        {
            ms.setIcon(null);
        }
    }
    
    public void setBombs(MineSquare [][] mineBoard)
    {
        if (isFirstClick())
        {
            startTime = System.currentTimeMillis();
            for (int i = 0; i<numOfBombs;)
            {
                int setX = (int) (Math.random() * mineBoard.length);
                int setY = (int) (Math.random() * mineBoard[1].length);
                if (mineBoard[setX][setY].isBomb() == false && mineBoard[setX][setY].isCalled() == false)
                {
                    mineBoard[setX][setY].setBomb(true);

                    for (int yy = -1; yy <2; yy++)
                    {
                        for (int jj = -1; jj<2; jj++)
                        {
                            if (setX - yy >= 0 && setY - jj >= 0 && setX - yy < mineBoard.length && setY - jj < mineBoard[0].length)
                            {
                                mineBoard[setX - yy][setY - jj].setTouching(mineBoard[setX - yy][setY - jj].getTouching()+1);
                            }
                        }
                    }
                    i++;
                }
            }
        }
        firstClick = false;
    }
        /**
     * @return the winCount
     */
    public static int getWinCount() {
        return winCount;
    }

    /**
     * @param aWinCount the winCount to set
     */
    public static void setWinCount(int aWinCount) {
        winCount = aWinCount;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @return the firstClick
     */
    public boolean isFirstClick() {
        return firstClick;
    }

    /**
     * @return the gameOver
     */
    public boolean isGameOver() {
        return gameOver;
    }

}
