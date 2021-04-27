package br.com.ada.livraria.MS_Users.Controller;

import br.com.ada.livraria.MS_Users.Model.UserTypes.Usuario;
import br.com.ada.livraria.MS_Users.Model.UserTypes.Vendedor;
import br.com.ada.livraria.MS_Users.Model.UserTypes.Adiministrador;
import br.com.ada.livraria.MS_Users.Repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public Usuario exibir(@PathVariable long id,Usuario requerente){
        //fazer log
        log.info("["+ System.nanoTime() +"] Usuario " + requerente.getId() + " procurou pelo usuário " + id + "no banco de dados.");
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(!usuario.isPresent()) return null;
        return usuario.get();

    }

    @PostMapping
    public Usuario adicionar(@RequestBody Usuario usuario, String tipo, Usuario requerente){
        if(requerente instanceof Vendedor){
            log.info("["+ System.nanoTime() +"] Usuario " + requerente.getId() + " tentou criar um usuario, porém não tem as permissões necessárias");
            return null;
        }
        if(Usuario.getNumeroDeUsuarios() == 0){
            Adiministrador adiministrador =(Adiministrador) usuario;
            log.info("["+ System.nanoTime() +"Primeiro usuario criado");
            return usuarioRepository.save(adiministrador);
        }else if(tipo.toLowerCase(Locale.ROOT) == "administrador"){
            log.info("["+ System.nanoTime() +"] Usuario " + requerente.getId() + " criou um usuario de tipo administrador");
            Adiministrador adiministrador =(Adiministrador) usuario;
            return usuarioRepository.save(adiministrador);
        }else{
            Vendedor vendedor= (Vendedor) usuario;
            log.info("["+ System.nanoTime() +"] Usuario " + requerente.getId() + " criou um usuario de tipo vendedor");
            return usuarioRepository.save(vendedor);
        }
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateUsuario(@RequestBody Usuario usuario, @PathVariable long id, Usuario requerente){
        if(requerente instanceof Vendedor) return ResponseEntity.badRequest().build();
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(!usuarioOptional.isPresent()) return ResponseEntity.notFound().build();
        usuario.setId(id);
        usuarioRepository.save(usuario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id, Usuario requerente){
        if(requerente instanceof Vendedor) return;
        usuarioRepository.deleteById(id);
    }
}
