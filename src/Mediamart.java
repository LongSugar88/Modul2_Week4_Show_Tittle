import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mediamart {
    public static void main(String[] args) {
        try {
            String location = "https://mediamart.vn";
            String link = "https://mediamart.vn/tivi/";
            URL url = new URL(link);
            Scanner scan = new Scanner(url.openStream());
            scan.useDelimiter("\\Z");
            String content = scan.next();
            content = content.replaceAll("\n", "");
            Pattern nameAndLink = Pattern.compile("\">\\s+<a href=\"(.+?)\" title=\"(.+?)\" target=\"_blank\">");
            Pattern price = Pattern.compile("pbuy\">\\s+(.+?)<span>đ</span>");
            Matcher matcher = nameAndLink.matcher(content);
            Matcher matcher1 = price.matcher(content);
            while (matcher.find() && matcher1.find()){
                System.out.println("********************************************");
                System.out.println(matcher.group(2)+","+ matcher1.group(1)+","+location+matcher.group(1));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
