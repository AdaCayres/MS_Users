package br.com.ada.livraria.MS_Users.Model.UserTypes;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nickname;
    private String tipo;
    private String nome;
    @Column(nullable = false)
    private String senha;
    private static long numeroDeUsuarios = 0;



