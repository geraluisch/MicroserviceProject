package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.Historial;

public interface IHistorialRepo extends JpaRepository<Historial, Integer> {

}
