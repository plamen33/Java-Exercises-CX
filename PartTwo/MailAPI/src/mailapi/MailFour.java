package mailapi;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


class MailFour {
    public static void main(String[] args) {

        Properties props = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("D:\\Documents\\1 Programming\\Codix\\mail_send.properties");
            props.load(input);

            String to = props.getProperty("to");
            String cc = props.getProperty("cc");

            // sender's data
            String from = props.getProperty("from");
            final String username = props.getProperty("username");
            final String password = props.getProperty("password");

            // smtp host:
            String host = props.getProperty("host");

            props.getProperty("mail.smtp.auth");
            props.getProperty("mail.smtp.host");
            props.getProperty("mail.smtp.port");
            props.getProperty("mail.smtp.socketFactory.port");
            props.getProperty("mail.smtp.socketFactory.class");

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

                // Set to, cc, bcc:
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));

                // Set Subject of email:
                message.setSubject(props.getProperty("subject"));

                // Create the message part
                BodyPart messageBodyPart = new MimeBodyPart();

                // set the body of the email
                messageBodyPart.setText(props.getProperty("body"));

                // Create a multipart message
                Multipart multipart = new MimeMultipart();

                // Set text message part
                multipart.addBodyPart(messageBodyPart);

                // Attachments:
                // first attachment:
                messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(props.getProperty("fileOneLocation"));
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(props.getProperty("fileOneName"));
                multipart.addBodyPart(messageBodyPart);

                //second attachment:
                MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                DataSource source2 = new FileDataSource(props.getProperty("fileTwoLocation"));
                messageBodyPart2.setDataHandler( new DataHandler(source2));
                messageBodyPart2.setFileName(props.getProperty("fileTwoName"));
                multipart.addBodyPart(messageBodyPart2);

                // set the complete message parts
                message.setContent(multipart);


                // Send message
                Transport.send(message);

                System.out.println("Sent message successfully.");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException ex) {
           ex.printStackTrace();
        }

    }
}
