package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.Consulta;
import com.escalab.repo.IConsultaRepo;
import com.escalab.service.IConsultaService;

@Service
public class ConsultaServiceImp implements IConsultaService {
	
	@Autowired
	private IConsultaRepo repo;	

	@Override
	public Consulta registrar(Consulta obj) {
		return repo.save(obj);
	}

	@Override
	public Consulta modificar(Consulta obj) {
		return repo.save(obj);
	}

	@Override
	public List<Consulta> listar() {
		return repo.findAll();
	}

	@Override
	public Consulta leerPorId(Integer id) {
		Optional<Consulta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Consulta();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
