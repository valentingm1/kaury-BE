package com.example.kaury.dto.salida;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductoSalidaDTO {
    private Long id;
    private String color;
    private String description;
    private String idc;
    private String imageCard;
    private String nombre;
    private Double promotionalPrice;
    private Integer stock;
    private String talle;
    private Double unitPrice;
    private List<CategoriaProductosSalidaDTO> categorias;


    public ProductoSalidaDTO(Long id, String color, String description, String idc, String imageCard, String nombre, Double promotionalPrice, Integer stock, String talle, Double unitPrice, List<CategoriaProductosSalidaDTO> categorias) {
        this.id = id;
        this.color = color;
        this.description = description;
        this.idc = idc;
        this.imageCard = imageCard;
        this.nombre = nombre;
        this.promotionalPrice = promotionalPrice;
        this.stock = stock;
        this.talle = talle;
        this.unitPrice = unitPrice;
        this.categorias = categorias;
    }

    public ProductoSalidaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<CategoriaProductosSalidaDTO> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaProductosSalidaDTO> categorias) {
        this.categorias = categorias;
    }
}
