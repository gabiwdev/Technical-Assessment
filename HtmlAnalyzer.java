import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


class HtmlAnalyzer {
    public static void main(String[] args){

        // Crio uma string com o URL do site
        String websiteURL = "https://httpbin.org/html";

        // Lista onde cada linha do HTML será armazenada
        List<String> lines = new ArrayList<>();

        // Operações de rede de entrada/saída são códigos que o java o obriga a tratar com try
        try {

            // Crio uma variável URL que já valida se aquilo é um URL
            URL url = new URL(websiteURL);


            // Permite ler linha por linha ao invés de caractere por caractere, aumentando a eficiência
            BufferedReader in = new BufferedReader(

                    // url.openStream() abre uma conexão HTTP e retorna os dados vindos do servidor
                    // InputStreamReader converte bytes dos dados recebidos em caracteres usando UTF-8
                    new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)
            );

            // Variável que guarda a linha atual
            String inputLine;

            // Enquanto houver linhas disponiveis, o loop adicionará a linha sem espaços a lista
            while ((inputLine = in.readLine()) != null) {

                lines.add(inputLine.trim());
            }


        }

        // Captura erros de conexão, leitura, falha de rede ou do site de teste fora do ar
        catch (IOException e){
            System.out.println(e);
        }

        lines.remove(0);
        lines.remove(4);
        lines.remove(4);

        // Define a variável maxDepth, a profundidade máxima do código HTML
        int maxDepth = -1;

        // Define a variável currentDepth, a profundidade atual da tag, uso interno
        int currentDepth = 0;

        // Define a varíavel que o texto na camada
        String deepestText = "";

        System.out.println(lines);

        // Itera sobre as linhas o HTML
        for (String line : lines) {

            // Atualiza a currentDepth em -1 se for tag de fechamento
            if (line.startsWith("</")) {
                currentDepth--;
            }

            // Atualiza a currentDepth em +1 se for tag de abertura
            else if (line.startsWith("<")) {
                currentDepth++;
            }

            // Roda só se não for tag de abertura e fechamento
            else {
                // Atualiza a maxDepth pra currentDepth caso a mesma seja maior
                // Atualiza o texto para o texto da linha atual
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                    deepestText = line;
                }
            }


        }
        System.out.println(deepestText);
        System.out.println(maxDepth);
    }
}

