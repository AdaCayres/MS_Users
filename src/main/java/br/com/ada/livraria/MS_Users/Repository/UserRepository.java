package br.com.ada.livraria.MS_Users.Repository;

import br.com.ada.livraria.MS_Users.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
