package mailapi;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;


public class MailThree {
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

        // get Session object.
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
            message.setSubject("Test Email, as per Task 1.3 - Part 2");

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // set the body of the email
            messageBodyPart.setText("This email contains 2 attachment files - a txt file and an image.");

            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Attachments:
            // first attachment:
            messageBodyPart = new MimeBodyPart();
            String filenameOne = "D:\\Documents\\1 Programming\\Codix\\file1.txt";
            DataSource source = new FileDataSource(filenameOne);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("file1.txt");
            multipart.addBodyPart(messageBodyPart);

            //second attachment
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            DataSource source2 = new FileDataSource("D:\\Documents\\1 Programming\\Codix\\javagreen.jpg");
            messageBodyPart2.setDataHandler( new DataHandler(source2));
            messageBodyPart2.setFileName("javagreen.jpg");
            multipart.addBodyPart(messageBodyPart2);

            // set the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
