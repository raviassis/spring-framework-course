package br.com.alura.mvc.mudi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;
}
