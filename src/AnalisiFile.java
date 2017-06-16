




import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author massi
 */
public class AnalisiFile {
    
    private static String tipoFile;
    private static final String ric = "60\t3";          //stringa identificativa ricaricabili
    public static final String ricPersonali = "05\t3"; //stringa identificativa ricaricabili Personali
    private static final String abb = "04\t3";          //stringa identificativa abbonamnento
    public static String annoMese = null;
    
    
    /*
    ritorna stringa identificativa di ricaricabile, abbonamento, personali
    */
    public static String rilevaTipo(String fileTelecom){
        tipoFile=null;
        try {   
            // apro il file in lettura
            BufferedReader inputStream = new BufferedReader( new FileReader(fileTelecom));
            Scanner in = new Scanner(inputStream);


            // verifico che nelle prime quattro linee ci sia un codice identificativo corretto
            // se non c'è nessun identificativo valido errore "AnalisiFile non riconosciuto!!"
            for (int x=1; x<5; x++) {
                // se il file non ha almeno 4 linee errore "AnalisiFile non valido, poche linee!!"
                if (in.hasNextLine()){
                    // rilevo la data di riferimento del file, è il 6° campo della prima riga
                    for (int y = 1; y<7 & x==1; y++) {
                        annoMese = in.next();
                    }
                    
                    String line = in.nextLine();
                    
                    if (line.contains(ric)){
                        tipoFile = ric;
                        break;
                    }
                    else if (line.contains(abb)){
                        tipoFile = abb;
                        break;
                    }
                    else if (line.contains(ricPersonali)){
                        tipoFile = ricPersonali;
                        break;
                    }
                    else if (x==4){
                        JOptionPane.showMessageDialog(null,"File non riconosciuto!!");
                        tipoFile = "errore";
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"File non valido, poche linee!!");
                    tipoFile = "errore";
                }
                
            }

            inputStream.close(); 
            
        } catch(IOException e){
            JOptionPane.showMessageDialog(null,e);
            //System.out.println(e);
        }
    System.out.println(tipoFile);
    return tipoFile;
    
        
    }

    /*
    cancella il file passato come paramentro stringa
    */
    public static void eliminaFile (String fileDaEliminare){
        File daEliminare = new File(fileDaEliminare); //Referenzia oggetto file da percorso
        if(daEliminare.exists()) { //se esiste...
                if(daEliminare.delete()) //prova a eliminarlo...
                        System.out.println(daEliminare + " eliminato!"); //e conferma...
        }
        else {
            System.out.println("Il file non esiste!");//altrimenti avverte l'utente
        }
    }
  
}
