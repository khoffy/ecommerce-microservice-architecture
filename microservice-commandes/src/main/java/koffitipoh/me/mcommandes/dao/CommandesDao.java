package koffitipoh.me.mcommandes.dao;

import koffitipoh.me.mcommandes.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandesDao extends JpaRepository<Commande, Integer> {
}
