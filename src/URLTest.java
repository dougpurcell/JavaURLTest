import java.io.*;
import java.net.*;

public class URLTest {

    private static String urlContents(String url) {
        StringBuilder content = new StringBuilder();

        try {
            URL site = new URL(url);
            URLConnection urlConnection = site.openConnection();
            BufferedReader br = new BufferedReader(
                    (new InputStreamReader(urlConnection.getInputStream()))
            );
            String line = br.readLine();

            while (line != null) {
                content.append(line + "\n");
                br.close();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return content.toString();

    };

    private static int urlCharCount (String url) {
        int count = 0;

        try {
            URL site = new URL(url);
            URLConnection urlConnection = site.openConnection();
            BufferedReader br = new BufferedReader(
                    (new InputStreamReader(urlConnection.getInputStream()))
            );

            String line = br.readLine();

            for(int i = 0; i <line.length(); i++) {
                if(line.charAt(0) != ' ') {
                    count++;
                }
            }

            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static void main(String[] args) {
        int charCount = urlCharCount("https://cnn.com");
        System.out.println(charCount);

//        String lineCount = urlContents("https://cnn.com");
//        System.out.println(lineCount);

    }
}
