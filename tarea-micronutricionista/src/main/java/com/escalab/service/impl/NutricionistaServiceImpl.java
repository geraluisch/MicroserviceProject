package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.Nutricionista;
import com.escalab.repo.INutricionistaRepo;
import com.escalab.service.INutricionistaService;

@Service
public class NutricionistaServiceImpl implements INutricionistaService {
	
	@Autowired
	private INutricionistaRepo repo;

	@Override
	public Nutricionista registrar(Nutricionista obj) {		
		return repo.save(obj);
	}

	@Override
	public Nutricionista modificar(Nutricionista obj) {
		return repo.save(obj);
	}

	@Override
	public List<Nutricionista> listar() {
		return repo.findAll();
	}

	@Override
	public Nutricionista leerPorId(Integer id) {
		Optional<Nutricionista> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Nutricionista();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
