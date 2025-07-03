@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final List<Produto> produtos = List.of(
        new Produto(1L, "Teclado", 120.0),
        new Produto(2L, "Mouse", 80.0)
    );

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtos;
    }

    @GetMapping("/{id}")
    public Produto getProduto(@PathVariable Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
