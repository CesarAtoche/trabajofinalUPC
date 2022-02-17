package trabajofinal;


import java.util.Scanner;

public class trabajofinal {
    public static void main(String[] args) {

        String nombres1[] = new String[10];
        String marcas1[] = new String[10];
        String placas1[] = new String[10];
        double tarifa_hora1[] = new double[10];
        int numero_horas1[] = new int[10];

        char rpta = 'S';
        int i = 0;

        Scanner scanner = new Scanner(System.in);
        while(i< nombres1.length && rpta == 'S'){
            System.out.print("Ingrese su Nombre: ");
            nombres1[i] = scanner.nextLine();
            System.out.print("Ingrese la marca de auto que desea alquilar: ");
            marcas1[i] = scanner.nextLine();
            System.out.print("Ingrese la placa del auto: ");
            placas1[i]= scanner.nextLine();
            System.out.print("Ingrese las horas que desea alquilar: ");
            numero_horas1[i]=scanner.nextInt();
            System.out.print("Ingrese la tarifa por horas: ");
            tarifa_hora1[i]=scanner.nextDouble();
            System.out.print("¿Desea ingresar mas datos? (S/N): ");
            char rpta1 = scanner.next().charAt(0);
            scanner.nextLine();
            rpta = Character.toUpperCase(rpta1);
            i++;
        }
        String nombres[] = new String[i];
        String marcas[] = new String[i];
        String placas[] = new String[i];
        double tarifa_hora[] = new double[i];
        int numero_horas[] = new int[i];


        System.arraycopy(nombres1, 0, nombres, 0, i);
        System.arraycopy(marcas1, 0, marcas, 0, i);
        System.arraycopy(placas1, 0, placas, 0, i);
        System.arraycopy(tarifa_hora1, 0, tarifa_hora, 0, i);
        System.arraycopy(numero_horas1, 0, numero_horas, 0, i);


        double subtotal[] = new double[i];
        double igvs[] = new double[i];
        double total[] = new double[i];


        calculoTotalSinIGV(tarifa_hora, numero_horas, subtotal);
        calculoIGV(subtotal, igvs);
        calculoTotalConIGV(subtotal, igvs, total);
        total_dia(total);
        ingreso_promedio(total);
        imprimir_reporte(nombres, marcas, placas, tarifa_hora, numero_horas, subtotal, igvs, total);

    }

    public static void calculoTotalSinIGV(double tarifa_hora[], int numero_horas[], double subtotal[]) {

        for (int i = 0; i < subtotal.length; i++) {
            subtotal[i] = tarifa_hora[i] * numero_horas[i];

        }

    }

    public static void calculoIGV(double subtotal[], double igvs[]) {
        for (int i = 0; i < subtotal.length; i++) {
            igvs[i] = 0.18 * subtotal[i];

        }

    }

    public static void calculoTotalConIGV(double subtotal[], double igvs[], double total[]) {
        for (int i = 0; i < subtotal.length; i++) {
            total[i] = subtotal[i] + igvs[i];
        }
    }

    public static double total_dia(double total[]) {
        double monto_diario = 0;
        for (int i = 0; i < total.length; i++) {
            monto_diario = monto_diario + total[i];
        }

        return monto_diario;
    }

    public static double ingreso_promedio(double total[]) {
        double promedio;
        promedio = total_dia(total) / total.length;
        return promedio;
    }

    public static void imprimir_reporte(String nombres[], String marcas[], String placas[], double tarifa_hora[], int numero_horas[], double subtotal[], double igvs[], double total[]) {

        System.out.println("************************************");
        System.out.println("******** Datos del Cliente *********");

        System.out.println("************************************");

        for (int i = 0; i < subtotal.length; i++) {

            System.out.println("************************************");
            System.out.println("CLIENTE " + (i + 1) + ":");
            System.out.println("************************************");
            System.out.println("Nombre: " + nombres[i]);
            System.out.println("Marca: " + marcas[i]);
            System.out.println("Placa: " + placas[i]);
            System.out.println("Tarifa por Hora: " + tarifa_hora[i]);
            System.out.println("Numero de Horas Alquiladas: " + numero_horas[i]);
            System.out.println("Subtotal: " + subtotal[i]);
            System.out.println("IGV: " + igvs[i]);
            System.out.println("Total a Pagar: " + total[i]);


        }
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("*** REPORTE DE ALQUILER DE AUTOS ***");
        System.out.println("************************************");
        System.out.println("El monto total del dia es: " + total_dia(total));
        System.out.println("El monto total promedio es: " + Math.round(ingreso_promedio(total)*100.0)/100.0);
        System.out.println("************************************");

    }

    }


