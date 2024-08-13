package com.example.kaury.dto.salida;

public class CategoriaProductosSalidaDTO {
    private Long id;
    private String imagen;
    private String nombre;
    private boolean status;


    public CategoriaProductosSalidaDTO(Long id, String imagen, String nombre, boolean status) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.status = status;
    }

    public CategoriaProductosSalidaDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
