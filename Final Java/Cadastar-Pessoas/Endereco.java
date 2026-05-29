// Classe Endereco representa a estrutura de dados de um endereço no sistema
public class Endereco { // Declara a classe pública Endereco para poder ser instanciada em outros arquivos
    
    // Aplicação do princípio de ENCAPSULAMENTO: atributos privados não podem ser alterados diretamente de fora
    private String cep; // Atributo privado para armazenar o CEP em formato de texto
    private String logradouro; // Atributo privado para o nome da rua, avenida, praça, etc.
    private String numero; // Atributo privado para o número da residência ou prédio
    private String complemento; // Atributo privado para detalhes adicionais (apto, bloco, casa 2)
    private String tipo; // Atributo privado em formato de texto (String) para armazenar o tipo do endereço (Substituiu o Enum)

    // Construtor da classe: método especial chamado automaticamente quando fazemos um 'new Endereco(...)'
    public Endereco(String cep, String logradouro, String numero, String complemento, String tipo) { // Assinatura agora recebe String no tipo
        this.cep = cep; // O atributo 'cep' do objeto recebe o valor 'cep' passado como parâmetro
        this.logradouro = logradouro; // Atribui o logradouro recebido ao atributo da classe
        this.numero = numero; // Atribui o número recebido ao atributo da classe
        this.complemento = complemento; // Atribui o complemento recebido ao atributo da classe
        this.tipo = tipo; // Atribui o texto recebido (ex: "RESIDENCIAL") ao atributo da classe
    } // Fecha o construtor

    // Sobrescrita do método toString (POLIMORFISMO). Todo objeto em Java tem um toString padrão, aqui nós mudamos o comportamento dele.
    @Override // Anotação do Java para indicar e garantir que estamos sobrescrevendo um método válido da classe mãe (Object)
    public String toString() { // Assinatura do método que será chamado quando mandarmos imprimir o objeto na tela
        // Retorna o endereço formatado de forma amigável para o usuário ler no console
        return tipo + ": " + logradouro + ", " + numero + " - " + complemento + " (" + cep + ")"; 
    } // Fecha o método toString

    // Método específico para formatar os dados do endereço em uma única "linha" (String) delimitada para salvar no arquivo TXT
    public String toTxtLine() { // Assinatura do método público
        // Concatena todos os atributos separados por ponto e vírgula (;). Como o tipo agora é texto simples, concatenamos direto.
        return cep + ";" + logradouro + ";" + numero + ";" + complemento + ";" + tipo; 
    } // Fecha o método toTxtLine
    
} // Fecha a classe Endereco