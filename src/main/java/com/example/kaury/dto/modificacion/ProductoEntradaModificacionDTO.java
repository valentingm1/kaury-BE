package com.example.kaury.dto.modificacion;

import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class ProductoEntradaModificacionDTO {
    private Long id;

    @NotBlank(message = "El color es obligatorio")
    @Size(min = 3, max = 30, message = "El color debe tener entre 3 y 30 caracteres")
    private String color;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 255, message = "La descripción debe tener entre 10 y 255 caracteres")
    private String description;

    @NotBlank(message = "El IDC es obligatorio")
    @Pattern(regexp = "\\d{12}", message = "El IDC debe tener 12 dígitos")
    private String idc;

    @NotBlank(message = "La URL de la imagen es obligatoria")
    @Size(min = 10, max = 255, message = "La URL de la imagen debe tener entre 10 y 255 caracteres")
    private String imageCard;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El stock es obligatorio")
    private Integer stock;

    @NotBlank(message = "El talle es obligatorio")
    @Size(min = 1, max = 10, message = "El talle debe tener entre 1 y 10 caracteres")
    private String talle;

    @NotNull(message = "El precio unitario es obligatorio")
    private Double unitPrice;

    @NotEmpty(message = "Debe proporcionar al menos una categoría")
    private List<Long> categoriasIds = new ArrayList<>();

    public ProductoEntradaModificacionDTO() {
    }

    public ProductoEntradaModificacionDTO(Long id, String color, String description, String idc, String imageCard, String nombre, Integer stock, String talle, Double unitPrice, List<Long> categoriasIds) {
        this.id = id;
        this.color = color;
        this.description = description;
        this.idc = idc;
        this.imageCard = imageCard;
        this.nombre = nombre;
        this.stock = stock;
        this.talle = talle;
        this.unitPrice = unitPrice;
        this.categoriasIds = categoriasIds;
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

    public List<Long> getCategoriasIds() {
        return categoriasIds;
    }

    public void setCategoriasIds(List<Long> categoriasIds) {
        this.categoriasIds = categoriasIds;
    }
}
