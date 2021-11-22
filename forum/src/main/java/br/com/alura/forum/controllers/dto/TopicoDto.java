package br.com.alura.forum.controllers.dto;

import br.com.alura.forum.modelo.Topico;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto {
    @Getter
    private Long id;
    @Getter
    private String titulo;
    @Getter
    private String mensagem;
    @Getter
    private LocalDateTime dataCriacao;

    public TopicoDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public static List<TopicoDto> converter(List<Topico> topicos) {
        return topicos
                .stream()
                .map(TopicoDto::new)
                .collect(Collectors.toList());
    }
}
