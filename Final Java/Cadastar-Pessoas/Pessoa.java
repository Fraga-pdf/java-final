// Importações necessárias para utilizar listas dinâmicas no Java (conforme Aula 08)
import java.util.ArrayList; // Importa a classe concreta ArrayList, que é uma lista que cresce de tamanho automaticamente
import java.util.List; // Importa a interface genérica List (aplicando o conceito de Abstração nas coleções)

// Classe Pessoa que HERDA (Herança) da nossa classe abstrata EntidadeBase. Representa o Cadastro de Pessoas.
public class Pessoa extends EntidadeBase { // 'extends' é a palavra-chave que indica a herança em Java
    
    // Atributos privados garantindo o princípio do ENCAPSULAMENTO
    private String nome; // Atributo para armazenar o nome da pessoa
    private String tipoPessoa; // Atributo em texto (String) para guardar se é Cliente, Fornecedor ou Ambos (Substituiu o Enum)
    private List<Endereco> enderecos; // Composição: uma lista que guardará múltiplos objetos do tipo Endereco

    // Construtor da classe Pessoa: método chamado toda vez que fazemos 'new Pessoa(...)'
    public Pessoa(int codigo, String nome, String tipoPessoa) { // Assinatura atualizada recebendo String para o tipoPessoa
        super(codigo); // Chama o construtor da classe pai (EntidadeBase) para repassar e inicializar o atributo 'codigo'
        this.nome = nome; // Atribui o nome recebido ao atributo da classe
        this.tipoPessoa = tipoPessoa; // Atribui o tipo de pessoa recebido ao atributo da classe (Ex: "CLIENTE")
        this.enderecos = new ArrayList<>(); // Inicializa a lista de endereços como vazia no momento da criação da pessoa
    } // Fecha o construtor

    // Método público para adicionar um novo endereço na lista desta pessoa
    public void adicionarEndereco(Endereco endereco) { // Recebe um objeto Endereco pronto como parâmetro
        this.enderecos.add(endereco); // Utiliza o método 'add' do ArrayList para guardar o endereço na lista interna
    } // Fecha o método adicionarEndereco

    // Método Getter para acessar a lista de endereços de forma segura (Encapsulamento)
    public List<Endereco> getEnderecos() { // Assinatura do método que retorna a lista
        return enderecos; // Retorna a lista atual de endereços
    } // Fecha o método getEnderecos

    // Sobrescrita do método toString (POLIMORFISMO) para exibir os dados da Pessoa de forma estruturada no console
    @Override // Anotação que garante que estamos substituindo o comportamento padrão do Java
    public String toString() { // Assinatura do método
        // Retorna uma string formatada contendo o código (herdado do pai), o nome e o tipo em formato de texto
        return "Código: " + codigo + " | Nome: " + nome + " | Tipo: " + tipoPessoa; 
    } // Fecha o método toString

    // Implementação obrigatória do método abstrato exigido pela classe pai (EntidadeBase)
    @Override // Anotação de sobrescrita (Polimorfismo puro)
    public String toTxtLine() { // Assinatura do método que diz como essa pessoa deve virar uma linha de texto no TXT
        // Cria a string base juntando código, nome e o tipo (agora String direta, sem .name()), separados por ponto e vírgula
        String base = codigo + ";" + nome + ";" + tipoPessoa; 
        
        // Inicia um loop (for-each) iterando sobre todos os endereços que essa pessoa tem na lista
        for (Endereco end : enderecos) { // Para cada 'end' do tipo Endereco dentro da lista 'enderecos'
            // Concatena os dados do endereço à string da pessoa, separando com o caractere "pipe" (|)
            base += "|" + end.toTxtLine(); 
        } // Fecha o loop
        
        return base; // Retorna a linha completa, com os dados da pessoa e de todos os seus endereços, pronta para salvar no txt
    } // Fecha o método toTxtLine
    
} // Fecha a classe Pessoa