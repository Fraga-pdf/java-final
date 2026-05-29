// Classe abstrata EntidadeBase: Aplica os conceitos de ABSTRAÇÃO e HERANÇA exigidos no projeto
public abstract class EntidadeBase { // Define uma classe pública que não pode ser instanciada diretamente (abstrata)
    protected int codigo; // Atributo 'protected' (Encapsulamento): invisível para fora, mas acessível para as classes filhas
    
    // Construtor da classe base que obriga as classes filhas a fornecerem um código no momento da criação
    public EntidadeBase(int codigo) { // Assinatura do construtor recebendo o valor do código
        this.codigo = codigo; // O atributo 'codigo' da classe recebe o valor que foi passado como parâmetro
    } // Fecha o construtor da entidade base

    // Método público (Getter) para acessar o código de forma segura, sem permitir que seja alterado diretamente
    public int getCodigo() { // Assinatura do método que retorna um número inteiro
        return codigo; // Retorna o valor armazenado no atributo código
    } // Fecha o método getCodigo

    // Aplica o conceito de POLIMORFISMO: obriga todas as classes filhas a criarem a sua própria versão deste método
    public abstract String toTxtLine(); // Assinatura de um método abstrato (sem corpo) que retornará os dados formatados para salvar no TXT
} // Fecha a classe abstrata EntidadeBase