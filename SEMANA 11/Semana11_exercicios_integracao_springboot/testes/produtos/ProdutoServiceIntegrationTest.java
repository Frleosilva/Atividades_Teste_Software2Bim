package produtos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest @Transactional
class ProdutoServiceIntegrationTest {
 @Autowired ProdutoService service;
 @Autowired ProdutoRepository repository;
 @Autowired jakarta.persistence.EntityManager em;
 @Test void deveCadastrarERecuperarProduto(){var p=service.cadastrar("Teclado",150);assertNotNull(p.getId());repository.flush();em.clear();var salvo=repository.findById(p.getId()).orElseThrow();assertEquals("Teclado",salvo.getNome());assertEquals(150,salvo.getPreco());}
 @Test void naoDevePersistirProdutoComNomeEmBranco(){long n=repository.count();assertThrows(IllegalArgumentException.class,()->service.cadastrar("  ",80));assertEquals(n,repository.count());}
 @Test void deveAtualizarPrecoPersistido(){var p=service.cadastrar("Mouse",80);service.atualizarPreco(p.getId(),95);repository.flush();em.clear();assertEquals(95,repository.findById(p.getId()).orElseThrow().getPreco());}
 @Test void buscarExistente(){var p=service.cadastrar("Mouse",80);assertEquals(p.getId(),service.buscar(p.getId()).getId());}
 @Test void buscarInexistente(){assertThrows(IllegalArgumentException.class,()->service.buscar(-1L));}
 @Test void remover(){var p=service.cadastrar("Mouse",80);service.remover(p.getId());repository.flush();em.clear();assertFalse(repository.existsById(p.getId()));}
}
