package mail;
import com.sun.mail.smtp.SMTPSSLTransport;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.activation.*;
import java.util.Properties;


public class MailConfig {
    private String mailServer="";
    private String port = "";
    private String from = "";
    private String to = "";
    private String user = "";
    private String password = "";
    private String main_content = "你好，这是一封通过JavaMail发送的邮件😯";
    private String subject = "Hello JavaMail";

    public boolean send(){
        Properties pro = new Properties();
        pro.put("mail.smtp.host",this.mailServer);
        pro.put("mail.smtp.auth","true");
        pro.put("mail.smtp.ssl.enable",true);
        pro.put("mail.smtp.port",this.port);

        Session sess = Session.getInstance(pro);
        sess.setDebug(true);

        MimeMessage message = new MimeMessage(sess);

        SimpleDateFormat now = new SimpleDateFormat("YYYY年MM月dd日 hh时mm分ss秒");

        try{
            InternetAddress sender = new InternetAddress(from);
            message.setFrom(from);
            message.setSentDate(new Date());
            InternetAddress receiver = new InternetAddress(to);
            message.setSubject(subject);
            message.setText(this.main_content);

            message.setRecipient(Message.RecipientType.TO,receiver);
            message.saveChanges();

            Transport transport = sess.getTransport("smtp");
            try{
                transport.connect(mailServer,user,password);
                transport.sendMessage(message,message.getAllRecipients());
                transport.close();
                return true;
            }
            catch(Exception e2){
                System.out.println(e2);
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public MailConfig(String from,String receiver,String user,String password){
        this.from = from;
        this.to = receiver;
        this.user = user;
        this.password = password;
    }

    public void MailServer(String mailServer,String port){
        this.mailServer = mailServer;
        this.port = port;
    }

    public void setContent(String main_content){
        this.main_content = main_content;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }
}
