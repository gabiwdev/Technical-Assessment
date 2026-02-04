import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


class HtmlAnalyzer {
    public static void main(String[] args){

        // Crio uma string com o URL do site
        String websiteURL = "https://httpbin.org/html";

        // Operações de rede de entrada/saída são códigos que o java o obriga a tratar com try
        try {

            // Crio uma variável URL que já valida se aquilo é um URL
            URL url = new URL(websiteURL);

            // Permite ler linha por linha ao invés de caractere po caractere, aumentando a eficiencia
            BufferedReader in = new BufferedReader(

                    // url.openStream() uma conexão HTTP e retorna os dados vindos do servidor
                    // InputStreamReader converte bytes dos dados recebidos em caracteres usando UTF-8
                    new InputStreamReader(url.openStream())
            );

            // Variável que guarda a linha atual
            String inputLine;

            // Lista onde cada linha do HTML será armazenada
            List<String> lines = new ArrayList<>();

            // Enquanto ouver linhas disponiveis, o loop adicionará a linha sem espaços a lista
            while ((inputLine = in.readLine()) != null) {

                lines.add(inputLine.trim());
            }

        // Printa no terminal a lista "linhas"
        System.out.println(lines);
        }

        // Captura erros de conexão, leitura, falha de rede ou do site de teste fora do ar
        catch (IOException e){
            System.out.println(e);
        }
    }
}

