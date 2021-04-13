package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.DetalleHistorial;
import com.escalab.repo.IDetalleHistorialRepo;
import com.escalab.service.IDetalleHistorialService;

@Service
public class DetalleHistorialServiceImpl implements IDetalleHistorialService {

	@Autowired
	private IDetalleHistorialRepo repo;
	
	@Override
	public DetalleHistorial registrar(DetalleHistorial obj) {
		return repo.save(obj);
	}

	@Override
	public DetalleHistorial modificar(DetalleHistorial obj) {
		return repo.save(obj);
	}

	@Override
	public List<DetalleHistorial> listar() {
		return repo.findAll();
	}

	@Override
	public DetalleHistorial leerPorId(Integer id) {
		Optional<DetalleHistorial> op = repo.findById(id);
		return op.isPresent() ? op.get() : new DetalleHistorial();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
