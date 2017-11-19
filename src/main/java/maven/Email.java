package maven;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
	public static void main(String[] args) {
		// Create object of Property file
		Properties props = new Properties();
		System.out.println("Setting properties");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp3.hp.com");
		props.put("mail.smtp.debug", "true");
		// props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.ssl.enable", "true");

		// set the port of socket factory
		props.put("mail.smtp.socketFactory.port", "465");

		// set socket factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		// props.put("mail.smtp.port", "25");
		System.out.println("Props set up");
		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication("bharati.panda@hp.com", "Kansbahal@123");

					}

				});

		try {

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress("bharati.panda@hp.com"));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("bharati.panda@hp.com"));
			// message.addRecipients(Message.RecipientType.CC,InternetAddress.parse("bharati.panda@hp.com"));
			// Add the subject link
			message.setSubject("FeC Smoke Test Automation Results");

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setText("Please find attached excel with automation results");
			System.out.println("test set");
			Multipart multipart = new MimeMultipart();
			// Create another object to add another content

			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename = "TestData.xlsx";
			String fileSource = "C:\\Selenium\\FeC\\FeC\\testData\\TestData.xlsx";
			// Create datasource and pass the filename
			DataSource source = new FileDataSource(fileSource);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			messageBodyPart2.setFileName(filename);

			// Create object of MimeMultipart class

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}
}
