package account;
import mail.MailConfig;

public class checkEmail {
    private static String alnum = "abcdefghijklmnopqrestuvwxyz1234567890ABCDEFGHIJKLMNOPQRESTUVWXYZ1234567890";
    private static MailConfig send;

    public static void main(String args[]){
        System.out.println(getCode());
        sendEmail("ourfor@foxmail.com",getCode());
    }

    public static String getCode(){
        String checkCode = "";
        for(int i=0;i<6;i++){
            int random = (int)(Math.random()*(alnum.length()-1));
            checkCode += alnum.substring(random,random+1);
        }
        return checkCode;
    }

    public static void sendEmail(String to,String Content){
        String[] conf = new String[4];
        xml.xmlReader xr = new xml.xmlReader();
        xr.setFile("./conf/mail.xml");
        xr.Read();
        conf[0] = xr.getUser();
        conf[1] = xr.getPassword();
        conf[2] = xr.getServer();
        conf[3] = xr.getPort();
        System.out.println(java.util.Arrays.toString(conf));

        MailConfig send = new MailConfig(conf[0],to,conf[0],conf[1]);
        send.MailServer(conf[2],conf[3]);
        String main = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">" +
                "<head><title>邮箱验证码</title><link rel='shortcut icon' href='https://book.ourfor.top/favicon.ico'></head>" +
                "<body><h4>Zip的小窝</h4><p>你好，你在本网站注册的验证码为:" +Content+
                "</p><body></html>";
        send.setContent(main);

        send.send();

    }


}
