package ru.example.mvcdocker.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.mvcdocker.entity.UserEntity;

@Repository
public interface UserEnityRepo extends JpaRepository<UserEntity , Integer > {
}
