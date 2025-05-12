import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RequestApi {
    public double buscarTaxa(String origem, String destino) throws Exception {
        String chaveApi = "be3bdfd36e11d6a62bb94425";
        String endpoint = "https://v6.exchangerate-api.com/v6/" + chaveApi + "/latest/" + origem;

        URL url = new URL(endpoint);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");

        try (BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()))) {
            JsonObject respostaJson = JsonParser.parseReader(leitor).getAsJsonObject();
            JsonObject taxas = respostaJson.getAsJsonObject("conversion_rates");
            return taxas.get(destino).getAsDouble();
        }
    }
}