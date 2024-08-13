package com.example.kaury.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String color;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 20)
    private String idc;

    @Column(length = 255)
    private String imageCard;

    @Column(length = 50)
    private String nombre;

    @Column(columnDefinition = "DECIMAL(10,2)")
    @Nullable
    private Double promotionalPrice;

    @Column(columnDefinition = "SMALLINT")
    private Integer stock;

    @Column(length = 10)
    private String talle;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime timestamp;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double unitPrice;

    @ManyToMany
    @JoinTable(
            name = "producto_categoria",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<CategoriaProductos> categorias = new ArrayList<>();

    @ManyToMany(mappedBy = "productos")
    private List<Ordenes> ordenes = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public Producto() {
    }


    public Producto(Long id, String color, String description, String idc, String imageCard, String nombre, Double promotionalPrice, Integer stock, String talle, LocalDateTime timestamp, Double unitPrice) {
        this.id = id;
        this.color = color;
        this.description = description;
        this.idc = idc;
        this.imageCard = imageCard;
        this.nombre = nombre;
        this.promotionalPrice = promotionalPrice;
        this.stock = stock;
        this.talle = talle;
        this.timestamp = timestamp;
        this.unitPrice = unitPrice;
        this.categorias = new ArrayList<>();
        this.ordenes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<CategoriaProductos> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaProductos> categorias) {
        this.categorias = categorias;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdc() {
        return idc;
    }

    public void setIdc(String idc) {
        this.idc = idc;
    }

    public String getImageCard() {
        return imageCard;
    }

    public void setImageCard(String imageCard) {
        this.imageCard = imageCard;
    }


    public Double getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(Double promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ordenes> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Ordenes> ordenes) {
        this.ordenes = ordenes;
    }

}
