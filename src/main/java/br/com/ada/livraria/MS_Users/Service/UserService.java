package br.com.ada.livraria.MS_Users.Service;

import br.com.ada.livraria.MS_Users.Model.Usuario;
import br.com.ada.livraria.MS_Users.Repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario getbyId(long id){
        log.info("["+ System.nanoTime() +"] Usuario procurou pelo id" + id + "no banco de dados.");
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(!usuario.isPresent()) return null;
        return usuario.get();
    }


}
