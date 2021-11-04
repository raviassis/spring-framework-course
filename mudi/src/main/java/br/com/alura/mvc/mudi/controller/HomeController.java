package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repositories.PedidoRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ModelAndView home() {
        var pedidos = pedidoRepository.findAll();
        return new ModelAndView("home")
                    .addObject("pedidos", pedidos);
    }

    @GetMapping("{status}")
    public ModelAndView porStatus(@PathVariable("status") String status) {
        var pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        return new ModelAndView("home")
                .addObject("pedidos", pedidos)
                .addObject("status", status);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}
