package com.example.kaury.dto.modificacion;


import com.example.kaury.dto.entrada.DatosEnvioEntradaDTO;
import com.example.kaury.entity.EstadoOrden;
import com.example.kaury.entity.TipoPago;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class OrdenEntradaModificacionDTO {
    private Long id;
    private String canalVenta;
    private String envioSeleccionado;
    private DatosEnvioEntradaDTO datosEnvio;
    private EstadoOrden estadoActual;
    private EstadoOrden estadoAnterior;
    private String note;
    @NotEmpty(message = "La orden debe tener al menos un producto")
    private List<Long> productosIds;
    private String sucursal;
    private String telefono;
    private TipoPago tipoDePago;
    private Integer tipoEnvio;
    private Double total;
    private CostosEntradaModificacionDTO costos;
    private Long usuarioId;

    public OrdenEntradaModificacionDTO() {
    }

    public OrdenEntradaModificacionDTO(Long id, String canalVenta, String envioSeleccionado, DatosEnvioEntradaDTO datosEnvio, EstadoOrden estadoActual, EstadoOrden estadoAnterior, String note, List<Long> productosIds, String sucursal, String telefono, TipoPago tipoDePago, Integer tipoEnvio, Double total, CostosEntradaModificacionDTO costos, Long usuarioId) {
        this.id = id;
        this.canalVenta = canalVenta;
        this.envioSeleccionado = envioSeleccionado;
        this.datosEnvio = datosEnvio;
        this.estadoActual = estadoActual;
        this.estadoAnterior = estadoAnterior;
        this.note = note;
        this.productosIds = productosIds;
        this.sucursal = sucursal;
        this.telefono = telefono;
        this.tipoDePago = tipoDePago;
        this.tipoEnvio = tipoEnvio;
        this.total = total;
        this.costos = costos;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public String getEnvioSeleccionado() {
        return envioSeleccionado;
    }

    public void setEnvioSeleccionado(String envioSeleccionado) {
        this.envioSeleccionado = envioSeleccionado;
    }

    public DatosEnvioEntradaDTO getDatosEnvio() {
        return datosEnvio;
    }

    public void setDatosEnvio(DatosEnvioEntradaDTO datosEnvio) {
        this.datosEnvio = datosEnvio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Long> getProductosIds() {
        return productosIds;
    }

    public void setProductosIds(List<Long> productosIds) {
        this.productosIds = productosIds;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoPago getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(TipoPago tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public Integer getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(Integer tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public CostosEntradaModificacionDTO getCostos() {
        return costos;
    }

    public void setCostos(CostosEntradaModificacionDTO costos) {
        this.costos = costos;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public EstadoOrden getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoOrden estadoActual) {
        this.estadoActual = estadoActual;
    }

    public EstadoOrden getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(EstadoOrden estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }
}
