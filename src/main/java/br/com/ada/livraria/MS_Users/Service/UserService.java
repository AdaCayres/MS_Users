package br.com.ada.livraria.MS_Users.Service;

import br.com.ada.livraria.MS_Users.Exception.UserNotFoundException;
import br.com.ada.livraria.MS_Users.Model.User;
import br.com.ada.livraria.MS_Users.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User addNew(User user){
        log.info("["+ System.nanoTime() +"] User added an id to the DB.");
        return userRepository.save(user);

    }
    public User getById(long id){
        log.info("["+ System.nanoTime() +"] User looked for id " + id + " in the DB.");
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) throw new UserNotFoundException("id- " + id);
        return user.get();
    }

    public ResponseEntity<Object> updateById(User user, long id){
        log.info("["+ System.nanoTime() +"] User modified id " + id + " in the DB.");
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()) return ResponseEntity.notFound().build();
        user.setId(id);
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

    public void deleteById(long id){
        Optional<User> user = userRepository.findById(id);
        userRepository.deleteById(id);
        if(user.isEmpty()) throw new UserNotFoundException("");
        log.info("["+ System.nanoTime() +"] User deleted id " + id + " in the DB.");
    }

    public List<User> listALL() {
        log.info("["+ System.nanoTime() + "] Exhibiting all ids  in the DB.");
        return userRepository.findAll();
    }
}
