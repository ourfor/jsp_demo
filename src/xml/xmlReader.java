package xml;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.RandomAccessFile;

public class xmlReader {
    private static File fp;
    private static String filePath="./conf/mail.xml";
    private String user;
    private String password;
    private String server;
    private String port;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void Read(){
        DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder dbuild = df.newDocumentBuilder();
            Document document = dbuild.parse(fp);
            Element mail = document.getDocumentElement();
            System.out.println(mail.getAttribute("author"));

            Element mailUser = (Element) mail.getElementsByTagName("mailUser").item(0);
            Element user = (Element) mailUser.getElementsByTagName("user").item(0);
            Element passwd = (Element) mailUser.getElementsByTagName("password").item(0);

            this.setUser(user.getTextContent());
            this.setPassword(passwd.getTextContent());

            Element mailServer = (Element) mail.getElementsByTagName("mailServer").item(0);
            Element server = (Element) mailServer.getElementsByTagName("server").item(0);
            Element port = (Element) mailServer.getElementsByTagName("port").item(0);
            this.setServer(server.getTextContent());
            this.setPort(port.getTextContent());
        }
        catch(Exception e){

        }
    }

    public void setFile(String filePath){
        fp = new File(filePath);
    }
}
