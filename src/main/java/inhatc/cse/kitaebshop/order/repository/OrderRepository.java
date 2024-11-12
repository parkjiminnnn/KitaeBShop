package inhatc.cse.kitaebshop.order.repository;

import inhatc.cse.kitaebshop.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
