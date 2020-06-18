package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entities.Eps;

public interface EpsRepository extends JpaRepository<Eps, Integer> {

}
