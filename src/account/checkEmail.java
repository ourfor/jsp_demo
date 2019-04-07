package account;
import mail.MailConfig;

public class checkEmail {
    private static String alnum = "abcdefghijklmnopqrestuvwxyz1234567890ABCDEFGHIJKLMNOPQRESTUVWXYZ1234567890";
    private static MailConfig send;

    public static void main(String args[]){
        System.out.println(getCode());
    }

    public static String getCode(){
        String checkCode = "";
        for(int i=0;i<6;i++){
            int random = (int)(Math.random()*(alnum.length()-1));
            checkCode += alnum.substring(random,random+1);
        }
        return checkCode;
    }

    public static void sendEmail(String from,String to,String user,String password){

    }


}
