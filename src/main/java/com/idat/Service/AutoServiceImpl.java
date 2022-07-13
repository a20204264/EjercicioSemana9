package com.idat.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idat.Model.Autos;

import com.idat.DTO.AutoDTORequest;
import com.idat.DTO.AutoDTOResponse;
import com.idat.Repository.AutosRepository;

@Service
public class AutoServiceImpl implements AutoService{

	@Autowired
	private AutosRepository repository;
	
	
	@Override
	public void guardarAuto(AutoDTORequest auto) {

		Autos a= new Autos();
		a.setNombre(auto.getNombreauto());
		a.setPlaca(auto.getPlacaauto());
		repository.save(a);
		
	}

	@Override
	public void actualizarAuto(AutoDTORequest auto) {
		Autos a= new Autos();
		a.setId(auto.getIdauto());
		a.setNombre(auto.getNombreauto());
		a.setPlaca(auto.getPlacaauto());
		repository.saveAndFlush(a);
		
	}

	@Override
	public void eliminarAuto(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<AutoDTOResponse> listarAuto() {

		List<AutoDTOResponse> listar = new ArrayList<>();
		AutoDTOResponse dto= null;
		List<Autos> a= repository.findAll();
		for(Autos auto: a) {
			
			dto= new AutoDTOResponse();
			dto.setIdauto(auto.getId());
			dto.setNombreauto(auto.getNombre());
			dto.setPlacaauto(auto.getPlaca());
			
			listar.add(dto);
		}
			
		return listar;
	}

	@Override
	public AutoDTOResponse obtenerAutoId(Integer id) {
		Autos auto= repository.findById(id).orElse(null);
		AutoDTOResponse dto= new AutoDTOResponse();
		
		dto= new AutoDTOResponse();
		dto.setIdauto(auto.getId());
		dto.setNombreauto(auto.getNombre());
		dto.setPlacaauto(auto.getPlaca());
		
		return dto;
	}

	
}
