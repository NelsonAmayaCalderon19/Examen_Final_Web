package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entities.Registro;

public interface RegistroRepository  extends JpaRepository<Registro, Integer>{

}
