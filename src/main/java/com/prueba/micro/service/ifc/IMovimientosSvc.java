package com.prueba.micro.service.ifc;

import java.sql.Date;
import java.util.List;

import com.prueba.micro.controller.dto.MovimientoDto;
import com.prueba.micro.controller.dto.MovimientosClienteDto;
import com.prueba.micro.util.BusinessException;

public interface IMovimientosSvc {

	public MovimientoDto movimientoCrear(MovimientoDto clienteDto) throws BusinessException;

	public MovimientoDto movimientoActualizar(MovimientoDto clienteDto);

	public boolean movimientoEliminar(String id) throws BusinessException;

	public String movimientoIdentificacion(String identificacion);

	public List<MovimientosClienteDto> movimientoReporte(Date fecha1, Date fecha2, String identificacion);

}
