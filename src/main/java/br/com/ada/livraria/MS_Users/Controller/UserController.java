package br.com.ada.livraria.MS_Users.Controller;

import br.com.ada.livraria.MS_Users.Model.Usuario;
import br.com.ada.livraria.MS_Users.Repository.UserRepository;
import br.com.ada.livraria.MS_Users.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public Usuario exibir(@PathVariable long id){
        return userService.getById(id);

    }

    @PostMapping
    public Usuario add(@RequestBody Usuario usuario){
        log.info("["+ System.nanoTime() +"] Usuario procurou adicionou um id no banco de dados");
        return userRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody Usuario usuario, @PathVariable long id){

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.deleteById(id);
    }
}
