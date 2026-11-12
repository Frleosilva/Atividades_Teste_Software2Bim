package carrinho;

public class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        // Decisão para preço negativo: rejeitar com exceção. Confirmar com o professor.
        if (preco < 0) throw new IllegalArgumentException("Preço negativo");
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
