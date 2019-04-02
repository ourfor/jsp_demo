package mail;
import java.util.Scanner;

public class Client {
    public static void main(String args[]){
        String from;
        String receiver;
        String user;
        String password;

        Scanner input = new Scanner(System.in);
        System.out.println("请输入发信邮箱，收信邮箱，密码(例如:from@mail.com,to@mail.com,password)");
        String inputStr = input.next();
        String inputStrs[] = inputStr.split(",");
        from = inputStrs[0].trim();
        receiver = inputStrs[1].trim();
        password = inputStrs[2].trim();
        user = from;

        System.out.println("输入邮箱服务器地址和端口(例如smtp.eg.com:port)");
        String MailServer = input.next();
        String serverInfo[] = MailServer.split(":");




        String content = "待到山花烂漫时，它在丛中笑";
        String subject = "";

        System.out.print("输入邮件的主题:");
        subject = input.next();

        System.out.println("输入邮件的主要内容:");
        content = input.next();



        MailConfig mailTo = new MailConfig(from,receiver,user,password);
        mailTo.MailServer(serverInfo[0].trim(),serverInfo[1].trim());
        mailTo.setSubject(subject);
        mailTo.setContent(content);
        mailTo.send();

    }
}
