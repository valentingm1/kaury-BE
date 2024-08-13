package com.example.kaury.service;

import com.example.kaury.dto.entrada.OrdenesEntradaDTO;
import com.example.kaury.dto.modificacion.OrdenEntradaModificacionDTO;
import com.example.kaury.dto.salida.OrdenesSalidaDTO;

import java.util.List;

public interface IOrdenesService {
    OrdenesSalidaDTO agregarOrden(OrdenesEntradaDTO ordenesEntradaDTO);

    List<OrdenesSalidaDTO> listarOrdenes();

    OrdenesSalidaDTO buscarOrdenPorId(Long id);

    void eliminarOrden(Long id);

    OrdenesSalidaDTO actualizarOrden(OrdenEntradaModificacionDTO ordenEntradaModDto);
}
