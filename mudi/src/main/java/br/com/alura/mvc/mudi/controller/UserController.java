package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/pedido")
    public ModelAndView home(Principal principal) {
        var pedidos = pedidoRepository.findByUser_Username(principal.getName());
        return new ModelAndView("home")
                .addObject("pedidos", pedidos);
    }

    @GetMapping("/pedido/{status}")
    public ModelAndView porStatus(@PathVariable("status") String status, Principal principal) {
        var pedidos = pedidoRepository.findByStatusAndUser_Username(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
        return new ModelAndView("home")
                .addObject("pedidos", pedidos)
                .addObject("status", status);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/usuario/home";
    }
}
