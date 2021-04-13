package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.DetalleHistorial;

public interface IDetalleHistorialRepo extends JpaRepository<DetalleHistorial, Integer> {

}
