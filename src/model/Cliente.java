package model;

public class Cliente {

    //Atributos

    private String nombre_cliente;
    private int edad;
    private String cedula;
    private Cuenta[] cuentas_bancarias;

    //Constructor

    public Cliente(String nombre_cliente, int edad, String cedula){
        this.nombre_cliente = nombre_cliente;
        this.edad = edad;
        this.cedula = cedula;
        this.cuentas_bancarias = new Cuenta[10];
    }


    // Metodos

    public void agregarCuentaCliente(String nombre_banco, TipoDeCuenta tipo_cuenta, double saldo_actual){
        for(int i = 0; i < cuentas_bancarias.length ; i++ ){
            if(cuentas_bancarias[i] == null){
                cuentas_bancarias[i] = new Cuenta(nombre_banco,tipo_cuenta,saldo_actual);
            }
        }
    }


     /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * El siguiente metodo esta incompleto.
     * Agregue los parametros y retorno que sean pertinentes.
     * Agregue la logica necesaria.
     */
    public void getCuentasList() {

    }

}
