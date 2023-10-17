package ru.example.mvcdocker.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.mvcdocker.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
