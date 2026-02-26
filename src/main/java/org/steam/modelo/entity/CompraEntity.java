package org.steam.modelo.entity;

import org.steam.modelo.enums.EstadoCompraEnum;
import org.steam.modelo.enums.MetodoPagoEnum;

import java.time.LocalDateTime;

public class CompraEntity {
    private long id;
    private long usuarioId;
    private long juegoId;
    private LocalDateTime fechaCompra;
    private MetodoPagoEnum.Metodo metodoPago;
    private double precioSinDescuento;
    private int descuentoAplicado;
    private EstadoCompraEnum.Estado estado;

    public CompraEntity(long id, long usuarioId, long juegoId, LocalDateTime fechaCompra, MetodoPagoEnum.Metodo metodoPago, double precioSinDescuento, int descuentoAplicado, EstadoCompraEnum.Estado estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.juegoId = juegoId;
        this.fechaCompra = fechaCompra;
        this.metodoPago = metodoPago;
        this.precioSinDescuento = precioSinDescuento;
        this.descuentoAplicado = descuentoAplicado;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public long getJuegoId() {
        return juegoId;
    }

    public void setJuegoId(long juegoId) {
        this.juegoId = juegoId;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public MetodoPagoEnum.Metodo getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPagoEnum.Metodo metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getPrecioSinDescuento() {
        return precioSinDescuento;
    }

    public void setPrecioSinDescuento(double precioSinDescuento) {
        this.precioSinDescuento = precioSinDescuento;
    }

    public int getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(int descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public EstadoCompraEnum.Estado getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompraEnum.Estado estado) {
        this.estado = estado;
    }
}
