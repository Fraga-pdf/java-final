// Importações necessárias para a escrita de dados em ficheiros de texto
import java.io.BufferedWriter; // Classe que escreve texto num ficheiro de forma eficiente (usando um buffer)
import java.io.FileWriter; // Classe que converte os caracteres da nossa aplicação para o ficheiro físico no disco
import java.io.IOException; // Classe que trata exceções (erros) de entrada/saída de dados

// Classe responsável por gravar as operações no ficheiro de log, isolando esta responsabilidade
public class Logger { // Início da declaração da classe pública Logger
    
    // Constante estática (imutável) que define o nome do ficheiro onde os registos serão guardados
    private static final String ARQUIVO_LOG = "log.txt"; 

    // Método estático para registar uma mensagem. Sendo estático, não precisamos de fazer 'new Logger()' para o usar
    public static void registrar(String acao, String detalhe) { // O método recebe o tipo de ação (Ex: "INCLUSAO") e os detalhes
        
        // Inicia um bloco try-with-resources. Os recursos abertos aqui (o ficheiro) serão fechados automaticamente no fim
        // O parâmetro 'true' no FileWriter é FUNDAMENTAL: indica que vamos ADICIONAR (append) texto ao fim do ficheiro, e não apagá-lo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_LOG, true))) { 
            
            // Monta a linha de texto exata que será escrita no ficheiro, juntando a ação e os detalhes passados
            String linhaLog = "AÇÃO: " + acao + " | DETALHE: " + detalhe; 
            
            bw.write(linhaLog); // Escreve a linha montada no ficheiro físico
            bw.newLine(); // Insere uma quebra de linha ("Enter") no ficheiro para que o próximo log fique na linha de baixo
            
        } catch (IOException e) { // Se ocorrer algum erro (ex: o sistema operativo não deixar criar o ficheiro por falta de permissão)
            
            // Imprime o erro na consola (ecrã) para que o programador ou o utilizador saiba o que falhou
            System.out.println("Erro ao gravar log: " + e.getMessage()); 
            
        } // Fecha o bloco catch
        
    } // Fecha o método registrar
    
} // Fecha a classe Logger