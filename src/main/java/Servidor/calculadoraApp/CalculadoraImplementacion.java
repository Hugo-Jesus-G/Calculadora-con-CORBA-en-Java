package Servidor.calculadoraApp;

import org.omg.CORBA.ORB;

public class CalculadoraImplementacion extends calculadoraPOA{
    private ORB orb;

    // Creando una instancia de orb
    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    public double sumar(double num1, double num2) {
        return num1 + num2;
    }

    public double restar(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicacion(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divicion(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        }
        return num1 / num2;
    }

    public double exponencial(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public double seno(double angle) {
        return Math.sin(angle);
    }

    public double coseno(double angle) {
        return Math.cos(angle);
    }

    public double tangente(double angle) {
        return Math.tan(angle);
    }

    // Metodo que enviara
    public void shutdown() {
        orb.shutdown(false);
    }
}
