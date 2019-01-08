package ua.test.spring_boot.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.test.spring_boot.Models.User;

public interface UserDao extends JpaRepository<User,Integer> {
}
