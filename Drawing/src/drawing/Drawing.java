/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import java.awt.*;
import static java.awt.SystemColor.text;
import java.awt.event.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Drawing extends JFrame
{
    ArrayList<DrawingPart> lines = new ArrayList<DrawingPart>();
    DrawingPart currentLine;
    Color currentColor = Color.BLACK;
    float currentLineThickness = 1.0f;
    DrawingCanvas canvas;
    String suffix = ".drw";
    JButton undo;
    JButton redo;
   

    public Drawing()
    {
        canvas = new DrawingCanvas();
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        JLabel bLabel = new JLabel("Background Color");
        String[] colorStrgs = new String[]
        {
            "BLACK", "GREEN", "RED", "BLUE", "MAGENTA"
        };

        Color[] colors = new Color[]
        {
            Color.BLACK, Color.GREEN, Color.RED, Color.BLUE, Color.MAGENTA
        };
        final JComboBox chooser = new JComboBox(colorStrgs);
        chooser.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String colorStr = (String) chooser.getSelectedItem();
                try
                {
                    Color aColor = (Color) Color.class.getField(colorStr).get(null);
                    //canvas.setBackground(aColor);
                    SetBackgroundColorCommand sbcCommand = new SetBackgroundColorCommand(aColor, Drawing.this);
                    UndoRedoManager.getInstance().execute(sbcCommand);
                    validateStacks();

                } catch (NoSuchFieldException ex)
                {
                    Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex)
                {
                    Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex)
                {
                    Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex)
                {
                    Logger.getLogger(Drawing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        buttonPanel.add(bLabel);
        buttonPanel.add(chooser);
        for (Color color : colors)
        {
            final JLabel label = new JLabel();
            label.setOpaque(true);
            label.setBackground(color);
            label.setPreferredSize(new Dimension(30, 30));
            label.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mousePressed(MouseEvent e)
                {
                    currentColor = label.getBackground();
                }
            });
            buttonPanel.add(label);
        }
        ImageIcon buttonIcon = new ImageIcon("../../images/eraser.jpg");
        final JLabel label = new JLabel(buttonIcon);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);

        //label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        label.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                currentColor = canvas.getBackground();
            }
        });
        buttonPanel.add(label);

        buttonPanel.add(new JLabel("Line Thickness "));

        //Spinner for line thickness
        Double value = new Double(1);
        Double min = new Double(1);
        Double max = new Double(10);
        Double step = new Double(.5);
        //SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, step);

        final JSpinner spinner = new JSpinner(new SpinnerNumberModel(value, min, max, step));
        //set the text field uneditable
        ((DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
        spinner.addChangeListener(new ChangeListener()
        {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
                Number number = model.getNumber();
                currentLineThickness = number.floatValue();
            }
        });
        buttonPanel.add(spinner);
        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                save();
            }
        });
        buttonPanel.add(save);
        JButton load = new JButton("Load");
        load.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                load();
            }
        });
        buttonPanel.add(load);
        undo = new JButton("Undo");
        undo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                undo();
            }
        });
        buttonPanel.add(undo);
        redo = new JButton("Redo");
        redo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                redo();
            }
        });
        buttonPanel.add(redo);
        add(buttonPanel, BorderLayout.PAGE_START);
        validateStacks();
    }

    public static void main(String[] args)
    {

        UIManager.LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : plafs)
        {
            String className = info.getClassName();
            System.out.println(className);
        }

        try
        {
            // Set System L&F
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (UnsupportedLookAndFeelException e)
        {
            // handle exception
        } catch (ClassNotFoundException e)
        {
            // handle exception
        } catch (InstantiationException e)
        {
            // handle exception
        } catch (IllegalAccessException e)
        {
            // handle exception
        }
        new Drawing().setVisible(true);
    }

    public void setDrawingBackground(Color color)
    {
        canvas.setBackground(color);
    }
    
    public Color getDrawingBackground()
    {
        return canvas.getBackground();
    }
    public void add(DrawingPart drawingPart)
    {
        lines.add(drawingPart);
        canvas.repaint();
    }
    
    public void remove(DrawingPart drawingPart)
    {
         lines.remove(drawingPart);
         canvas.repaint();
    }
    public void undo()
    {
        UndoRedoManager.getInstance().undo();
        validateStacks();
    }
    
    public void redo()
    {
        UndoRedoManager.getInstance().redo();
        validateStacks();
    }
    public void validateStacks()
    {
        redo.setEnabled(UndoRedoManager.getInstance().redoEmpty() != true);
        undo.setEnabled(UndoRedoManager.getInstance().undoEmpty() != true); 
    }
    
    public void load()
    {
        try
        {
             File file = new File("C:\\Users\\zev_feldberger\\Documents\\TestFolder\\myfile.drw");
             JFileChooser chooser = new JFileChooser();
             chooser.setFileFilter(new FileNameExtensionFilter("Drawing Files","DRW", ".drw"));
             chooser.setAcceptAllFileFilterUsed(true);
             chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
             chooser.setMultiSelectionEnabled(false);
            int retVal = chooser.showOpenDialog(null);
            if(retVal != JFileChooser.APPROVE_OPTION)
                return;
            File selectedFile = chooser.getSelectedFile();
            if(selectedFile.getAbsolutePath().endsWith(suffix) != true)
                return;
            lines.clear();
            ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
            try
            {
                while (true)
                {
                    DrawingPart x = ((DrawingPart) objIn.readObject());
                    lines.add(x);
                    //System.out.println(x);
                }

            } catch (EOFException ex)
            {
            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();

        } catch (IOException e)
        {
            e.printStackTrace();

        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(DrawingPart.class.getName()).log(Level.SEVERE, null, ex);
        }
        canvas.repaint();
    }

    public void save()
    {
        try
        {
            // Store Serialized User Object in File
            File file = new File("C:\\Users\\zev_feldberger\\Documents\\TestFolder\\myfile.drw");
         
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
            for (DrawingPart line : lines)
            {
                output.writeObject(line);
            }

            output.close();
            System.out.println("File Successfully written");

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public class DrawingCanvas extends JPanel
    {

        public DrawingCanvas()
        {
            //setBackground(Color.RED);
            this.addMouseMotionListener(new MouseMotionAdapter()
            {

                @Override
                public void mouseDragged(MouseEvent e)
                {
                    currentLine.add(new Point(e.getX(), e.getY()));
                    repaint();
                }
            });

            addMouseListener(new MouseAdapter()
            {
                @Override
                public void mousePressed(MouseEvent e)
                {
                    currentLine = new DrawingPart();
                    //lines.add(currentLine);
                    
                    //currentLine = points;
                    currentLine.setColor(currentColor);
                    currentLine.setLineThickness(currentLineThickness);
                    currentLine.add(new Point(e.getX(), e.getY()));
                    CreateDrawingPartCommand cdpCmd = new CreateDrawingPartCommand(currentLine, Drawing.this);
                    UndoRedoManager.getInstance().execute(cdpCmd);
                    validateStacks();
                }
            });
        }

        @Override
        public void paint(Graphics graphics)
        {
            super.paint(graphics);
            for (DrawingPart drawingPart : lines)
            {
                graphics.setColor(drawingPart.getColor());
                Graphics2D g2d = (Graphics2D) graphics;
                g2d.setStroke(new BasicStroke(drawingPart.getLineThickness()));
                ArrayList<Point> points = drawingPart.getPoints();
                if (points.isEmpty())
                {
                    return;
                }

                if (points.size() == 1)
                {
                    graphics.drawLine(points.get(0).x, points.get(0).y, points.get(0).x, points.get(0).y);
                }

                Point lastLocation = points.get(0);
                for (int i = 1; i < points.size(); i++)
                {
                    Point currentPoint = points.get(i);
                    graphics.drawLine(lastLocation.x, lastLocation.y, currentPoint.x, currentPoint.y);
                    lastLocation = currentPoint;
                }
            }
        }
    }
}
