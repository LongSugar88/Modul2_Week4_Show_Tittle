import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pico {
    private Pattern pattern;

    public static void main(String[] args) {
        try {
            String link = "https://pico.vn/may-giat-nhom-72.html";
            URL url = new URL(link);
            Scanner scan = new Scanner(url.openStream());
            scan.useDelimiter("\\Z");
            String content = scan.next();
            content = content.replaceAll("\n", "");
            Pattern nameAndPrice = Pattern.compile(".html\">(.+?)</a></h6><div class=\"(.+?)\"><span(.+?)class=\"price\">(.+?)</span>");
            Pattern linkProduct = Pattern.compile("</div><h6><a href=\"(.+?)\">");
            int count = 0;
            Matcher matcherLink = linkProduct.matcher(content);
            Matcher matcherNameAndPrice = nameAndPrice.matcher(content);
            while(matcherNameAndPrice.find() && matcherLink.find()){
                count++;
                System.out.println(count + "," + matcherNameAndPrice.group(1)+ "," + matcherNameAndPrice.group(4)+ "," + matcherLink.group(1));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
