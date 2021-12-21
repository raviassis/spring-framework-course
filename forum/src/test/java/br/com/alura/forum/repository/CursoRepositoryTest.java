package br.com.alura.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Test
    public void deveriaCarregarUmCursoAoBuscarPeloNome() {
        var nomeCurso = "HTML 5";
        var curso = repository.findByNome(nomeCurso);
        Assertions.assertNotNull(curso);
        Assertions.assertEquals(nomeCurso, curso.getNome());
    }
    @Test
    public void naoDeveriaCarregarUmCursoCujoNomeNaoEstejaCadastrado() {
        var nomeCurso = "JPA";
        var curso = repository.findByNome(nomeCurso);
        Assertions.assertNull(curso);
    }

}
