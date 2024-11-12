package inhatc.cse.kitaebshop.order.repository;

import inhatc.cse.kitaebshop.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
