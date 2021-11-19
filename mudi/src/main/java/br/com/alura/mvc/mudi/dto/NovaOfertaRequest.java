package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Oferta;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class NovaOfertaRequest {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Long pedidoId;

    @Pattern(regexp = "^\\d+(\\.\\d{2})?$")
    @NotNull
    private String valor;

    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
    @NotNull
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
