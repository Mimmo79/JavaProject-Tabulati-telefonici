



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author massi
 */
public final class MyFrame extends JFrame {
    
       
    //Istanza Ascoltatore
    private static final Ascoltatore listener = new Ascoltatore();
    
    
    
    //Titolo finestra
    private static final String titolo = "Elaborazione Flusso Telecom";
    
    //Dimensioni finestra
    private static final int larghezza=400, altezza=200;
        
    //Pannello Nord
    private static final JLabel testo = new JLabel("Elaborazione report Telecom");
    private static final JPanel nordPnl = new JPanel();
    
    //Pannello Centrale
    private static final JButton uno = new JButton("Apri Rubrica");
    private static final JButton due = new JButton("Apri flusso chiamate");
    private static final JButton tre = new JButton("Dove salvo i dati?");
    private static final JPanel centralPnl = new JPanel(new GridLayout(3,1));
            
    //Pannello Sud
    private static final JButton quattro = new JButton("Avvia l'elaborazione");
    private static final JPanel sudPnl = new JPanel();
    
    

    
    
    
public MyFrame(){
        //super(titolo);
        super(titolo);
        //comportamento su chiusura
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //MenuBar
        JMenuItem Up = new JMenuItem("sopra");
        JMenu jm = new JMenu("Edit");
        jm.add(Up);
        JMenuBar jb = new JMenuBar();
        jb.add(jm);
        this.setJMenuBar(jb);
        
        
        
        
        //Pannello Nord
        nordPnl.add(testo);
        
                
        //Pannello Centro
        centralPnl.setPreferredSize(new Dimension(100,100));
        centralPnl.setBackground(Color.red);
        centralPnl.add(uno);
        uno.addActionListener(listener);
        uno.setActionCommand("uno");
        centralPnl.add(due);
        due.addActionListener(listener);
        due.setActionCommand("due");
        centralPnl.add(tre);
        tre.addActionListener(listener);
        tre.setActionCommand("tre");
        
        
        //Pannello Sud
        sudPnl.add(quattro);
        quattro.addActionListener(listener);
        quattro.setActionCommand("quattro");
        
       
        //Container Principale    
        Container frmContainer = getContentPane();
        frmContainer.add(nordPnl,BorderLayout.NORTH);
        frmContainer.add(centralPnl,BorderLayout.CENTER);
        frmContainer.add(sudPnl,BorderLayout.SOUTH);
        this.setSize(larghezza,altezza);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        

    }
    
} 
    
    
    
    
    
    
    
    
    
    
    
    
    
/**
 *      //crea una finestra con titolo "hello World"
        JFrame frm = new JFrame ("Hello World!");
        //Rende la finestra visibile
        frm.setVisible(true);
        //compertamento su chiusura
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //cerchiamo il riferimento al ContentPane del Frame
        Container frmContentPane = frm.getContentPane();
        //aggiungo un elemento grafico al ContentPane
        frmContentPane.add(new JLabel("Buona Lezione!"));
        frm.setSize(200, 200);
        System.out.println("Ciao ciao");
   
   
 */