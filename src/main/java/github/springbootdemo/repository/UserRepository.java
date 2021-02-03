package github.springbootdemo.repository;

import github.springbootdemo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("from User u where u.name=:name")
    List<User> findUserByName(@Param("name") String name);
}
