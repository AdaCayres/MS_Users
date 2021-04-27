package br.com.ada.livraria.MS_Users.Repository;

import br.com.ada.livraria.MS_Users.Model.UserTypes.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
