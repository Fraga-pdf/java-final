// Importa a classe File, utilizada para representar e verificar a existência de ficheiros ou diretórios no sistema
import java.io.File;
// Importa o BufferedReader, que lê texto de uma stream de entrada armazenando em buffer para uma leitura eficiente
import java.io.BufferedReader;
// Importa o FileReader, classe de conveniência para ler ficheiros de texto (converte o ficheiro em fluxo de caracteres)
import java.io.FileReader;
// Importa a exceção IOException, obrigatória para tratar potenciais erros que ocorram ao tentar ler o ficheiro
import java.io.IOException;

// Classe responsável por ler o menu a partir do ficheiro de texto, isolando esta funcionalidade (Boa estruturação)
public class MenuReader { // Início da declaração da classe pública MenuReader
    
    // Declara uma constante estática (não muda) contendo o nome do ficheiro de onde o menu será lido
    private static final String ARQUIVO_MENU = "menu.txt"; 

    // Método público e estático (pode ser chamado diretamente pela classe sem fazer 'new MenuReader()')
    public static void exibirMenu() { // Assinatura do método exibirMenu
        
        // Cria um objeto File referenciando o ficheiro "menu.txt" para podermos verificar o seu estado
        File file = new File(ARQUIVO_MENU); 
        
        // Verifica se o ficheiro NÃO existe no sistema
        if (!file.exists()) { 
            // Informa o utilizador que o ficheiro do menu não foi encontrado
            System.out.println("Ficheiro " + ARQUIVO_MENU + " não encontrado. Crie-o na pasta do projeto."); 
            return; // Interrompe a execução deste método para não dar erro ao tentar ler um ficheiro inexistente
        } // Fecha o bloco if

        // Imprime uma linha em branco seguida do cabeçalho do menu
        System.out.println("\n--- MENU DE OPÇÕES ---"); 
        
        // Início de um bloco "try-with-resources". O Java fechará o ficheiro automaticamente no fim do bloco, evitando vazamento de memória
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_MENU))) { 
            
            String linha; // Declara uma variável do tipo String para guardar cada linha lida do ficheiro
            
            // Loop while que lê a próxima linha do ficheiro e guarda na variável. Continua até que não haja mais linhas (null)
            while ((linha = br.readLine()) != null) { 
                System.out.println(linha); // Imprime a linha lida exatamente como está escrita no ficheiro
            } // Fecha o loop while
            
        } catch (IOException e) { // Se algo correr mal durante a leitura (ex: ficheiro corrompido), o Java entra neste bloco
            // Imprime no console a mensagem técnica de erro para facilitar a depuração
            System.out.println("Erro ao ler o ficheiro de menu: " + e.getMessage()); 
        } // Fecha o bloco catch
        
        // Solicita ao utilizador que escolha uma das opções que acabaram de ser listadas
        System.out.print("Escolha uma opção: "); 
        
    } // Fecha o método exibirMenu
    
} // Fecha a classe MenuReader