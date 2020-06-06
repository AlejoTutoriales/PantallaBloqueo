package com.alejo.g500.objetos;

public class Lectura {
    private String idRegistro;
    private String num_bomba;
    private String valor_incial;
    private String valor_final;
    private String idUsuario;
    private String num_despachador;
    private String tipo_gasolina;
    private String fecha;

    public Lectura() {
    }

    public Lectura(String idRegistro, String num_bomba, String valor_incial, String valor_final, String idUsuario, String num_despachador, String tipo_gasolina, String fecha) {
        this.idRegistro = idRegistro;
        this.num_bomba = num_bomba;
        this.valor_incial = valor_incial;
        this.valor_final = valor_final;
        this.idUsuario = idUsuario;
        this.num_despachador = num_despachador;
        this.tipo_gasolina = tipo_gasolina;
        this.fecha = fecha;
    }

    public String getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getNum_bomba() {
        return num_bomba;
    }

    public void setNum_bomba(String num_bomba) {
        this.num_bomba = num_bomba;
    }

    public String getValor_incial() {
        return valor_incial;
    }

    public void setValor_incial(String valor_incial) {
        this.valor_incial = valor_incial;
    }

    public String getValor_final() {
        return valor_final;
    }

    public void setValor_final(String valor_final) {
        this.valor_final = valor_final;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNum_despachador() {
        return num_despachador;
    }

    public void setNum_despachador(String num_despachador) {
        this.num_despachador = num_despachador;
    }

    public String getTipo_gasolina() {
        return tipo_gasolina;
    }

    public void setTipo_gasolina(String tipo_gasolina) {
        this.tipo_gasolina = tipo_gasolina;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return "Número de Bomba: " + num_bomba + '\n' +
                "Lectura Inicial: " + valor_incial + '\n' +
                "Lectura Final: " + valor_final + '\n' +
                "Tipo de Gasolina: " + (tipo_gasolina.equals("0") ? "Super" : "Premium") + '\n' +
                "Fecha: " + fecha;
    }
}
