@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final RestTemplate restTemplate;

    public PedidoController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody List<Long> idsProdutos) {
        double total = 0.0;
        for (Long id : idsProdutos) {
            Produto produto = restTemplate.getForObject("http://produto-service/produtos/" + id, Produto.class);
            total += produto.getPreco();
        }

        Pedido pedido = new Pedido();
        pedido.setId(System.currentTimeMillis());
        pedido.setProdutos(idsProdutos);
        pedido.setTotal(total);

        return pedido;
    }
}
