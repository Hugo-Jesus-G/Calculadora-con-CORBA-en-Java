package Servidor.calculadoraApp;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Server {
    public static void main(String[] args) {


        try {
            ORB orb = ORB.init(args, null);
            // Inicializacion de conexion
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            // Abrir el root del POA
            rootpoa.the_POAManager().activate();

            CalculadoraImplementacion CalculadoraImpl = new CalculadoraImplementacion();
            // Implementacion referencia
            CalculadoraImpl.setORB(orb);
            // SetearORB

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(CalculadoraImpl);
            calculadora href = calculadoraHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Damos bienvenida al servicio
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Calculadora";
            // Se envia el nombre para que reciba la interface

            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);
            System.out.println("Servidor de calculadora listo, en espera...");

            // Confirmación de servidor conectado
            orb.run();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("CERRANDO SERVIDOR...");
    }
}





