package inhatc.cse.kitaebshop.cart.repository;

import inhatc.cse.kitaebshop.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
