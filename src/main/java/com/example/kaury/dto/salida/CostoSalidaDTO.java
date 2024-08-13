package com.example.kaury.dto.salida;

import jakarta.validation.constraints.Min;

public class CostoSalidaDTO {

    private float andreaniAsucursal;
    private float andreaniCostoDomicilio;
    private float minimoCompra;
    private float transferencia;

    public CostoSalidaDTO(float andreaniAsucursal, float andreaniCostoDomicilio, float minimoCompra, float transferencia) {
        this.andreaniAsucursal = andreaniAsucursal;
        this.andreaniCostoDomicilio = andreaniCostoDomicilio;
        this.minimoCompra = minimoCompra;
        this.transferencia = transferencia;
    }

    public CostoSalidaDTO() {
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
