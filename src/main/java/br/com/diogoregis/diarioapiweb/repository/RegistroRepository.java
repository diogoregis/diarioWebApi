package br.com.diogoregis.diarioapiweb.repository;

import br.com.diogoregis.diarioapiweb.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
}
