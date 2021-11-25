package br.com.alura.forum.controllers.dto;

import br.com.alura.forum.modelo.Resposta;
import lombok.Getter;

import java.time.LocalDateTime;

public class RespostaDto {
    @Getter
    private Long id;
    @Getter
    private String mensagem;
    @Getter
    private LocalDateTime dataCricacao;
    @Getter
    private String nomeAutor;

    public RespostaDto(Resposta resposta) {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCricacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }

}
