package com.idat.Service;

import java.util.List;

import com.idat.DTO.AutoDTORequest;
import com.idat.DTO.AutoDTOResponse;

public interface AutoService {
	void guardarAuto(AutoDTORequest auto);
	void actualizarAuto(AutoDTORequest auto);
	void eliminarAuto(Integer id);
	List<AutoDTOResponse> listarAuto();
	AutoDTOResponse obtenerAutoId(Integer id); 

}
