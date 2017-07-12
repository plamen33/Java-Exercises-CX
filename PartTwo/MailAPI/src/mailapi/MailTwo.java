package mailapi;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class MailTwo {
    public static void main(String[] args) {

        String to = "somemail@abv.bg";
        String cc = "somemail@yandex.ru";
        String bcc = "somemail@gmail.com";

        // sender's data
        String from = "somemail@yandex.ru";
        final String username = "somemail";
        final String password = "password";

        // smtp host:
        String host = "smtp.yandex.ru";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        // props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // get Session object:
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From:
            message.setFrom(new InternetAddress(from));

            // Set to, cc, bcc
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));

            // Set Subject of email:
            message.setSubject("Test Email, as per Task 1.2 - Part 2");


            // Set HTML content
            message.setContent(
                    "<b>This is bold text.</b></br>"
                    + "<i>This is italic text.</i>"
                    + "<h3 style=\"color:green;\">This text is green.</h3>",
                    "text/html");

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
