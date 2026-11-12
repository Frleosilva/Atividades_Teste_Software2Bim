package carrinho;
import java.util.ArrayList;
import java.util.List;
public class Carrinho {
    private final List<Produto> produtos = new ArrayList<>();
    public void adicionar(Produto produto) { produtos.add(produto); }
    public void remover(Produto produto) { produtos.remove(produto); }
    public double getTotal() {
        double total = produtos.stream().mapToDouble(Produto::getPreco).sum();
        return total >= 500 ? total * 0.9 : total;
    }
}
