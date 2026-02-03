import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


class HtmlAnalyzer {
    public static void main(String[] args){
        String websiteURL = "https://httpbin.org/html";
        try {
            URL url = new URL(websiteURL);


            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );

            String inputLine;
            StringBuilder htmlContent = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                htmlContent.append(inputLine);
            }

        System.out.println(htmlContent);
        }

        catch (IOException e){
            System.out.println(e);
        }
    }
}

