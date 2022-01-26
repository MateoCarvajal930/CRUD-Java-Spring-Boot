package com.SpringBoot.SVentas.repository;

import com.SpringBoot.SVentas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

}
