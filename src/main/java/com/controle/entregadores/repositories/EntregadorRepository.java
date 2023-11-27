package com.controle.entregadores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.controle.entregadores.models.EntregadorModel;

@Repository
public interface EntregadorRepository  extends JpaRepository<EntregadorModel, Integer>{

}
