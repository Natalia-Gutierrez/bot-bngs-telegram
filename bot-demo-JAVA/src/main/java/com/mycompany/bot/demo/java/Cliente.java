package com.mycompany.bot.demo.java;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Pc
 */
public class Cliente {
    private Long idCliente;
    private int status;
    private String nombre;
    private String pinDeSeguridad;
    private double monto;
    private List<Cuenta> cuenta;
    private String listaDeCuentas;
    private String opcMoneda;
    private String opcTipo;
    private String cuentaGenerada;

    public Cliente(Long idCliente,int status) {
        this.idCliente=idCliente;
        this.status=status;
        this.cuenta=new ArrayList();
        this.listaCuentas="";
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public int getStatus() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPinDeSeguridad() {
        return pin;
    }

    public double getMonto() {
        return monto;
    }

    public List<Cuenta> getCuenta() {
        return cuentas;
    }
    
    public String getListaDeCuentas() {
        return listaDeCuentas;
    }
    
    public String getOpcMoneda() {
        return opcMoneda;
    }
    
    public String getOpcTipo() {
        return opcTipo;
    }
    
    public String getCuentaGenerada() {
        return cuentaGenerada;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente=idCliente;
    }

    public void setStatus(int status) {
        this.status=status;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public void setPinDeSeguridad(String pinDeSeguridad) {
        this.pinDeSeguridad=pinDeSeguridad;
    }

    public void setMonto(double monto) {
        this.monto=monto;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas=cuentas;
    }
    
    public void setListaDeCuentas(String listaDeCuentas) {
        this.listaDeCuentas=listaDeCuentas;
    }
    
    public void setOpcMoneda(String opcMoneda) {
        this.opcMoneda=opcMoneda;
    }
    
    public void setOpcTipo(String opcTipo) {
        this.opcTipo=opcTipo;
    }
    
    public void setCuentaGenerada(String cuentaGenerada) {
        this.cuentaGenerada=cuentaGenerada;
    }
    
    public void addCuenta(Cuenta nuevaCuenta) {
        this.cuentas.add(nuevaCuenta);
    }

    @Override
    public String toString() {
        return "Usuario{"+"idUser="+idCliente+", "
        + "estado="+status+", "
        + "Nombre de usuario="+nombre+", "
        + "Pin de Seguridad="+pinDeSeguridad+", "
        + "Monto="+monto+", "
        + "Cuentas="+cuenta+", "
        + "Opcion de Moneda="+opcMoneda+", "
        + "Opcion de Tipo="+opcTipo+", "
        + "Cuenta Generada="+cuentaGenerada+"}";
    }  
}