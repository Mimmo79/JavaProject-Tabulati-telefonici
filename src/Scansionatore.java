



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;



/**
 *
 * @author massi
 */

public class Scansionatore {
    
    static boolean noIncr = false;
    static String line = null;
    static boolean Cancel=true;
    
       
    public static void scansiona(Contatto[] nRubrica, String id){
         

        try {   
            // apro il file in lettura
            BufferedReader inputStream = new BufferedReader( new FileReader(Ascoltatore.fileTelecom));
            Scanner in = new Scanner(inputStream);
        
        
            // se c'è una nuova linea eseguo il codice
            while (in.hasNextLine()) {

                if (!noIncr){
                    line = in.nextLine();
                }
                noIncr = false;
                
                /*
                Analizzo linea per linea,
                se una linea contiene il codice che cerco (es. "60\t3")eseguo il blocco
                "id" codice identificativo del tipo di file:
                ricaricabile, ricaricabile personali, abbonamento
                */
                if (line.contains(id)){
                    // "line" è una linea che devo scannerizzare
                    // eseguo un'altra istanza di "scanner"
                    Scanner riga = new Scanner(line);
                    //salto il campo vuoto
                    riga.next();
                    //memorizzo il campo telefono
                    String Tel = riga.next();
                    // comparo il numero di telefono con i numeri della rubrica
                    for (int i=0; i<(LeggiRubrica.contNomi+1); i++) {
                        if ( nRubrica[i].getNumero().equals(Tel) ){
                            /*
                            COMPILAZIONE DEI FILES UTENTI
                            Se il numero è in rubrica, creo un file con il nome corrispondente
                            inserendo nell'intestazione tutti i dati
                            */
                            // creo il file con il nome giusto
                            PrintWriter outputStream = new PrintWriter(new FileWriter(
                            Ascoltatore.drOutput +"\\"+ i + "-"
                                                      + nRubrica[i].getNumero() + "-"
                                                      + LeggiRubrica.normalizzaNome(nRubrica[i].getNome())
                                                      + ".txt"));
                            //scrivo la prima riga con il numero, il nome, il servizio, il mese
                            outputStream.println(   nRubrica[i].getNumero() +"\t\t\t"+
                                                    nRubrica[i].getNome() +"\t\t\t"+
                                                    nRubrica[i].getServizio() +"\t\t\t"+
                                                    AnalisiFile.annoMese);
                            outputStream.println(" ");
                            
                            nRubrica[i].setCheck("1");
                            nRubrica[i].setTipo("ric");
                            

                            /*
                            avanzo...
                            finchè il file non contiente il codice che identifica un nuovo utente "id"
                            trasferisco le linee lette nel file-utente (while)
                            Arrivato al codice "id", che mi segnala l'inizio di un nuovo numero telefonico,
                            chiudo il file e imposto la variabile "noIncr" per evitare che 
                            si passi alla riga successiva (linea 40).
                            */
                            line = in.nextLine();
                            /*
                            La funzione "ExtractData.extraction" analizza la linea ed
                            estrae i dati di consumo
                            */
                            ExtractData.extraction(line, nRubrica[i]);
                            /*
                            PER ELABORAZIONE PERSONALI
                            La funzione "ExtractData.fileCancel" ritorna true  
                            nel caso in cui la riga non contenga personali
                            "puoi cancellare il file perchè non ha personali"
                            */
                            if(id.equals(AnalisiFile.ricPersonali) & Cancel){
                                Cancel=ExtractData.fileCancel(line);
                            }
                                                                                   
                            while (!(line.contains(id))){
                                outputStream.println(line);
                                
                                if (in.hasNextLine()){
                                    line = in.nextLine();
                                    ExtractData.extraction(line, nRubrica[i]);
                                    if(id.equals(AnalisiFile.ricPersonali) & Cancel){
                                        Cancel=ExtractData.fileCancel(line);
                                    }
                                    
                                } else {
                                    break;
                                }
                            } 
                            
                            noIncr = true;
                            outputStream.close();
                            
                            /*
                            PER ELABORAZIONE PERSONALI
                            se il numero di Tel non ha personali, 
                            cancello il file corrispondente
                            */
                            if(id.equals(AnalisiFile.ricPersonali) & Cancel){
                                AnalisiFile.eliminaFile(Ascoltatore.drOutput 
                                                      + "\\"+ i + "-" 
                                                      + nRubrica[i].getNumero() + "-"
                                                      + LeggiRubrica.normalizzaNome(nRubrica[i].getNome())
                                                      + ".txt");
                            }
                            Cancel=true;
                            break;
                        } 
                    } 
                }
            }
        inputStream.close(); 
        
        } catch(IOException e){
            JOptionPane.showMessageDialog(null,"Scansionatore.scansiona ** "+e);
        }
    }
    
}