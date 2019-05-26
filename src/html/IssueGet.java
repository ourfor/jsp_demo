package html;
import org.jsoup.*;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.*;
import com.alibaba.fastjson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IssueGet {

    private List<BlogBean> issue = null;
    static String cookie = "_octo=GH1.1.2089281805.1555738401; _ga=GA1.2.1450176174.1555738403; _device_id=ad893120505ac0dc514cf584d4f5543a; user_session=QFac6BNaJynWSmwvWI7neHWtQDWVZNrGgq8FZzU0DbjlUNcg; __Host-user_session_same_site=QFac6BNaJynWSmwvWI7neHWtQDWVZNrGgq8FZzU0DbjlUNcg; logged_in=yes; dotcom_user=ourfor; has_recent_activity=1; tz=Asia%2FShanghai; _gh_sess=dzdqdS82Rmo3K3FpRzJ6b2NqZ3VyNzF0elV0NUhDdzlxS3lMMjJDZjlkd3UxRW82c0JhWlpUalo2U3krUXdIbHUzWGlDNDBvTFVXVkR1aGlzUEhzSGI0R1orVm1jMmI0VFByQ3pLeFprcm9zQzZLNGRaQ0diZ2NSL1g4b05oR1JJS0hYZHcwN21RUmpWVDh2THlXdXdWOGlYWnBGQWFZVzBtY1RzK3pYcVo3MlF0cTRybS9BOC9mb0M4RzQyNUIzMWM0SitmQ2Rsc29pemR4Y3lOMDFHUT09LS1kbUQ5bXY5ZFRPdWVpK3hBaXU4S2JnPT0%3D--d5ae2e3003fdff3765b740b5f2e762a38034601b";
    static String user_agent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36";
    static String accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3";

    public static void main(String args[]){
        String url = "https://github.com/ourfor/Blog/issues/25";
        try {
            Connection connection =Jsoup.connect(url);
            connection.header("Cookie",cookie);
            connection.header("User-Agent",user_agent);
            connection.header("Accept",accept);
            connection.header("Accept-Language","zh-TW,zh-CN;q=0.9,zh;q=0.8,en;q=0.7");
            connection.header("Connection","keep-alive");

            File fp = new File("/Users/sagit/Desktop/apache.md");


            Document doc = connection.get();
            Elements textarea = doc.getElementsByAttributeValue("name","issue_comment[body]");
            Elements time = doc.getElementsByTag("relative-time");
            String ContentAll = "";
            for(int i=0;i<textarea.size();i++){
                String content = textarea.get(i).text();
//                Element timeCurrent = time.get(i);
//                String updateAt = timeCurrent.attributes().get("datetime");
//                System.out.println(content);
                ContentAll += content + "\n"+"---"+"\n";
            }

            write(fp,ContentAll,"UTF-8");

            System.out.println(ContentAll);


        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    public static void write(File file, String content, String encoding)
            throws IOException {
        file.delete();
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), encoding));
        writer.write(content);
        writer.close();
    }
}
