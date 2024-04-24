package koffitipoh.me.mpaiement.dao;

import koffitipoh.me.mpaiement.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Integer>{
    Paiement findByidCommande(int idCommande);
}
