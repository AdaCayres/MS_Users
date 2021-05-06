package br.com.ada.livraria.MS_Users.Controller;

import br.com.ada.livraria.MS_Users.Model.User;
import br.com.ada.livraria.MS_Users.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User exibirUsuario(@PathVariable long id){
        return userService.getById(id);

    }

    @GetMapping
    public List<User> exibirTodos(){
        return userService.listALL();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User add(@RequestBody User user) {
        return userService.addNew(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody User user, @PathVariable long id){
        return userService.updateById(user, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.deleteById(id);
    }
}
