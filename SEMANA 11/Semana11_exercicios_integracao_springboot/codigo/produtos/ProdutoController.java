package produtos;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/produtos")
public class ProdutoController {
 private final ProdutoService service;
 public ProdutoController(ProdutoService service){this.service=service;}
 @PostMapping public Produto cadastrar(@RequestBody ProdutoRequest request){return service.cadastrar(request.nome(),request.preco());}
 @GetMapping("/{id}") public Produto buscar(@PathVariable Long id){return service.buscar(id);}
}
