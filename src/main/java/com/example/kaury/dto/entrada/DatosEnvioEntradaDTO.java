package com.example.kaury.dto.entrada;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DatosEnvioEntradaDTO {
    @NotBlank(message = "El barrio es obligatorio")
    @Size(min = 2, max = 50, message = "El barrio debe tener entre 2 y 50 caracteres")
    private String barrio;

    @NotBlank(message = "La calle es obligatoria")
    @Size(min = 2, max = 50, message = "La calle debe tener entre 2 y 50 caracteres")
    private String calle;

    @NotBlank(message = "La ciudad es obligatoria")
    @Size(min = 2, max = 50, message = "La ciudad debe tener entre 2 y 50 caracteres")
    private String ciudad;

    @NotBlank(message = "El código postal es obligatorio")
    @Pattern(regexp = "\\d{4,10}", message = "El código postal debe tener entre 4 y 10 dígitos")
    private String codigoPostal;

    @NotBlank(message = "El número es obligatorio")
    @Pattern(regexp = "\\d{1,6}", message = "El número debe tener entre 1 y 6 dígitos")
    private String numero;

    @Size(max = 10, message = "El piso/departamento no debe exceder los 10 caracteres")
    private String pisoDpto;

    @NotBlank(message = "La provincia es obligatoria")
    @Size(min = 2, max = 50, message = "La provincia debe tener entre 2 y 50 caracteres")
    private String provincia;


    public DatosEnvioEntradaDTO() {
    }

    public DatosEnvioEntradaDTO(String barrio, String calle, String ciudad, String codigoPostal, String numero, String pisoDpto, String provincia) {

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
