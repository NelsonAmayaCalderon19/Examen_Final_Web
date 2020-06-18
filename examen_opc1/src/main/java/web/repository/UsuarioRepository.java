package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entities.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{

}
