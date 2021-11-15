package br.com.alura.mvc.mudi.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private LocalDate dataDaEntrega;
    private String comentario;
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;
}
