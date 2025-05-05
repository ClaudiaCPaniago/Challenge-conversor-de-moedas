import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class ConversorDeMoeda {

    static final String API_KEY = "f3fd3eb991da5ccacbb46b8f";
    static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            String moedaOrigem = "";
            String moedaDestino = "";

            System.out.println("\nSeja bem-vindo/a ao Conversor de Moeda =]");
            System.out.println("1) Dólar >> Peso argentino");
            System.out.println("2) Peso argentino >> Dólar");
            System.out.println("3) Dólar >> Real brasileiro");
            System.out.println("4) Real brasileiro >> Dólar");
            System.out.println("5) Dólar >> Peso colombiano");
            System.out.println("6) Peso colombiano >> Dólar");
            System.out.println("7) Sair");
            System.out.print("Escolha uma opção válida: ");
            opcao = scanner.nextInt();

            if (opcao == 7) {
                System.out.println("Encerrando...");
                break;
            }

            switch (opcao) {
                case 1 -> { moedaOrigem = "USD"; moedaDestino = "ARS"; }
                case 2 -> { moedaOrigem = "ARS"; moedaDestino = "USD"; }
                case 3 -> { moedaOrigem = "USD"; moedaDestino = "BRL"; }
                case 4 -> { moedaOrigem = "BRL"; moedaDestino = "USD"; }
                case 5 -> { moedaOrigem = "USD"; moedaDestino = "COP"; }
                case 6 -> { moedaOrigem = "COP"; moedaDestino = "USD"; }
                default -> {
                    System.out.println("Opção inválida.");
                    continue;
                }
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();
            double convertido = converterComGson(moedaOrigem, moedaDestino, valor);

            if (convertido >= 0) {
                System.out.printf("Valor convertido: %.2f %s\n", convertido, moedaDestino);
            } else {
                System.out.println("Erro ao obter a taxa de câmbio.");
            }
        }
    }

    public static double converterComGson(String origem, String destino, double valor) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/latest/" + origem;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        ExchangeRateResponse data = gson.fromJson(json, ExchangeRateResponse.class);

        if (data != null && data.conversion_rates.containsKey(destino)) {
            double taxa = data.conversion_rates.get(destino);
            return valor * taxa;
        } else {
            return -1;
        }
    }

    // Classe para mapear a resposta JSON
    static class ExchangeRateResponse {
        Map<String, Double> conversion_rates;
    }
}

