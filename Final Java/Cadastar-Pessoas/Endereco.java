// Classe Endereco representa a estrutura de dados de um endereço no sistema
public class Endereco { // Declara a classe pública Endereco
    
    // Aplicação do princípio de ENCAPSULAMENTO: atributos privados
    private String cep; // Atributo privado para armazenar o CEP 
    private String logradouro; // Atributo privado para o nome da rua, avenida, praça
    private String numero; // Atributo privado para o número da residência
    private String complemento; // Atributo privado para detalhes adicionais
    private String tipo; // Atributo privado em formato de texto para armazenar o tipo do endereço

    // Construtor da classe: método especial chamado automaticamente ao instanciar o objeto
    public Endereco(String cep, String logradouro, String numero, String complemento, String tipo) { // Assinatura
        this.cep = cep; // Atribui o CEP
        this.logradouro = logradouro; // Atribui o logradouro
        this.numero = numero; // Atribui o número
        this.complemento = complemento; // Atribui o complemento
        this.tipo = tipo; // Atribui o texto do tipo de endereço
    } // Fecha o construtor

    // =========================================================================
    // MÉTODOS GETTERS (Garantem o pilar do ENCAPSULAMENTO - Aula 10)
    // =========================================================================
    
    public String getCep() { // Método público para acessar o CEP
        return cep; // Retorna o CEP
    } // Fecha método

    public String getLogradouro() { // Método público para acessar o logradouro
        return logradouro; // Retorna o logradouro
    } // Fecha método

    public String getNumero() { // Método público para acessar o número
        return numero; // Retorna o número
    } // Fecha método

    public String getComplemento() { // Método público para acessar o complemento
        return complemento; // Retorna o complemento
    } // Fecha método

    public String getTipo() { // Método público para acessar o tipo de endereço
        return tipo; // Retorna o tipo
    } // Fecha método

    // =========================================================================

    // Sobrescrita do método toString (POLIMORFISMO).
    @Override // Anotação do Java para indicar a sobrescrita
    public String toString() { // Assinatura do método
        // Retorna o endereço formatado de forma amigável para o console
        return tipo + ": " + logradouro + ", " + numero + " - " + complemento + " (" + cep + ")"; 
    } // Fecha o método toString

    // Método específico para formatar os dados do endereço para o arquivo TXT
    public String toTxtLine() { // Assinatura do método público
        // Concatena todos os atributos separados por ponto e vírgula (;) usando a forma ensinada em aula
        return cep + ";" + logradouro + ";" + numero + ";" + complemento + ";" + tipo; 
    } // Fecha o método toTxtLine
    
} // Fecha a classe Endereco
