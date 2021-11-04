package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.NovoPedidoRequest;
import br.com.alura.mvc.mudi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public ModelAndView formulario() {
        return new ModelAndView("pedido/formulario").addObject(new NovoPedidoRequest());
    }

    @PostMapping("novo")
    public String novo(@Valid NovoPedidoRequest novoPedidoRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        }
        var pedido = novoPedidoRequest.toPedido();
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
