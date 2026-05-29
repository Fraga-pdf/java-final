// Importações necessárias para utilizar listas dinâmicas no Java
import java.util.ArrayList; // Importa a implementação da lista
import java.util.List; // Importa a interface da lista

// Classe Pessoa que HERDA (Herança) da nossa classe abstrata EntidadeBase. 
public class Pessoa extends EntidadeBase { // 'extends' indica a herança
    
    // Atributos privados garantindo o princípio do ENCAPSULAMENTO
    private String nome; // Atributo para armazenar o nome da pessoa
    private String tipoPessoa; // Atributo em texto para guardar o tipo (Cliente, Fornecedor, etc)
    private List<Endereco> enderecos; // Composição: lista de múltiplos objetos do tipo Endereco

    // Construtor da classe Pessoa
    public Pessoa(int codigo, String nome, String tipoPessoa) { // Assinatura 
        super(codigo); // Chama o construtor da classe pai (EntidadeBase) para inicializar o 'codigo'
        this.nome = nome; // Atribui o nome
        this.tipoPessoa = tipoPessoa; // Atribui o tipo de pessoa
        this.enderecos = new ArrayList<>(); // Inicializa a lista de endereços vazia
    } // Fecha o construtor

    // =========================================================================
    // MÉTODOS GETTERS (Garantem o pilar do ENCAPSULAMENTO - Aula 10)
    // O getCodigo() não está aqui porque já foi herdado da EntidadeBase!
    // =========================================================================

    public String getNome() { // Método público para ler o nome de fora da classe
        return nome; // Retorna o valor do nome
    } // Fecha método

    public String getTipoPessoa() { // Método público para ler o tipo da pessoa
        return tipoPessoa; // Retorna o tipo de pessoa
    } // Fecha método

    // =========================================================================

    // Método público para adicionar um novo endereço na lista
    public void adicionarEndereco(Endereco endereco) { // Recebe o objeto endereço
        this.enderecos.add(endereco); // Guarda o endereço na lista interna
    } // Fecha o método

    // Método Getter para acessar a lista de endereços
    public List<Endereco> getEnderecos() { // Assinatura
        return enderecos; // Retorna a lista de endereços
    } // Fecha o método

    // Sobrescrita do método toString (POLIMORFISMO)
    @Override // Anotação de sobrescrita
    public String toString() { // Assinatura do método
        // Retorna a string formatada para exibição na tela
        return "Código: " + codigo + " | Nome: " + nome + " | Tipo: " + tipoPessoa; 
    } // Fecha o método

    // Implementação obrigatória do método abstrato da classe pai
    @Override // Anotação de sobrescrita (Polimorfismo)
    public String toTxtLine() { // Assinatura do método
        // Concatenação simples e clássica aprovada para o nível da disciplina
        String base = codigo + ";" + nome + ";" + tipoPessoa; 
        
        // Loop que passa por todos os endereços da pessoa
        for (Endereco end : enderecos) { // Para cada endereço
            // Adiciona o delimitador e a versão em texto do endereço
            base += "|" + end.toTxtLine(); 
        } // Fecha o loop
        
        return base; // Retorna a linha completa
    } // Fecha o método
    
} // Fecha a classe Pessoa
