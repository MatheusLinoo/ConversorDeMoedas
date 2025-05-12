import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogError {
    public void registrarErro(String mensagem) {
        try (FileWriter log = new FileWriter("erros.log", true)) {
            log.write(LocalDateTime.now() + " | Erro: " + mensagem + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de log.");
        }
    }
}