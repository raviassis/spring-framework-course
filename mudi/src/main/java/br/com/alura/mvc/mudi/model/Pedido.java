package br.com.alura.mvc.mudi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private BigDecimal valorNegociado;
    private LocalDate dataDaEntrega;
    private String urlProduto;
    private String urlImagem;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
