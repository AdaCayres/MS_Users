package br.com.ada.livraria.MS_Users.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "usuarios")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nickname",length = 20)
    private String nickname;
    @Column(name = "tipo",length = 20)
    private String type;
    @Column(name = "nome",length = 20)
    private String name;
    @Column(name = "senha", length = 20, nullable = false)
    private String password;

}