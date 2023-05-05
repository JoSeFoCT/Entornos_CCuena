/**
 * Ejercicio Entornos de JavaDoc
 * Clase CCuenta
 */

package prácticaunidad3;

import java.util.Objects;

/**
 * La clase CCuenta permite crear y operar con objetos que contienen información
 * bancaria de los usuarios.
 *
 * @author Jose Antonio del Rio Martínez
 * @version Clase Cuenta v.1
 * @since 10 de febrero de 2023
 */
public class CCuenta {

    //----------------------------------------------------------- ATRIBUTOS
    //Variable privada que contiene nombre del titular
    private String nombre;

    //Variable privada que contiene numero de cuenta bancaria
    private String cuenta;

    //Variable privada que contiene el saldo actual de la cuenta
    private double saldo;

    //Variable privada que contiene el tipo de interes a aplicar
    private double tipoInteres;

    //----------------------------------------------------------- CONSTRUCTORES
    /**
     * Constructor por defecto sin parametros. 
     * Los valores de los atributos los asigna java por defecto
     */
    public CCuenta() {
    }

    /**
     * Constructor con parametros
     *
     * @param nom Nombre del titular de la cuenta
     * @param cue Número de cuenta bancaria
     * @param sal Saldo inicial de la cuenta
     * @param tipo Interes que se le aplica a las operaciones bancarias
     */
    public CCuenta(String nom, String cue, double sal, double tipo) {
        nombre = nom;
        cuenta = cue;
        saldo = sal;
        tipoInteres = tipo;
    }

    //----------------------------------------------------------- GETTERS
    /**
     * Método GET que me devuelve el nombre del titular
     *
     * @return nombre - Nombre del titular
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método GET que me devuelve el número de cuenta
     *
     * @return cuenta - Número de cuenta bancaria
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * Método GET que devuelve el saldo actual en cuenta
     *
     * @return saldo - Saldo actual en cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Método GET que devuelve el interes que se está apliacando
     *
     * @return tipoInteres - Interes aplicado a las operaciones a cuenta
     */
    public double getTipoInteres() {
        return tipoInteres;
    }

    //----------------------------------------------------------- SETTERS  
    /**
     * Método SET para asignar el nombre del titular de la cuenta
     *
     * @param nombre Nombre del titular
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método SET para asignar el numero de cuenta bancaria
     *
     * @param cuenta Cuenta bancaria
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Método SET para actualizar/asignar saldo en cuenta
     *
     * @param saldo Saldo actual en cuenta
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Método SET para actualizar el interes que se aplicara en las operaciones
     * en cuenta
     *
     * @param tipoInteres Interes aplicado a las operaciones a cuenta
     */
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    //----------------------------------------------------------- METODOS
    //------------ INGRESAR
    /**
     * Método para ingresar cantidades en la cuenta. Modifica el saldo.
     *
     * @param cantidad Cantidad a ingresar en el salgo
     * @throws Exception Si la cantidad a ingresar es menor de cero
     */
    public void ingresar(double cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("No se puede ingresar una cantidad negativa");
        }
        setSaldo(getSaldo() + cantidad);
    }

    //------------ RETIRAR
    /**
     * Método para retirar cantidades en la cuenta. Comprobamos que la cantidad
     * a retirar no sea negativa ni superior al saldo disponible Modifica el
     * saldo.
     *
     * @param cantidad Cantidad a retirar de salgo
     * @throws Exception Si la cantidad a retirar es negativa o si es mayor al
     * saldo
     */
    public void retirar(double cantidad) throws Exception {
        if (cantidad <= 0) {
            throw new Exception("No se puede retirar una cantidad negativa");
        }
        if (getSaldo() < cantidad) {
            throw new Exception("No se hay suficiente saldo");
        }
        setSaldo(getSaldo() - cantidad);
    }

    //------------ COBRO DE FACTURAS
    /**
     * Metodo para cobrar facturas
     *
     * @param tipo Tipo de factura a cobrar
     * @param cantidad Importe de la factura
     * @throws Exception Si la cantidad está fuera del rango para esa factura o
     * si es mayor al saldo disponible
     */
    public void cobroFactura(String tipo, double cantidad) throws Exception {
        double min = 0.01, max = 0;

        //Asignamos valores según el tipo de factura a cobrar
        switch (tipo) {
            case "Seguro":
                max = 125;
                break;
            case "Luz":
                min = Double.MAX_VALUE * -1;
                max = 200;
                break;
            case "Agua":
                max = 200;
                break;
            case "Alquiler":
                max = 400;
                break;
            default:
                throw new Exception("Tipo de factura erronea");
        }

        //Comprobamos si el importe esta dentro del rago para esa factura
        //Posteriormente comprobamos si hay saldo suficiente para realizar la operacion
        if (cantidad >= min && cantidad <= max) {
            if (getSaldo() >= cantidad) {
                setSaldo(getSaldo() - cantidad);
            } else {
                throw new Exception("No se hay suficiente saldo");
            }
        } else {
            throw new Exception("Cantidad Incorrecta");
        }
    }

    //----------------------------------------------------------- hashCode y equals
    /**
     * Clase heredada de Object.  
     * Devulve un número entero que 'identifica' al objeto.
     * 
     * @return hash - Número entero propio que cada objeto.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.cuenta);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.tipoInteres) ^ (Double.doubleToLongBits(this.tipoInteres) >>> 32));
        return hash;
    }

    /**
     * Metodo heredado de Object.
     * Compara referencias entre dos objetos.
     * 
     * @param obj Objeto con el que vamos a comparar
     * @return boolean - Nos devolverá true si los objetos son iguales.
     */    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CCuenta other = (CCuenta) obj;
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tipoInteres) != Double.doubleToLongBits(other.tipoInteres)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.cuenta, other.cuenta);
    }
  
}
