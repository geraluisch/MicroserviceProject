package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.DetalleConsulta;

public interface IDetalleConsultaRepo extends JpaRepository<DetalleConsulta, Integer> {

}
