package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.dto.NovaOfertaRequest;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criaOferta(
        @Valid @RequestBody NovaOfertaRequest request
    ){
        var pedido = pedidoRepository.findById(request.getPedidoId())
                                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Oferta oferta = request.toOferta();
        oferta.setPedido(pedido);
        pedido.getOfertas().add(oferta);
        pedidoRepository.save(pedido);
        return oferta;
    }
}
