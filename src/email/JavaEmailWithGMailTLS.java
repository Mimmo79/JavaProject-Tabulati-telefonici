package email;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class JavaEmailWithGMailTLS {
    private static final String USERNAME = "sistinfo_applicativi@romagnaforlivese.it";
    private static final String PASSWORD = "0d694b4985+";

    public static void main(String[] args) throws Exception {
        // Email information such as from, to, subject and contents.
        String mailFrom = "sistinfo_applicativi@romagnaforlivese.it";
        String mailTo = "camillo.acerbi@romagnaforlivese.it";
        String mailSubject = "Email test -Tabulati telefonia mobile (Java + TLS-Gmail) ";
        String mailText = "Ciao Camillo,\r"
                + "ho fatto alcune modifiche e direi che la parte mail funziona direttamente su server gmail con autenticazione TLS.\r"
                + "A questo punto, seguendo l'approccio ipotizzato ieri, mi basterebbe conoscere "
                + "il percorso di rete in cui salvare i dati e la modalità da utilizzare "
                + "per la formattazione dei nomi nei files.\r"
                + "\r"
                + "Ciao\r"
                + "Massimo";

        JavaEmailWithGMailTLS gmail = new JavaEmailWithGMailTLS();
        gmail.sendMail(mailFrom, mailTo, mailSubject, mailText);
    }

    private void sendMail(String mailFrom, String mailTo, String mailSubject,
                          String mailText) throws Exception {

        Properties config = createConfiguration();

        // Creates a mail session. We need to supply username and
        // password for Gmail authentication.
        Session session = Session.getInstance(config, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                    JavaEmailWithGMailTLS.USERNAME,
                    JavaEmailWithGMailTLS.PASSWORD
                );
            }
        });

        // Creates email message
        Message message = new MimeMessage(session);
        message.setSentDate(new Date());
        message.setFrom(new InternetAddress(mailFrom));
        message.setRecipient(Message.RecipientType.TO,
            new InternetAddress(mailTo));
        message.setSubject(mailSubject);
        message.setText(mailText);

        // Send a message
        Transport.send(message, JavaEmailWithGMailTLS.USERNAME, JavaEmailWithGMailTLS.PASSWORD);
    }

    private Properties createConfiguration() {
        return new Properties() {{
            put("mail.smtp.auth", "true");
            put("mail.smtp.host", "smtp.gmail.com");
            put("mail.smtp.port", "587");
            put("mail.smtp.starttls.enable", "true");
        }};
    }
}