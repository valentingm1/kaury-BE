package com.example.kaury.dto.salida;

import com.example.kaury.entity.EstadoOrden;
import com.example.kaury.entity.TipoPago;

import java.time.LocalDateTime;
import java.util.List;

public class OrdenesSalidaDTO {
    private Long id;
    private String canalVenta;
    private UsuarioSalidaDTO usuario;
    private String envioSeleccionado;
    private DatosEnvioSalidaDTO datosEnvio;
    private EstadoOrden estadoAnterior;
    private String note;
    private List<ProductoSalidaDTO> productos;
    private EstadoOrden estadoActual;
    private String sucursal;
    private String telefono;
    private TipoPago tipoDePago;
    private Integer tipoEnvio;
    private Double total;
    private CostoSalidaDTO costos;



    public OrdenesSalidaDTO() {
    }

    public OrdenesSalidaDTO(Long id, String canalVenta, UsuarioSalidaDTO usuario, String envioSeleccionado, DatosEnvioSalidaDTO datosEnvio, EstadoOrden estadoAnterior, String note, List<ProductoSalidaDTO> productos, EstadoOrden estadoActual, String sucursal, String telefono, TipoPago tipoDePago, Integer tipoEnvio, Double total, CostoSalidaDTO costos) {
        this.id = id;
        this.canalVenta = canalVenta;
        this.usuario = usuario;
        this.envioSeleccionado = envioSeleccionado;
        this.datosEnvio = datosEnvio;
        this.estadoAnterior = estadoAnterior;
        this.note = note;
        this.productos = productos;
        this.estadoActual = estadoActual;
        this.sucursal = sucursal;
        this.telefono = telefono;
        this.tipoDePago = tipoDePago;
        this.tipoEnvio = tipoEnvio;
        this.total = total;
        this.costos = costos;
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

    public UsuarioSalidaDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSalidaDTO usuario) {
        this.usuario = usuario;
    }


    public String getEnvioSeleccionado() {
        return envioSeleccionado;
    }

    public void setEnvioSeleccionado(String envioSeleccionado) {
        this.envioSeleccionado = envioSeleccionado;
    }

    public DatosEnvioSalidaDTO getDatosEnvio() {
        return datosEnvio;
    }

    public void setDatosEnvio(DatosEnvioSalidaDTO datosEnvio) {
        this.datosEnvio = datosEnvio;
    }



    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<ProductoSalidaDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoSalidaDTO> productos) {
        this.productos = productos;
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

    public CostoSalidaDTO getCostos() {
        return costos;
    }

    public void setCostos(CostoSalidaDTO costos) {
        this.costos = costos;
    }

    public EstadoOrden getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(EstadoOrden estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public EstadoOrden getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoOrden estadoActual) {
        this.estadoActual = estadoActual;
    }
}
