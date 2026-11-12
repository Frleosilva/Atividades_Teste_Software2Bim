package pedidos;
import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class LimiteTest { @Test void estoqueExato(){EstoqueService e=new EstoqueService(3);PedidoService p=new PedidoService(e);assertTrue(p.realizarPedido(3));assertEquals(0,e.getQuantidade());} }
