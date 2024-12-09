package services.customer_services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.codec.CodecConfigurer.CustomCodecs;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByUserName(String username);
}

