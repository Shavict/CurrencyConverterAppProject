import java.text.DecimalFormat;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        Object[] options = {"Convertidor De Divisas", "Cambiar Temperatura", "Salir"};

        int choice = JOptionPane.showOptionDialog(null,
                "¿Qué deseas hacer?",
                "Conversor",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 2) {
            JOptionPane.showMessageDialog(null, "Programa cerrado");
            System.exit(0);
        } else if (choice == 0) {
            JOptionPane.showMessageDialog(null, "Has seleccionado: Convertidor De Divisas");
            DecimalFormat formatearDivisa = new DecimalFormat("#.##");
            boolean continuarPrograma = true;

            while (continuarPrograma) {
                String[] opciones = {
                    "Quetzal a USDolar", "USDolar a Quetzal",
                    "Quetzal a Euro", "Euro a Quetzal",
                    "Quetzal a Libras Esterlinas", "Libras Esterlinas a Quetzal",
                    "Quetzal a yen", "Yen a Quetzal",
                    "Quetzal a won-SC", "Won-SC a Quetzal"
                };

                String cambio = (String) JOptionPane.showInputDialog(null, "Elija una opción:", "Conversor de Moneda",
                        JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

                if (cambio != null) {
                    String input = JOptionPane.showInputDialog(null, "Ingrese Cantidad:");

                    double cantidad;
                    try {
                        cantidad = Double.parseDouble(input);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor no válido");
                        continue;
                    }

                    double resultado = 0;

                    if (cambio.equals("Quetzal a USDolar")) {
                        resultado = cantidad / 7.85;
                    } else if (cambio.equals("USDolar a Quetzal")) {
                        resultado = cantidad * 7.85;
                    } else if (cambio.equals("Quetzal a Euro")) {
                        resultado = cantidad / 8.68;
                    } else if (cambio.equals("Euro a Quetzal")) {
                        resultado = cantidad * 8.68;
                    } else if (cambio.equals("Quetzal a Libras Esterlinas")) {
                        resultado = cantidad / 10.06;
                    } else if (cambio.equals("Libras Esterlinas a Quetzal")) {
                        resultado = cantidad * 10.66;
                    } else if (cambio.equals("Quetzal a yen")) {
                        resultado = cantidad / 18.00;
                    } else if (cambio.equals("Yen a Quetzal")) {
                        resultado = cantidad * 18.00;
                    } else if (cambio.equals("Quetzal a won-SC")) {
                        resultado = cantidad / 163.;
                    } else if (cambio.equals("Won-SC a Quetzal")) {
                        resultado = cantidad *  163;
                    }

                    String mensajeResultado = formatearDivisa.format(resultado);
                    String unidadOrigen = cambio.substring(0, cambio.indexOf(" a "));
                    String unidadDestino = cambio.substring(cambio.indexOf(" a ") + 3);
                    JOptionPane.showMessageDialog(null, cantidad + " " + unidadOrigen + " son: " + mensajeResultado + " " + unidadDestino);

                    int confirma = JOptionPane.showOptionDialog(null, "¿Desea continuar usando el programa?", "Confirmar",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                    if (confirma == JOptionPane.NO_OPTION) {
                        continuarPrograma = false;
                        JOptionPane.showMessageDialog(null, "Programa Finalizado");
                    }
                } else {
                    continuarPrograma = false;
                }
            }
        } else if (choice == 1) {
            JOptionPane.showMessageDialog(null, "Has seleccionado: Cambiar Temperatura");

            DecimalFormat formatearTemperatura = new DecimalFormat("#.##");
            boolean continuarPrograma = true;

            while (continuarPrograma) {
                String[] opcionesTemp = {
                    "Celsius a Fahrenheit", "Fahrenheit a Celsius",
                    "Celsius a Kelvin", "Kelvin a Celsius"
                };

                String cambioTemp = (String) JOptionPane.showInputDialog(null, "Elija una opción:", "Conversor de Temperatura",
                        JOptionPane.QUESTION_MESSAGE, null, opcionesTemp, opcionesTemp[0]);

                if (cambioTemp != null) {
                    String inputTemp = JOptionPane.showInputDialog(null, "Ingrese la temperatura:");

                    double temperatura;
                    try {
                        temperatura = Double.parseDouble(inputTemp);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor no válido");
                        continue;
                    }

                    double resultadoTemp = 0;

                    if (cambioTemp.equals("Celsius a Fahrenheit")) {
                        resultadoTemp = (temperatura * 9 / 5) + 32;
                    } else if (cambioTemp.equals("Fahrenheit a Celsius")) {
                        resultadoTemp = (temperatura - 32) * 5 / 9;
                    } else if (cambioTemp.equals("Celsius a Kelvin")) {
                        resultadoTemp = temperatura + 273.15;
                    } else if (cambioTemp.equals("Kelvin a Celsius")) {
                        resultadoTemp = temperatura - 273.15;
                    }

                    String unidadOrigenTemp = cambioTemp.substring(0, cambioTemp.indexOf(" a "));
                    String unidadDestinoTemp = cambioTemp.substring(cambioTemp.indexOf(" a ") + 3);
                    JOptionPane.showMessageDialog(null, temperatura + " " + unidadOrigenTemp + " son: " + formatearTemperatura.format(resultadoTemp) + " " + unidadDestinoTemp);

                    int confirma = JOptionPane.showOptionDialog(null, "¿Desea continuar usando el programa?", "Confirmar",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                    if (confirma == JOptionPane.NO_OPTION) {
                        continuarPrograma = false;
                        JOptionPane.showMessageDialog(null, "Programa Finalizado");
                    }
                } else {
                    continuarPrograma = false;
                }
            }
        }
    }
}

