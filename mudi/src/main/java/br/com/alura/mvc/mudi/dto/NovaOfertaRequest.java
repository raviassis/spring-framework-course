package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Oferta;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class NovaOfertaRequest {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Long pedidoId;
    private String valor;
    private String dataDaEntrega;
    private String comentario;

    public Oferta toOferta() {
        var oferta = new Oferta();
        oferta.setComentario(this.comentario);
        oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, formatter));
        oferta.setValor(new BigDecimal(this.valor));
        return oferta;
    }
}
