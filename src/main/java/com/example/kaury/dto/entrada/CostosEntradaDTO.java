package com.example.kaury.dto.entrada;

import jakarta.validation.constraints.Min;

public class CostosEntradaDTO {

    @Min(value = 0L, message = "El valor debe ser mayor o igual a 0")
    private Float andreaniAsucursal;
    @Min(value = 0L, message = "El valor debe ser mayor o igual a 0")
    private Float andreaniCostoDomicilio;
    @Min(value = 0L, message = "El valor debe ser mayor o igual a 0")
    private Float minimoCompra;
    @Min(value = 0L, message = "El valor debe ser mayor o igual a 0")
    private Float transferencia;


    public CostosEntradaDTO() {
    }

    public CostosEntradaDTO(float andreaniAsucursal, float andreaniCostoDomicilio, float minimoCompra, float transferencia) {
        this.andreaniAsucursal = andreaniAsucursal;
        this.andreaniCostoDomicilio = andreaniCostoDomicilio;
        this.minimoCompra = minimoCompra;
        this.transferencia = transferencia;
    }

    public float getAndreaniAsucursal() {
        return andreaniAsucursal;
    }

    public void setAndreaniAsucursal(float andreaniAsucursal) {
        this.andreaniAsucursal = andreaniAsucursal;
    }

    public float getAndreaniCostoDomicilio() {
        return andreaniCostoDomicilio;
    }

    public void setAndreaniCostoDomicilio(float andreaniCostoDomicilio) {
        this.andreaniCostoDomicilio = andreaniCostoDomicilio;
    }

    public float getMinimoCompra() {
        return minimoCompra;
    }

    public void setMinimoCompra(float minimoCompra) {
        this.minimoCompra = minimoCompra;
    }

    public float getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(float transferencia) {
        this.transferencia = transferencia;
    }
}
