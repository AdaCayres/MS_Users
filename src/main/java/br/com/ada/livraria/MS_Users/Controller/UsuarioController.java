package br.com.ada.livraria.MS_Users.Controller;

import br.com.ada.livraria.MS_Users.Model.UserTypes.Usuario;
import br.com.ada.livraria.MS_Users.Repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public Usuario exibir(@PathVariable long id){
        //fazer log
        log.info("["+ System.nanoTime() +"] Usuario procurou pelo id" + id + "no banco de dados.");
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(!usuario.isPresent()) return null;
        return usuario.get();

    }

    @PostMapping
    public Usuario adicionar(@RequestBody Usuario usuario){
        log.info("["+ System.nanoTime() +"] Usuario procurou adicionou um id no banco de dados");
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuario(@RequestBody Usuario usuario, @PathVariable long id){
        log.info("["+ System.nanoTime() +"] Usuario procurou modificou o id " + id + "no banco de dados.");
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(!usuarioOptional.isPresent()) return ResponseEntity.notFound().build();
        usuario.setId(id);
        usuarioRepository.save(usuario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        usuarioRepository.deleteById(id);
        log.info("["+ System.nanoTime() +"] Usuario deletou o id " + id + "do banco de dados.");
    }
}
