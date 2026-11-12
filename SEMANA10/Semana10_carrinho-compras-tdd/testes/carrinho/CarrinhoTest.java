package carrinho;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CarrinhoTest {
@Test void vazio(){assertEquals(0,new Carrinho().getTotal());}
@Test void um(){Carrinho c=new Carrinho();c.adicionar(new Produto("Teclado",100));assertEquals(100,c.getTotal());}
@Test void varios(){Carrinho c=new Carrinho();c.adicionar(new Produto("Teclado",100));c.adicionar(new Produto("Mouse",50));assertEquals(150,c.getTotal());}
@Test void remover(){Carrinho c=new Carrinho();Produto p=new Produto("Mouse",50);c.adicionar(new Produto("Teclado",100));c.adicionar(p);c.remover(p);assertEquals(100,c.getTotal());}
@Test void negativo(){assertThrows(IllegalArgumentException.class,()->new Produto("X",-100));}
@Test void desconto(){for(double x:new double[]{499.99,500,500.01,600}){Carrinho c=new Carrinho();c.adicionar(new Produto("X",x));assertEquals(x<500?x:x*.9,c.getTotal(),.000001);}}

}