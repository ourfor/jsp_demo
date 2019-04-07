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
    private static RandomAccessFile ras;
    private static String filePath="../../conf/mail.xml";
    private static void Read(){
        DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder dbuild = df.newDocumentBuilder();
            Document document = dbuild.parse(fp);
            Element mail = document.getDocumentElement();
            NodeList nodes = mail.getElementsByTagName("mailUser");
            String user = nodes.item(0).getNodeValue();
            System.out.println(user);
        }
        catch(Exception e){

        }
    }
    public static void main(String args[]){
        System.out.println("N");
        xmlReader a = new xmlReader();
        a.setFile("./conf/mail.xml");
        Read();
    }
    public void setFile(String filePath){
        fp = new File(filePath);
        try {
            ras = new RandomAccessFile(fp, "r");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
