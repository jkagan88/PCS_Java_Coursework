/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zev_feldberger
 */
public class UsingIO
{
    public UsingIO()
    {
        try
        {
            // get the user's home directory
            String property = "user.home";
            String userPath = System.getProperty(property);
            File file = new File(userPath + File.separatorChar + "Documents/Tester/Another/Another/newFile.txt");
            if (!file.exists())
            {
                File folder = new File("C:" + File.separatorChar + "Users/zev_feldberger/Documents/Tester/Another/Another");
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
            //rename
//            else
//            {
//                File newName = new File(userPath + File.separatorChar + "Documents/Tester/Another/Another/renamedFile.txt");
//                file.renameTo(newName);
//            }
            writeDataOutputStream(file);
            writePrintWriter(file);
            writeBufferedWriter(file);
            writeFileWriter(file);
            writeFileOutputStream(file);
        } catch (IOException ex)
        {
            System.out.println("EXCEPTION: " + ex.getMessage());
            //Logger.getLogger(UsingIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeFileOutputStream(File file)
    {
        FileOutputStream fos = null;
        try
        {
            String mycontent = "This is my Data #2 which needs"
                    + " to be written into the file using FileOutputStream";

            fos = new FileOutputStream(file);

            byte[] bytesArray = mycontent.getBytes();
            fos.write(bytesArray);
            fos.flush();
            System.out.println("File Written Successfully");
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                fos.close();
            } catch (IOException ex)
            {
                Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void writeFileWriter(File file)
    {
        FileWriter fw = null;
        try
        {
            String mycontent = "This is my Data which needs"
                    + " to be written into the file by file writer";
            //Specify the file path here
            fw = new FileWriter(file, true);

            fw.write(mycontent);
            fw.flush();
            System.out.println("File Written Successfully");

            //The try-with-resources statement
            //see for more details https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
            try (FileReader fileReader = new FileReader(file))
            {
                int data = fileReader.read();
                //when this reaches end of file it will return a -1
                while (data != -1)
                {
                    System.out.print((char) data);
                    data = fileReader.read();
                }

            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                fw.close();
            } catch (IOException ex)
            {
                Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void writeBufferedWriter(File file)
    {
        BufferedWriter bw = null;
        try
        {
            String mycontent = "This is my Data #2 which needs"
                    + " to be written into the file by buffered writer";

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            bw.write(mycontent);
            bw.flush();
            System.out.println("File Written Successfully");
            Reader reader = new FileReader(file);

            //The try-with-resources statement
            //see for more details https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
            try (BufferedReader bufferedReader = new BufferedReader(reader))
            {
                //when this reaches end of file it will return a null
                String line = bufferedReader.readLine();
                while (line != null)
                {
                    System.out.println(line);

                    line = bufferedReader.readLine();
                }
            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                bw.close();
            } catch (IOException ex)
            {
                Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void writePrintWriter(File file)
    {
        PrintWriter pw = null;
        Scanner scan = null;
        try
        {
            String mycontent = "This is my Data #2 which needs"
                    + " to be written into the file by Print writer";
            int myint = 7890;
            boolean myBool = false;
            double myDouble = 67.98;

            FileWriter fw = new FileWriter(file);
            pw = new PrintWriter(fw);

            pw.println(mycontent);
            pw.println(myint);
            pw.println(myBool);
            pw.println(myDouble);
            pw.flush();
            System.out.println("File Written Successfully");

            scan = new Scanner(new FileInputStream(file));

            String nextLine = scan.nextLine();
            int nextInt = scan.nextInt();
            boolean nextBoolean = scan.nextBoolean();
            double nextDouble = scan.nextDouble();

            System.out.print(nextLine + ", " + nextInt + ", " + nextBoolean + ", " + nextDouble);
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            pw.close();
            scan.close();
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
            Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                dataOut.close();
                dataIn.close();
            } catch (IOException ex)
            {
                Logger.getLogger(WritingAndReading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args)
    {
        new UsingIO();
    }
}