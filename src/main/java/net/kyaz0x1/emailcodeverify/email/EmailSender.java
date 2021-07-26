package net.kyaz0x1.emailcodeverify.email;

import net.kyaz0x1.emailcodeverify.auth.AuthCredentials;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSender {

    public static boolean send(String emailTo, String title, String content){
        final SimpleEmail email = new SimpleEmail();

        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(AuthCredentials.EMAIL, AuthCredentials.PASSWORD));
        email.setSSLOnConnect(true);

        try {
            email.setFrom(AuthCredentials.EMAIL);
            email.setSubject(title);
            email.setMsg(content);
            email.addTo(emailTo);
            email.send();
            System.out.println("[EmailSender] Mensagem enviada com sucesso!");
            return true;
        }catch(EmailException e) {
            e.printStackTrace();
            return false;
        }
    }

}