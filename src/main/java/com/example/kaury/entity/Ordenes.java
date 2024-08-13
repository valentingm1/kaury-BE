package com.example.kaury.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ordenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String canalVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, length = 50)
    private String envioSeleccionado;

    @Embedded
    private DatosEnvio datosEnvio;

    @Enumerated(EnumType.STRING)
    private EstadoOrden estadoAnterior;

    @Column(length = 255)
    private String note;

    @ManyToMany
    @JoinTable(
            name = "ordenes_productos",
            joinColumns = @JoinColumn(name = "orden_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private EstadoOrden estadoActual;

    @Column(nullable = false, length = 100)
    private String sucursal;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TipoPago tipoDePago;

    @Column(nullable = false)
    private Integer tipoEnvio;

    @Column(nullable = false)
    @Min(value = 0L, message = "El valor debe ser mayor o igual a 0")
    private Double total;

    @Embedded
    private Costos costos;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Ordenes() {
    }

    public Ordenes(Long id, String canalVenta, Usuario usuario, String envioSeleccionado, DatosEnvio datosEnvio, EstadoOrden estadoAnterior, String note, List<Producto> productos, EstadoOrden estadoActual, String sucursal, String telefono, TipoPago tipoDePago, Integer tipoEnvio, Double total, Costos costos) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEnvioSeleccionado() {
        return envioSeleccionado;
    }

    public void setEnvioSeleccionado(String envioSeleccionado) {
        this.envioSeleccionado = envioSeleccionado;
    }

    public DatosEnvio getDatosEnvio() {
        return datosEnvio;
    }

    public void setDatosEnvio(DatosEnvio datosEnvio) {
        this.datosEnvio = datosEnvio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
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

    public Costos getCostos() {
        return costos;
    }

    public void setCostos(Costos costos) {
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
