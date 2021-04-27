package br.com.ada.livraria.MS_Users.Model.UserTypes;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public
class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nickname;
    private String nome;
    @Column(nullable = false)
    private String senha;
    private static long numeroDeUsuarios = 0;


    Usuario(String nick, String nome, String senha) {
        setNickname(nick);
        setNome(nome);
        setSenha(senha);
    }


    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNome() {
        return nome;
    }

    private String getSenha() {
        return senha;
    }

    public static long getNumeroDeUsuarios(){
        return numeroDeUsuarios;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private void setSenha(String senha) {
        this.senha = senha;
    }

    public static void setNumeroDeUsuarios(long numeroDeUsuarios) {
        Usuario.numeroDeUsuarios = numeroDeUsuarios;
    }
}
