package com.example.kaury.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DatosEnvio {

    @Column(nullable = false, length = 50)
    private String barrio;

    @Column(nullable = false, length = 50)
    private String calle;

    @Column(nullable = false, length = 50)
    private String ciudad;

    @Column(nullable = false, length = 10)
    private String codigoPostal;

    @Column(nullable = false, length = 6)
    private String numero;

    @Column(length = 10)
    private String pisoDpto;

    @Column(nullable = false, length = 50)
    private String provincia;


    public DatosEnvio() {
    }

    public DatosEnvio(String barrio, String calle, String ciudad, String codigoPostal, String numero, String pisoDpto, String provincia) {
        this.barrio = barrio;
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.numero = numero;
        this.pisoDpto = pisoDpto;
        this.provincia = provincia;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPisoDpto() {
        return pisoDpto;
    }

    public void setPisoDpto(String pisoDpto) {
        this.pisoDpto = pisoDpto;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
