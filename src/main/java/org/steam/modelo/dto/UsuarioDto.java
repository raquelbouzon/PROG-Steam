package org.steam.modelo.dto;

import org.steam.modelo.enums.EstadoCuentaEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioDto {
    private long id;
    private String nombreUsuario;
    private String email;
    private String nombreReal;
    private String pais;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaRegistro;
    private String avatar;
    private double saldoCartera;
    private EstadoCuentaEnum.Estado estado;

    public UsuarioDto(EstadoCuentaEnum.Estado estado, Double saldoCartera, String avatar, LocalDateTime fechaRegistro, LocalDate fechaNacimiento, String pais, String email, String nombreReal, String nombreUsuario, Long id) {
        this.estado = estado;
        this.saldoCartera = saldoCartera;
        this.avatar = avatar;
        this.fechaRegistro = fechaRegistro;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.email = email;
        this.nombreReal = nombreReal;
        this.nombreUsuario = nombreUsuario;
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Double getSaldoCartera() {
        return saldoCartera;
    }

    public void setSaldoCartera(Double saldoCartera) {
        this.saldoCartera = saldoCartera;
    }

    public EstadoCuentaEnum.Estado getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuentaEnum.Estado estado) {
        this.estado = estado;
    }
}