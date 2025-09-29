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

    public void agregarCuentaCliente(Cuenta cuenta, int indiceCuenta){
        cuentas_bancarias[indiceCuenta] = cuenta;
    }


     /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * El siguiente metodo esta incompleto.
     * Agregue los parametros y retorno que sean pertinentes.
     * Agregue la logica necesaria.
     */
    public Cuenta[] getCuentasList() {
        return cuentas_bancarias;
    }

    // Getters y setters

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getCedula() {
        return cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
