package ui;

import java.util.Scanner;

import model.BancoIcesiController;
import model.Cliente;
import model.Cuenta;

public class BancoIcesiUI {

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Agregue los atributos (relaciones) necesarios para conectar esta clase con el modelo.
     */

    private Scanner input;
    private BancoIcesiController controller;
    
    int cantidad_clientes;
    
    public static void main(String[] args) {

        BancoIcesiUI ui = new BancoIcesiUI();

        ui.menu();
    }

    // Constructor
    public BancoIcesiUI() {
        input = new Scanner(System.in);
        
    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * El siguiente metodo esta incompleto.
     * Agregue la logica necesaria (instrucciones) para satisfacer los requerimientos
     */

    public void menu() {

        System.out.println("\n¡Bienvenido a BancoIcesi!");
        

        int option = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("-".repeat(50));
            System.out.println("Digite alguna de las siguientes opciones");
            System.out.println("1) Registrar cliente(s)"); //Listo
            System.out.println("2) Asignar cuenta bancaria a cliente"); //Listo
            System.out.println("3) Depositar dinero en cuenta bancaria de un cliente"); //Listo
            System.out.println("4) Retirar dinero de una cuenta bancaria de un cliente"); // Listo
            System.out.println("5) Consultar cliente por numero de cedula");
            System.out.println("6) Consultar el saldo total de todas las cuentas");
            System.out.println("0) Salir del sistema"); //Listo
            option = input.nextInt();

            switch (option) {
                case 1:
                    registrarCliente();
                    System.out.println("-".repeat(50));
                    break;
                case 2:
                    asignarCuentaBancariaCliente();
                    System.out.println("-".repeat(50));
                    break;
                case 3:
                    depositarDineroCuenta();
                    System.out.println("-".repeat(50));
                    break;
                case 4:
                    retirarDineroCuenta();
                    System.out.println("-".repeat(50));
                    break;
                case 5:
                    consultarCliente();
                    System.out.println("-".repeat(50));
                    break;
                case 6:
                    consultarSaldoTotal();
                    System.out.println("-".repeat(50));
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. Adios!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
                    break;
            }

        } while (option != 0);

    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Los siguientes metodos estan incompletos.
     * Agregue la logica necesaria (instrucciones) para satisfacer los requerimientos
     */

    public  void registrarCliente() {
        
        System.out.println("\n---> REGISTRO DE CLIENTES");

        // Cantidad de clientes
        System.out.println("\nIngrese la cantidad de clientes a registrar: ");
        cantidad_clientes = input.nextInt();
        input.nextLine();
        controller = new BancoIcesiController(cantidad_clientes);

        String nombre, cedula;
        int edad;
        
        for(int i = 0; i < cantidad_clientes; i++){
            System.out.println("\n--> Ingrese el nombre del cliente " + (i+1) + ": " );
            nombre = input.nextLine();

            do{
                System.out.println("Ingrese la edad del cliente " + (i+1) + ": "  );
                edad = input.nextInt();
                input.nextLine();

            }while(edad <= 0);
            
            System.out.println("Ingrese el número de cédula del cliente " + (i+1) + ": "  );
            cedula = input.nextLine();

            controller.agregarCliente(nombre, edad, cedula, i);
        }
        
    }

    public void asignarCuentaBancariaCliente() {

        int cantidad_cuentas;

        System.out.println("\n---> Asignación cuentas bancarias clientes");
        
        for(int i = 0; i < cantidad_clientes; i++){
            
            do{
                System.out.println("\n¿Cuántas cuentas quiere asignar al cliente " + controller.getClienteList()[i].getNombre_cliente()+": ");
                cantidad_cuentas = input.nextInt();
                input.nextLine();

            } while(cantidad_cuentas <=0);

            for(int j = 0; j<cantidad_cuentas; j++){
                
                // Nombre del banco

                System.out.println("\nIngrese el nombre del banco para la cuenta No."+(j+1) + " de " + controller.getClienteList()[i].getNombre_cliente() + ": ");
                String nombre_banco = input.nextLine();
                                
                // Tipo de cuenta

                System.out.println("Tipo de cuenta: \n Marque 1 para cuenta de ahorros. \n Marque 2 para cuenta corriente");

                System.out.println("Ingrese el numero del tipo de cuenta para la cuenta No."+(j+1) + " de " + controller.getClienteList()[i].getNombre_cliente() + ": ");
                int opcion_tipo_cuenta = input.nextInt();
                input.nextLine();

                // Saldo actual 

                double saldo_actual;
                
                do{
                    System.out.println("Ingrese el saldo actual de la cuenta No."+(j+1) + " de " + controller.getClienteList()[i].getNombre_cliente() + ": ");
                    saldo_actual = input.nextDouble();
                    input.nextLine();
                }while(saldo_actual < 0);


                controller.agregarCuentaCliente(nombre_banco, opcion_tipo_cuenta, saldo_actual, i, j);
            }
        }
    }

    public void depositarDineroCuenta() {

        System.out.println("\n---> DEPOSITAR DINERO EN CUENTA BANCARIA");

        System.out.println("\nIngrese la cédula del cliente al que se desea hacer el deposito: ");
        String cedula = input.nextLine();
        input.nextLine();

        System.out.println("Ingrese el numero de la cuenta a la que se desea hacer el deposito: ");
        int cuenta_deposito = input.nextInt();
        input.nextLine();

        System.out.println("Ingrese el monto del deposito: ");
        double saldo_deposito = input.nextDouble();
        input.nextLine();
        
        controller.depositarDineroCuenta(cedula, cuenta_deposito, saldo_deposito);

    }

    public void retirarDineroCuenta() {
         System.out.println("\n---> RETIRAR DINERO DE CUENTA BANCARIA");

        System.out.println("\nIngrese la cédula del cliente al que se desea hacer el retiro: ");
        String cedula = input.nextLine();

        System.out.println("Ingrese el numero de la cuenta a la que se desea hacer el retiro: ");
        int cuenta_retiro = input.nextInt();
        input.nextLine();

        System.out.println("Ingrese el monto del retiro: ");
        double saldo_retiro = input.nextDouble();
        input.nextLine();
        
        controller.retirarDineroCuenta(cedula, cuenta_retiro, saldo_retiro);

    }

    public void consultarCliente() {

    }

    public void consultarSaldoTotal() {

    }

}
