package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.model.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NovoPedidoRequest {
    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    private String descricao;

    public Pedido toPedido(User user) {
        var p =  new Pedido();
        p.setNomeProduto(nomeProduto);
        p.setUrlProduto(urlProduto);
        p.setUrlImagem(urlImagem);
        p.setDescricao(descricao);
        p.setStatus(StatusPedido.AGUARDANDO);
        p.setUser(user);
        return p;
    }
}
