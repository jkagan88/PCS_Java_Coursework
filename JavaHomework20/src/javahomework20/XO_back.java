/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework20;

import javax.swing.JLabel;

/**
 *
 * @author YYKF
 */
public class XO_back
{    
    private int xorO;
  
    public void AI(JLabel[][] jlabel)
    { 
        if (xorO %2 != 0 )
        {
            if (jlabel[1][1].getText() == "")
            {
                addXorO(jlabel[1][1]);
            }
            else if(jlabel[0][0].getText() == "" || jlabel[0][2].getText() == "" || 
                    jlabel[2][0].getText() == "" || jlabel[2][2].getText() == "")
            {
                for (int i = 0; i<4; i++)
                {
                    if(jlabel[0][0].getText() == "")
                    {
                        addXorO(jlabel[0][0]);
                        break;
                    }
                    else if (jlabel[2][0].getText() == "")
                    {
                        addXorO(jlabel[2][0]);
                        break;
                    }
                    else if(jlabel[0][2].getText() == "")
                    {
                        addXorO(jlabel[0][2]);
                        break;
                    }
                    else if(jlabel[2][2].getText() == "")
                    {
                        addXorO(jlabel[2][2]);
                        break;
                    }
                }
            }
            else if(jlabel[0][1].getText() == "" || jlabel[1][0].getText() == "" || 
                    jlabel[1][2].getText() == "" || jlabel[2][1].getText() == "")
            {
                for (int i = 0; i<4; i++)
                {
                    if(jlabel[0][1].getText() == "")
                    {
                        addXorO(jlabel[0][1]);
                        break;
                    }
                    else if (jlabel[1][0].getText() == "")
                    {
                        addXorO(jlabel[1][0]);
                        break;
                    }
                    else if(jlabel[1][2].getText() == "")
                    {
                        addXorO(jlabel[1][2]);
                        break;
                    }
                    else if(jlabel[2][1].getText() == "")
                    {
                        addXorO(jlabel[2][1]);
                        break;
                    }
                }
            }
        }
    }
    public void checkIfOver(JLabel[][] jl)
    {
                  
                   for (int i = 0; i<3; i++)
                   {
                        if (jl[i][0].getText() == "X" && jl[i][1].getText() == "X" && jl[i][2].getText() == "X"
                            ||  jl[0][i].getText() == "X" && jl[1][i].getText() == "X" && jl[2][i].getText() == "X"
                                
                            ||  jl[0][0].getText() == "X" && jl[1][1].getText() == "X" && jl[2][2].getText() == "X"
                            ||  jl[0][2].getText() == "X" && jl[1][1].getText() == "X" && jl[2][0].getText() == "X")
                        {
                            System.out.println("X is the winner!");
                            
                            for (int k = 0; k<3; k++)
                            {
                                for (int j = 0; j<3; j++)
                                {
                                    if (jl[k][j].getText() == "")
                                         jl[k][j].setText(" ");
                                }
                            }
                            break;
                        }
                        
                        else if(jl[i][0].getText() == "O" && jl[i][1].getText() == "O" && jl[i][2].getText() == "O"
                                ||  jl[0][i].getText() == "O" && jl[1][i].getText() == "O" && jl[2][i].getText() == "O"
                                
                                ||  jl[0][0].getText() == "O" && jl[1][1].getText() == "O" && jl[2][2].getText() == "O"
                                ||  jl[0][2].getText() == "O" && jl[1][1].getText() == "O" && jl[2][0].getText() == "O")
                        {
                            System.out.println("O is the winner!");
                            
                            for (int k = 0; k<3; k++)
                            {
                                for (int j = 0; j<3; j++)
                                {
                                    if (jl[k][j].getText() == "")
                                         jl[k][j].setText(" ");
                                }
                            }
                            break;
                        }
        }
    }
    
    
    public void addXorO(JLabel  jlabel)
    {
        if (xorO%2 == 0 && jlabel.getText() == "")
        {
            jlabel.setText("X");
            ++xorO;
        }
        
        else if (xorO%2 != 0 && jlabel.getText() == "")
        {
            jlabel.setText("O");
            ++xorO;
        } 
        
        System.out.println(xorO);
        
    }

    /**
     * @param xorO the xorO to set
     */
    public void setXorO(int xorO) {
        this.xorO = xorO;
    }
}
