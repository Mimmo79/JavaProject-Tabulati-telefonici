
import java.io.*;
import java.util.Scanner;

public class LeggiRubrica {
    
    /**
    * @contNomi contatore rubrica
    * N.B
    * 
    */
    
    /**
    * @contNomi rappresenta il numero di elementi in "nRubrica - 1"
    **/
    static int contNomi=0;
    
    /*
    @ normalizzaNome normalizza il nome eliminando tutti i caratteri non validi per un nome file
    */
    public static String normalizzaNome(String parola){
                    
        parola = parola.replace("\\", "-");
        parola = parola.replace("/", "-");
        parola = parola.replace(":", "-");
        parola = parola.replace("*", "-");
        parola = parola.replace("?", "-");
        parola = parola.replace("\"", "-");
        parola = parola.replace("<", "-");
        parola = parola.replace(">", "-");
        parola = parola.replace("|", "-");
        
        return parola; 
    }
       
    
    public static Contatto[] acquisizione(){

        Contatto[] nRubrica = new Contatto[500]; 

        try {
            BufferedReader ru = new BufferedReader(new FileReader(Ascoltatore.fileRubrica));
            Scanner nomi = new Scanner(ru);
            nomi.useDelimiter(";");

            /*
            Assorbo i nomi
            I campi devono essere separati da ";"
            Es. 3200193947;TAGLIAFERRI ELISA;DIREZIONE GENERALE ;
            N.B. anche l'ultimo campo deve avere ";", basta esportare in .cvs 
            con una colonna libera sulla dx
            
            Andare sul file word K:\U_Telematica\TIM\ELENCO CELLULARI TIM CON AREA PER TABULATO TELEFONATE
            copiare le celle "NUM.CELL.	ADDETTO SERVIZIO"
            incollarle in un file calc e ripulirle dalle intestazioni(incollare nella prima colonna a sx e in alto)
            aggiungere un simbolo es. ; sulla 4° colonna (questo serve per avere il ; alla fine del 3 campo)
            selezionare le 4 colonne e salvare come .csv (simbolo ; come divisore)

            */
            while (nomi.hasNextLine()) {
                Contatto culo = new Contatto(   nomi.next(),
                                                nomi.next(),
                                                nomi.next(),
                                                "0",
                                                "0",
                                                "0",
                                                "0",
                                                "0",
                                                true
                                            );
                   
                nRubrica[contNomi] = culo;

                /* output per debug
                System.out.println(culo.getNumero()+" numero");
                System.out.println(culo.getNome()+" nome");
                System.out.println(culo.getServizio()+" servizio");
                System.out.println(culo.getCheck()+" check");
                System.out.println(contNomi);
                */

                //Se esiste un'altra linea incremento
                //se la linea contiene un altro campo, icremento il contatore dei nomi
                if (nomi.hasNextLine()){                  
                    nomi.nextLine();
                    if (nomi.hasNext())
                        contNomi = contNomi+1;
                }         
            }
            ru.close();
        } catch(IOException e){
            System.out.println("LeggiRubrica.acquisizione ** "+e);
        }
    return nRubrica;
    }       
}
