import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fine_Name_Song {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://chiasenhac.vn/nhac-hot.html");
            Scanner scan = new Scanner(url.openStream());
            scan.useDelimiter("\\Z");
            String content = scan.next();
            content = content.replaceAll("\n", "");

            Pattern pattern = Pattern.compile("<h5 class=\"media-title mt-0 mb-0\"><a href=\"/nhac-hot/beat-playback.html?(.+?)\">(.+?)</a>");
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()){
                System.out.println(matcher.group(2));
//                System.out.println(matcher.group(4));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
