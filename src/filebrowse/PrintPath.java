package filebrowse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;

public class PrintPath {
    public static void main(String args[]){
        System.out.println("输入你要打开的目录");
        Scanner input = new Scanner(System.in);
        String pathBase = input.next().trim();
        System.out.println(pathBase);

        PrintPath a = new PrintPath();
        List<String> list = a.getChildFile(pathBase);

        for(String str : list){
            System.out.println(str);
        }

    }

    List<String> getChildFile(String path){
        List<String> list = new ArrayList<String>();
        File file = new File(path);
        File[] fileList = file.listFiles();
        try {
            for (File item : fileList) {
                list.add(item.toString());
            }
            return list;
        }
        catch(NullPointerException e){
            return null;
        }
    }
}
