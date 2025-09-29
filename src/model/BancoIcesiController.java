package model;

public class BancoIcesiController {

     /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para satisfacer los requerimientos.
     */
    
    Cliente[] clientes;
    int cantidad_clientes;
    

    public BancoIcesiController(int cantidad_clientes){
        clientes = new Cliente[cantidad_clientes];
        this.cantidad_clientes = cantidad_clientes;
    }
    
    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Los siguientes metodos estan incompletos.
     * Añada los metodos que considere hagan falta para satisfacer los requerimientos.
     * Para cada metodo:
     *      Agregue los parametros y retorno que sean pertinentes.
     *      Agregue la logica necesaria (instrucciones) para satisfacer los requerimientos.
     */

    public void agregarCliente(String nombre, int edad, String cedula, int i){

        clientes[i] = new Cliente(nombre, edad, cedula);

    }

    public void agregarCuentaCliente(String nombre_banco, int opcion_tipo_cuenta, double saldo_actual, int indiceCliente, int indiceCuenta){
        
        TipoDeCuenta tipo_cuenta = null;

        if(opcion_tipo_cuenta == 1){
            tipo_cuenta = TipoDeCuenta.valueOf("AHORROS");
        }
        else if(opcion_tipo_cuenta == 2){
            tipo_cuenta = TipoDeCuenta.valueOf("CORRIENTE");
        }
                
        Cuenta cuenta = new Cuenta(nombre_banco, tipo_cuenta, saldo_actual);

        clientes[indiceCliente].agregarCuentaCliente(cuenta, indiceCuenta); 
    }

    public void depositarDineroCuenta(String cedula, int cuenta_deposito, double saldo_deposito) {

        for(int i = 0 ; i < cantidad_clientes; i++){

            if(cedula == clientes[i].getCedula()){

                int indiceCuenta = cuenta_deposito-1;
                // A traves del objeto cliente se obtiene la lista de cuentas del cliente y se accede
                // a la posicion de las cuentas y se invoca al metodo que aumenta el valor del saldo pasandole el valor del deposito
                clientes[i].getCuentasList()[indiceCuenta].depositarDineroCuenta(saldo_deposito);
                
            }
        }
    }
    
    public void retirarDineroCuenta(String cedula, int cuenta_retiro, double saldo_retiro) {

        for(int i = 0 ; i < cantidad_clientes; i++){

            if(cedula == clientes[i].getCedula()){

                int indiceCuenta = cuenta_retiro - 1;
                clientes[i].getCuentasList()[indiceCuenta].retirarDineroCuenta(saldo_retiro);

            }

        }
    }

    public void getClienteList() {

    }

   

}
