



/**
 *
 * @author massi
 */
public class Contatto {

    private String numeroTelefono = null;
    private String nome = null; 
    private String servizio = null;
    private String check = null;
    private String tipo = null;
    private String consumoFonia = null;
    private String consumoDati = null;
    private String bundle = null;
    private Boolean Personali = null;
    
    public Contatto(    String nuovoNumeroTelefono, 
                        String nuovoNome, 
                        String nuovoServizio,
                        String nuovoCheck,
                        String nuovoTipo,
                        String nuovoConsumoFonia,
                        String nuovoConsumoDati,
                        String nuovoBundle,
                        Boolean nuovoPersonali
                                                    ) {
        
        numeroTelefono = nuovoNumeroTelefono;
        nome = nuovoNome;
        servizio = nuovoServizio;
        check = nuovoCheck;
        tipo = nuovoTipo;
        consumoFonia = nuovoConsumoFonia;
        consumoDati = nuovoConsumoDati;
        bundle = nuovoBundle;
        Personali = nuovoPersonali;
    }

    
    public void setNumero(String newNumber) {
    	numeroTelefono = newNumber;
    }
    
    public void setNome(String newName) {
        nome = newName;
    }
        
    public void setServizio(String newServizio) {
    	servizio = newServizio;
    }
    
    public void setCheck(String newCheck) {
    check = newCheck;
    }
    
    public void setTipo(String newTipo) {
    	tipo = newTipo;
    }
    
    public void setConsumoFonia(String newConsumoFonia) {
    	consumoFonia = newConsumoFonia;
    }
    
    public void setConsumoDati(String newConsumoDati) {
    	consumoDati = newConsumoDati;
    }
        
    public void setBundle(String newBundle) {
    	bundle = newBundle;
    }
    
    public void setPersonali(Boolean newPersonali){
    	Personali = newPersonali;
    }
    
    
    
    public String getNumero() {
    	return numeroTelefono;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getServizio() {
    	return servizio;
    }
    
    public String getCheck() {
    	return check;
    }
    
    public String getTipo() {
    	return tipo;
    }
    
    public String getConsumoFonia() {
    	return consumoFonia;
    }
    
    public String getConsumoDati() {
    	return consumoDati;
    }
    
    public String getBundle() {
    	return bundle;
    }
    
    public Boolean getPersonali() {
    	return Personali;
    }
    
    
    
    public void print() {
        System.out.println(" ");
        System.out.println( numeroTelefono +"\t\t\t"+
                            nome +"\t\t"+
                            servizio +"\t\t"+
                            check +"\t\t"+
                            tipo +"\t\t"+
                            consumoFonia +"\t\t"+
                            consumoDati +"\t\t"+
                            bundle
                           );
        //System.out.println(" ");
    }
}
