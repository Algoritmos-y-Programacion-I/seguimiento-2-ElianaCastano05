package model;

public class Cuenta {
    
    //Atributos

    private String nombre_banco;
    private TipoDeCuenta tipo_cuenta;
    private double saldo_actual;

    //Constructor

    public Cuenta(String nombre_banco, TipoDeCuenta tipo_cuenta,double saldo_actual){

        this.nombre_banco = nombre_banco;
        this.tipo_cuenta = tipo_cuenta;
        this.saldo_actual = saldo_actual;
    }

    //Metodos

    public void depositarDineroCuenta(double deposito_saldo){
        this.saldo_actual = saldo_actual + deposito_saldo;
    }

    public void retirarDineroCuenta(double retiro_saldo){
       
       if(saldo_actual >= 0 && saldo_actual > retiro_saldo){
            this.saldo_actual = saldo_actual - retiro_saldo;
       }
    }

    // Getter's y setter's

    public String getNombre_banco() {
        return nombre_banco;
    }

    public void setNombre_banco(String nombre_banco) {
        this.nombre_banco = nombre_banco;
    }

    public TipoDeCuenta getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setSaldo_actual(TipoDeCuenta tipo_cuenta){
        this.tipo_cuenta = tipo_cuenta;
    }

    public double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }
}
