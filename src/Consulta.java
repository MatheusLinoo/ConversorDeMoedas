import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta {
    public void gravarConversao(String texto) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String linha = timestamp + " | " + texto;

        try (FileWriter arquivo = new FileWriter("conversoes.txt", true)) {
            arquivo.write(linha + "\n");
            System.out.println("Conversão registrada com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar conversão: " + e.getMessage());
        }
    }
}