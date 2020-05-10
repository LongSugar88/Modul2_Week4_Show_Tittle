import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Show_Tittle {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn");
            Scanner scan = new Scanner(url.openStream());
            scan.useDelimiter("\\Z");
            String content = scan.next();
            content = content.replaceAll("\n", "");
            Pattern pattern = Pattern.compile("<a href=\"(.+?)\">(.+?)</a>");
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()){
                System.out.println(matcher.group(2)+"\n"+"https://dantri.com.vn/" + matcher.group(1) );
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
