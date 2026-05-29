// Importações da biblioteca de entrada e saída (I/O) do Java para manipulação de arquivos de texto
import java.io.BufferedReader; // Lê texto de arquivos de forma otimizada
import java.io.BufferedWriter; // Escreve texto em arquivos de forma otimizada
import java.io.File;           // Permite verificar se um arquivo existe no sistema operacional
import java.io.FileReader;     // Abre um arquivo de texto para leitura
import java.io.FileWriter;     // Abre um arquivo de texto para gravação
import java.io.IOException;    // Trata erros previstos de leitura/escrita de arquivos

// Importações das bibliotecas de utilitários do Java (Estruturas de Dados dinâmicas e captura de teclado)
import java.util.ArrayList;    // Implementação de lista dinâmica (vetor que cresce sozinho, ensinado na Aula 08)
import java.util.List;         // Interface abstrata para listas
import java.util.Scanner;      // Classe para capturar o que o usuário digita no teclado

// Classe principal do sistema. É obrigatório ser pública e ter o mesmo nome do arquivo (Main)
public class Main { // Início da classe Main

    // Lista estática que vai funcionar como o nosso "Banco de Dados em Memória" enquanto o programa roda
    private static List<Pessoa> listaPessoas = new ArrayList<>(); 
    // Constante estática indicando o nome do arquivo TXT onde vamos gravar (persistir) os dados
    private static final String ARQUIVO_DADOS = "pessoas.txt"; 

    // O método 'main' é a porta de entrada de qualquer programa Java. É aqui que a execução começa
    public static void main(String[] args) { // Assinatura padrão obrigatória do Java
        
        carregarDados(); // Antes de mostrar o menu, o sistema vai ao arquivo txt tentar ler os dados salvos anteriormente
        
        Scanner scanner = new Scanner(System.in); // Instancia o Scanner associando-o ao teclado (System.in)
        int opcao = 0; // Variável inteira para guardar o número da opção que o usuário escolher no menu

        // Início do loop principal do programa. Continua rodando até o usuário escolher a opção 5 (Sair)
        while (opcao != 5) { // Avalia se a variável opcao é diferente de 5
            
            MenuReader.exibirMenu(); // Chama a classe utilitária (estática) para ler e imprimir o menu a partir do menu.txt
            
            // Validação de entrada: Verifica se o usuário digitou um número inteiro, evitando falha (crash) do sistema
            if (scanner.hasNextInt()) { // Se a próxima entrada no teclado for um número inteiro
                opcao = scanner.nextInt(); // Guarda o número digitado na variável 'opcao'
                scanner.nextLine(); // "Limpa" o Enter (quebra de linha) que fica sobrando no buffer do teclado após o número
                
                // Estrutura de decisão (switch) para direcionar o programa dependendo da escolha do usuário
                switch (opcao) { // Avalia o valor da variável 'opcao'
                    case 1: // Caso o usuário tenha digitado 1
                        cadastrarPessoa(scanner); // Chama o método de Inclusão, passando o scanner para ler os dados
                        break; // Termina a execução do caso 1 e volta para o início do loop while
                    case 2: // Caso o usuário tenha digitado 2
                        listarPessoas(); // Chama o método de Consulta, que imprime tudo na tela
                        break; // Termina a execução do caso 2
                    case 3: // Caso o usuário tenha digitado 3
                        atualizarPessoa(scanner); // Chama o método de Alteração para modificar uma pessoa existente
                        break; // Termina a execução do caso 3
                    case 4: // Caso o usuário tenha digitado 4
                        excluirPessoa(scanner); // Chama o método de Exclusão para apagar um registro
                        break; // Termina a execução do caso 4
                    case 5: // Caso o usuário tenha digitado 5
                        System.out.println("Encerrando o sistema..."); // Imprime a mensagem de despedida
                        break; // Termina a execução do caso 5 (fazendo o loop while terminar logo em seguida)
                    default: // Caso tenha digitado um número que não é de 1 a 5 (ex: 9)
                        System.out.println("Opção inválida! Escolha um número de 1 a 5."); // Mensagem de erro de navegação
                } // Fim do bloco switch
            } else { // Caso o usuário não tenha digitado um número (ex: digitou letras)
                System.out.println("Erro: Por favor, digite apenas números válidos."); // Alerta o usuário do erro de tipo
                scanner.next(); // Descarta a palavra inválida do buffer do teclado para não criar um loop infinito
            } // Fim do bloco if-else
        } // Fim do loop while
        
        scanner.close(); // Fecha o objeto scanner para liberar a memória e os recursos do sistema operacional
    } // Fim do método main

    // =========================================================================
    // MÉTODOS CRUD (Create, Read, Update, Delete)
    // =========================================================================

    // Método para Inclusão de uma nova Pessoa
    private static void cadastrarPessoa(Scanner scanner) { // Assinatura do método privado que recebe o scanner
        System.out.print("Digite o código da pessoa: "); // Solicita o código
        int codigo = scanner.nextInt(); // Captura o número digitado
        scanner.nextLine(); // Limpa o buffer do teclado

        // Validação da Chave Primária: Garante que não existirão duas pessoas com o mesmo código
        for (Pessoa p : listaPessoas) { // Inicia um loop for-each passando por cada objeto Pessoa na lista em memória
            if (p.getCodigo() == codigo) { // Se o código da pessoa que está na memória for igual ao código recém-digitado
                System.out.println("Erro: Inconsistência de chave! Já existe uma pessoa com este código."); // Exibe a mensagem de erro
                return; // O comando 'return' aborta a execução do método imediatamente, cancelando o cadastro
            } // Fim do if
        } // Fim do loop for

        System.out.print("Digite o nome da pessoa: "); // Solicita o nome
        String nome = scanner.nextLine(); // Lê a linha completa (permitindo capturar nomes compostos com espaços)

        // Menu simples para escolher o tipo de pessoa usando números para facilitar a vida do usuário
        System.out.println("Tipo de Pessoa: 1-CLIENTE, 2-FORNECEDOR, 3-AMBOS"); // Mostra as opções
        System.out.print("Escolha o número do tipo: "); // Solicita a escolha
        int opTipo = scanner.nextInt(); // Captura a escolha (1, 2 ou 3)
        scanner.nextLine(); // Limpa o buffer do teclado
        
        // Estrutura if/else clássica (Aula 04) para transformar a escolha numérica no texto correto
        String tipoPessoa = "CLIENTE"; // Define o texto "CLIENTE" como valor inicial e padrão (fallback)
        if (opTipo == 2) { // Verifica se o usuário escolheu a opção 2
            tipoPessoa = "FORNECEDOR"; // Substitui a string pela palavra "FORNECEDOR"
        } else if (opTipo == 3) { // Verifica se o usuário escolheu a opção 3
            tipoPessoa = "AMBOS"; // Substitui a string pela palavra "AMBOS"
        } // Fim da estrutura if-else de validação de tipo de pessoa

        // Com os 3 dados prontos, instanciamos (criamos) o objeto novaPessoa usando a classe Pessoa
        Pessoa novaPessoa = new Pessoa(codigo, nome, tipoPessoa); 

        // Lógica de Composição: Perguntamos se deseja amarrar um objeto Endereço ao objeto Pessoa recém-criado
        System.out.print("Deseja adicionar um endereço agora? (S/N): "); // Imprime a pergunta
        String querEndereco = scanner.nextLine(); // Captura a resposta do usuário ("S" ou "N")

        // Inicia um loop que permite cadastrar vários endereços. Executa enquanto a resposta for "S" (ignorando maiúsculas)
        while (querEndereco.equalsIgnoreCase("S")) { 
            System.out.print("CEP: "); // Pede o CEP
            String cep = scanner.nextLine(); // Guarda o texto do CEP
            System.out.print("Logradouro (Rua/Av): "); // Pede a Rua
            String logradouro = scanner.nextLine(); // Guarda o texto da Rua
            System.out.print("Número: "); // Pede o número da residência
            String numero = scanner.nextLine(); // Guarda o número como texto
            System.out.print("Complemento: "); // Pede detalhes extras
            String complemento = scanner.nextLine(); // Guarda o complemento
            
            // Menu numérico para facilitar a escolha do tipo de endereço
            System.out.println("Tipo Endereço: 1-COMERCIAL, 2-RESIDENCIAL, 3-ENTREGA, 4-CORRESPONDENCIA"); // Opções baseadas no PDF
            System.out.print("Escolha o número: "); // Pede para digitar
            int opEnd = scanner.nextInt(); // Lê a opção (1, 2, 3 ou 4)
            scanner.nextLine(); // Limpa o buffer do teclado

            // Outra estrutura if/else para mapear número para texto (Aula 04 e 05)
            String tipoEnd = "RESIDENCIAL"; // Define um valor textual padrão
            if (opEnd == 1) { // Se escolheu 1
                tipoEnd = "COMERCIAL"; // A string vira "COMERCIAL"
            } else if (opEnd == 3) { // Se escolheu 3
                tipoEnd = "ENTREGA"; // A string vira "ENTREGA"
            } else if (opEnd == 4) { // Se escolheu 4
                tipoEnd = "CORRESPONDENCIA"; // A string vira "CORRESPONDENCIA"
            } // Fim da validação textual do endereço

            // Com todos os dados prontos, instanciamos (criamos) o objeto de Endereço em memória
            Endereco end = new End