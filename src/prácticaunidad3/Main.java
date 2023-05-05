/**
 * Ejercicio Entornos de JavaDoc
 * Metodo Main
 */
package prácticaunidad3;

/**
 * Metodo Main Cuenta
 *
 * @author Jose Antonio del Rio Martínez
 * @version Clase Main v.1
 * @since 10 de febrero de 2023
 */
class Main {

    /**
     * Clase Main donde operamos con los objetos de tipo CCcuenta
     *
     * @param args -
     */
    public static void main(String[] args) {

        //Inicializamos el objeto cuenta1 de la clase CCuenta 
        CCuenta cuenta1 = new CCuenta("Manuel Mantecas", "0000-1234-55-123456789", 3000, 0);
        CCuenta cuenta2 = new CCuenta("Manuel Mantecas", "0000-1234-55-123456789", 3000, 0);
        
        //Llamamos al metodo para operar con cuenta1 
        operativa_cuenta(cuenta1, 1000.0F);

        
    }

    //-----------------------------------------------------------
    /**
     * Metodo que engloba todas las operaciones del objeto cuenta1
     *
     * @param cuenta1 Objeto de la Clase CCuenta
     * @param cantidad Importe a ingresar en cuenta
     */
    private static void operativa_cuenta(CCuenta cuenta1, float cantidad) {

        //Mostramos saldo incial
        System.out.println("El saldo actual es " + cuenta1.getSaldo() + "\n");

        // Llamada al metodo retirar
        try {
            System.out.println("Retirada en cuenta");
            cuenta1.retirar(500);
        } catch (Exception e) {
            System.out.print("Fallo al retirar");
        }

        //Mostramos saldo tras la retirada
        System.out.println("El saldo actual es " + cuenta1.getSaldo() + "\n");
        
        // Llamada al metodo ingresar
        try {
            System.out.println("Ingreso en cuenta");
            cuenta1.ingresar(cantidad);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }

        //Mostramos el saldo despues del ingreso
        System.out.println("El saldo actual es " + cuenta1.getSaldo() + "\n");

        // Llamada metodo cobro factura
        try {
            System.out.println("Cobro Facura");
            cuenta1.cobroFactura("Luz", 50);
        } catch (Exception e) {
            System.out.println("Fallo en facturacion");
        }

        //Mostramos saldo despues del cobro de la factura
        System.out.println("El saldo actual es " + cuenta1.getSaldo());
    }

}
