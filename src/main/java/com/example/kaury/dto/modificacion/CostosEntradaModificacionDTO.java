package com.example.kaury.dto.modificacion;

import jakarta.validation.constraints.Min;

public class CostosEntradaModificacionDTO {
    @Min(value = 0L, message = "El valor debe ser mayor o igual a 0")
    private Float andreaniAsucursal;
    @Min(value = 0L, message = "El valor debe ser mayor o igual a 0")
    private Float andreaniCostoDomicilio;
    @Min(value = 0L, message = "El valor debe ser mayor o igual a 0")
    private Float minimoCompra;
    @Min(value = 0L, message = "El valor debe ser mayor o igual a 0")
    private Float transferencia;

    public CostosEntradaModificacionDTO() {
    }

    public CostosEntradaModificacionDTO(float andreaniAsucursal, float andreaniCostoDomicilio, float minimoCompra, float transferencia) {
        this.andreaniAsucursal = andreaniAsucursal;
        this.andreaniCostoDomicilio = andreaniCostoDomicilio;
        this.minimoCompra = minimoCompra;
        this.transferencia = transferencia;
    }


    public Float getAndreaniAsucursal() {
        return andreaniAsucursal;
    }

    public void setAndreaniAsucursal(Float andreaniAsucursal) {
        this.andreaniAsucursal = andreaniAsucursal;
    }

    public Float getAndreaniCostoDomicilio() {
        return andreaniCostoDomicilio;
    }

    public void setAndreaniCostoDomicilio(Float andreaniCostoDomicilio) {
        this.andreaniCostoDomicilio = andreaniCostoDomicilio;
    }

    public Float getMinimoCompra() {
        return minimoCompra;
    }

    public void setMinimoCompra(Float minimoCompra) {
        this.minimoCompra = minimoCompra;
    }

    public Float getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Float transferencia) {
        this.transferencia = transferencia;
    }
}
