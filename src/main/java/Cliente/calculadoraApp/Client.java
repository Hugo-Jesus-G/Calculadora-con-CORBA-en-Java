package Cliente.calculadoraApp;

import java.util.Scanner;

import Servidor.calculadoraApp.CalculadoraImplementacion;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class Client {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            ORB orb = ORB.init(args, null);
            // INICIALIZAR ORB PARA ENVIAR PETICION
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Calculadora";
            calculadora cal = calculadoraHelper.narrow(ncRef.resolve_str(name));
            System.out.println("------------MENU------------");
            int opcion;
            do {
                System.out.println("1. Sumar");
                System.out.println("2. Restar");
                System.out.println("3. Multiplicar");
                System.out.println("4. Dividir");
                System.out.println("5. Exponencial");
                System.out.println("6. Seno");
                System.out.println("7. Coseno");
                System.out.println("8. Tangente");
                System.out.println("9. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();

                double num1, num2, resultado;
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el primer número: ");
                        num1 = sc.nextDouble();
                        System.out.print("Ingrese el segundo número: ");
                        num2 = sc.nextDouble();
                        resultado = cal.sumar(num1, num2);
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 2:
                        System.out.print("Ingrese el primer número: ");
                        num1 = sc.nextDouble();
                        System.out.print("Ingrese el segundo número: ");
                        num2 = sc.nextDouble();
                        resultado = cal.restar(num1, num2);
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 3:
                        System.out.print("Ingrese el primer número: ");
                        num1 = sc.nextDouble();
                        System.out.print("Ingrese el segundo número: ");
                        num2 = sc.nextDouble();
                        resultado = cal.multiplicacion(num1, num2);
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 4:
                        System.out.print("Ingrese el primer número: ");
                        num1 = sc.nextDouble();
                        System.out.print("Ingrese el segundo número: ");
                        num2 = sc.nextDouble();
                        resultado = cal.divicion(num1, num2);
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 5:
                        System.out.print("Ingrese la base: ");
                        double base = sc.nextDouble();
                        System.out.print("Ingrese el exponente: ");
                        double exponente = sc.nextDouble();
                        resultado = cal.exponencial(base, exponente);
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 6:
                        System.out.print("Ingrese el ángulo en radianes: ");
                        double angle = sc.nextDouble();
                        resultado = cal.seno(angle);
                        System.out.println("Seno de " + angle + " radianes: " + resultado);
                        break;
                    case 7:
                        System.out.print("Ingrese el ángulo en radianes: ");
                        double angleCoseno = sc.nextDouble();
                        resultado = cal.coseno(angleCoseno);
                        System.out.println("Coseno de " + angleCoseno + " radianes: " + resultado);
                        break;
                    case 8:
                        System.out.print("Ingrese el ángulo en radianes: ");
                        double angleTangente = sc.nextDouble();
                        resultado = cal.tangente(angleTangente);
                        System.out.println("Tangente de " + angleTangente + " radianes: " + resultado);
                        break;

                    case 9:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 9);
            cal.shutdown();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }


}
