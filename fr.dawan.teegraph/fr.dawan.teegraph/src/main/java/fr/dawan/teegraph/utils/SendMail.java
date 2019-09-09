package fr.dawan.teegraph.utils;

import java.util.*;

public class SendMail {

	/**
	 * Utility method to send simple HTML email
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendEmail(String toEmail, String subject, String body){
		try
		{
			// Il faut utiliser le serveur smtp de la box sur laquelle on est connectée
			// Ici dans l'exemple c'est une box free
			String smtpHostServer = "smtp.free.fr";
			
			Properties props = System.getProperties();

			props.put("mail.smtp.host", smtpHostServer);
			// Port par défaut à 25 mais peut avoir été modifié 
			props.put("mail.smtp.port", 25);

			Session session = Session.getInstance(props, null);
			
			MimeMessage msg = new MimeMessage(session);
			//set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);  

			System.out.println("Email Sent Successfully!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {

		System.out.println("SimpleEmail Start");

		String emailID = "adelafont@jehann.fr";

		sendEmail(emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");

	}

}