


import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

//* @Main


public class Main {
    
    
    public static void main(String[] args){
        
        MyFrame myFrm = new MyFrame();
        
    }
  
}




/*
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

private JPanel pannelloSinistro;
private JPanel pannelloDestro;


public Main() {
Container c = getContentPane();
c.setLayout( new BorderLayout() );

// Creo il pannello sinistro di dimensione fissa
pannelloSinistro = new JPanel();

// Imposto la dimensione fissa
pannelloSinistro.setPreferredSize( new Dimension(200, 600) );

// ... e i colori
pannelloSinistro.setOpaque( true );
pannelloSinistro.setBackground( Color.GREEN.darker() );

// Questo il pannello "variabile"
pannelloDestro = new JPanel();
pannelloDestro.setOpaque( true );
pannelloDestro.setBackground( Color.BLUE );

// Li aggiungiamo alla finestra
c.add(pannelloSinistro, BorderLayout.WEST);
c.add(pannelloDestro, BorderLayout.CENTER);

setResizable( true );
setTitle("Finestra di prova");
setDefaultCloseOperation( EXIT_ON_CLOSE );
setSize(800, 600);
setVisible( true );
}

public static void main(String[] args) {
Main mf = new Main();
}

}
*/