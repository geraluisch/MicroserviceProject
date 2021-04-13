package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.DetalleConsulta;
import com.escalab.repo.IDetalleConsultaRepo;
import com.escalab.service.IDetalleConsultaService;

@Service
public class ConsultaDetalleServiceImpl implements IDetalleConsultaService {
	
	@Autowired
	private IDetalleConsultaRepo repo;

	@Override
	public DetalleConsulta registrar(DetalleConsulta obj) {
		return repo.save(obj);
	}

	@Override
	public DetalleConsulta modificar(DetalleConsulta obj) {
		return repo.save(obj);
	}

	@Override
	public List<DetalleConsulta> listar() {
		return repo.findAll();
	}

	@Override
	public DetalleConsulta leerPorId(Integer id) {
		Optional<DetalleConsulta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new DetalleConsulta();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
