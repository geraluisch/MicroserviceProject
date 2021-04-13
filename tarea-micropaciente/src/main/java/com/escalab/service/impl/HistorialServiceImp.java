package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.Historial;
import com.escalab.repo.IHistorialRepo;
import com.escalab.service.IHistorialService;

@Service
public class HistorialServiceImp implements IHistorialService {
	
	@Autowired
	private IHistorialRepo repo;

	@Override
	public Historial registrar(Historial obj) {
		return repo.save(obj);
	}

	@Override
	public Historial modificar(Historial obj) {
		return repo.save(obj);
	}

	@Override
	public List<Historial> listar() {
		return repo.findAll();
	}

	@Override
	public Historial leerPorId(Integer id) {
		Optional<Historial> op = repo.findById(id); 
		return op.isPresent() ? op.get() : new Historial();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
