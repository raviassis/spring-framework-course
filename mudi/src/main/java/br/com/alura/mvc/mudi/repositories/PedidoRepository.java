package br.com.alura.mvc.mudi.repositories;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(StatusPedido aguardando, Pageable page);

    List<Pedido> findByUser_Username(String username);

    List<Pedido> findByStatusAndUser_Username(StatusPedido aguardando, String username);
}
