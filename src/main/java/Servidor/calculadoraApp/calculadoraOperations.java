package Servidor.calculadoraApp;


/**
* calculadoraApp/calculadoraOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from calculadora.idl
* martes 2 de abril de 2024 12:40:53 PM CST
*/

public interface calculadoraOperations 
{
  double sumar (double num1, double num2);
  double restar (double num1, double num2);
  double multiplicacion (double num1, double num2);
  double divicion (double num1, double num2);
  double exponencial (double base, double exponente);
  double seno (double angle);
  double coseno (double angle);
  double tangente (double angle);
  void shutdown ();
} // interface calculadoraOperations