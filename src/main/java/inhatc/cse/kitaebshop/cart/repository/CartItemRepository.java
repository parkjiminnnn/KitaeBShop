package inhatc.cse.kitaebshop.cart.repository;

import inhatc.cse.kitaebshop.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
