package org.enset.demo.repository;

import org.enset.demo.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat,Long> {
    Contrat findByCinClient(String cin);
}
