/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author massi
 */

import java.util.Scanner;

public class ExtractData {
    
    private static String id_1 = "72\tT"; //Fonia Ricaricabile--nono valore--Tot. Fonia/Fax e Dati RICARICABILE BUSINESS
    private static String id_2 = "35\tT"; //Fonia Abbonamento--settimo valore--Totale importo traffico generico utenza:
    private static String id_3 = "46\tT"; //Dati Abbonamento--settimo valore--Totale importo traffico generico utenza:
    private static String id_4 = "47\tI"; //Bundle Abbonamento--settimo valore--"47 Intercent 2014 2GB"
    private static String id_5 = "15\tP"; //Nel riepilogo compare la stringa delle personali "15 PERSONALE.."
    private static String ConsumoFonia=null;
    private static String ConsumoDati=null;
    private static String Bundle=null;
    
    /*
    linea = linea da analizzare
    utente = contatto corrispondente
    
    Questo metodo estrae uno specifico valore dalla linea passata in ingresso
    e lo salva nel campo del contatto corrispondente
    */
    public static void extraction (String linea, Contatto utente){
        ConsumoFonia=null;
        ConsumoDati=null;
        Bundle=null;
        
        if(linea.contains(id_1)){
            Scanner line_scan = new Scanner (linea);
            for (int y = 1; y<10; y++) {
                ConsumoFonia = line_scan.next();
            }
            utente.setConsumoFonia(ConsumoFonia);
        }
        
        
        if(linea.contains(id_2)){
            Scanner line_scan = new Scanner (linea);
            for (int y = 1; y<8; y++) {
                ConsumoFonia = line_scan.next();
            }  
            utente.setConsumoFonia(ConsumoFonia);
        }
        
        
        if(linea.contains(id_3)){
            Scanner line_scan = new Scanner (linea);
            for (int y = 1; y<8; y++) {
                ConsumoDati = line_scan.next();
            }
            utente.setConsumoDati(ConsumoDati);
        }
        
        
        if(linea.contains(id_4)){
            Scanner line_scan = new Scanner (linea);
            for (int y = 1; y<5; y++) {
                Bundle = line_scan.next();
            }
            utente.setBundle(Bundle);
        /* 
        x debug
        
        System.out.println(linea);
        System.out.println(Bundle);
        */
        }
           

    }
    /*
    Questo metodo verifica che la linea passata contenga id_5(PERSONALI)
    in tal caso ritorna STOP per far cancellare il file
    */
    public static boolean fileCancel (String linea){
        if(linea.contains(id_5)){
            return false;
        } else {
        return true;
        }
    }
    
}
