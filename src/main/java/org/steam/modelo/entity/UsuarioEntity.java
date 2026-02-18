package org.steam.modelo.entity;

import org.steam.modelo.enums.EstadoCuentaEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioEntity {
    private long id;
    private String nombreUsuario;
    private String email;
    private String contrasenha;
    private String nombreReal;
    private String pais;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaRegistro;
    private String avatar;
    private double saldoCartera;
    private EstadoCuentaEnum.Estado estado;

    public UsuarioEntity(long idBiblioteca, String nombreReal, String nombreUsuario, String email, String contrasenha, String pais, LocalDate fechaNacimiento, Double saldoCartera, EstadoCuentaEnum.Estado estado, String avatar, LocalDateTime fechaRegistro) {
        this.id = idBiblioteca;
        this.nombreReal = nombreReal;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contrasenha = contrasenha;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
        this.saldoCartera = saldoCartera;
        this.estado = estado;
        this.avatar = avatar;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
