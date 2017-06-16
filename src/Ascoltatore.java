




import java.awt.event.*;
import java.io.File;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author massi
 */
public class Ascoltatore implements ActionListener {
    
    public static String fileRubrica;
    public static String fileTelecom;
    public static String drOutput;
    public String id;
    
    public void actionPerformed(ActionEvent e){
     //   JButton b = (JButton) e.getSource();
     //   JOptionPane.showMessageDialog(null,"Hai premuto il pulsante: " + b.getText());
        String com = e.getActionCommand();
        
        if (com=="uno"){
            final JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Seleziona il file");
            fc.showOpenDialog(null);
            File file = fc.getSelectedFile();
            //fileRubrica = file.getName();
            fileRubrica = file.getAbsolutePath();
            JOptionPane.showMessageDialog(null,"La rubrica selezionata è : " + fileRubrica);   
        }
        else if (com=="due"){
            final JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Seleziona il file");
            fc.showOpenDialog(null);
            File file = fc.getSelectedFile();
            //fileTelecom = file.getName();
            fileTelecom = file.getAbsolutePath();
            JOptionPane.showMessageDialog(null,"Il file selezionato è : " + fileTelecom);
        }    
        else if (com=="tre"){
            final JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.setDialogTitle("Seleziona la directory");
            fc.showOpenDialog(null);
            File file = fc.getSelectedFile();
            drOutput = file.getAbsolutePath();
            JOptionPane.showMessageDialog(null,"La cartella selezionata è : " + drOutput); 
        }
        else if (com=="quattro"){
            Contatto[] nRubrica = LeggiRubrica.acquisizione();
            id=AnalisiFile.rilevaTipo(fileTelecom);
            Scansionatore.scansiona(nRubrica,id);
            
            /*
            try {PrintWriter outputStream = new PrintWriter(new FileWriter("mancanti.txt"));
                for (int i=0; i<LeggiRubrica.contNomi+1; i++){
                    if (nRubrica[i].getCheck()=="0")
                    outputStream.println(i+" "+
                                        nRubrica[i].getNumero()+" "+
                                        nRubrica[i].getNome()+" "+
                                        nRubrica[i].getCheck()+" "+
                                        nRubrica[i].getConsumoFonia()+" "+
                                        nRubrica[i].getConsumoDati()+" "+
                                        nRubrica[i].getBundle()
                                        );
                }
                outputStream.close();
            } catch(IOException t){
                JOptionPane.showMessageDialog(null,"ascoltatore "+t);
                //System.out.println(e);
            }
            */
            
            
            /*
            try {PrintWriter outputStream = new PrintWriter(new FileWriter("trovati.txt"));
                for (int i=0; i<LeggiRubrica.contNomi+1; i++){
                    if (nRubrica[i].getCheck()=="1")
                    outputStream.println(i+" "+
                                        nRubrica[i].getNumero()+" "+
                                        nRubrica[i].getNome()+" "+
                                        nRubrica[i].getCheck()+" "+
                                        nRubrica[i].getConsumoFonia()+" "+
                                        nRubrica[i].getConsumoDati()+" "+
                                        nRubrica[i].getBundle()
                                        );
                }
                outputStream.close();
            } catch(IOException t){
                JOptionPane.showMessageDialog(null,"ascoltatore "+t);
                //System.out.println(e);
            }
            */

        JOptionPane.showMessageDialog(null,"Elaborazione terminata!!!");

        }
    }
    
}
