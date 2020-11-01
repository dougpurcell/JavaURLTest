import java.io.*;
import java.net.*;

public class URLTest {

    private static int urlLineCount(String url) {
        int lineCount = 0;

        try {
            URL site = new URL(url);
            URLConnection urlConnection = site.openConnection();
            BufferedReader br = new BufferedReader(
                (new InputStreamReader(urlConnection.getInputStream()))
            );
            String line = br.readLine();

            if (line == null || line.isEmpty()) {
                return 0;
            }
            else {
                int position = 0;
                while (
                    (position = line.indexOf("\n", position) + 1) != 0) {
                    lineCount++;
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return lineCount;
    }

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
        System.out.println("Character count is: " + charCount);

        int lineCount = urlLineCount("https://cnn.com");
        System.out.println("Line count is: " + lineCount);

    }
}
