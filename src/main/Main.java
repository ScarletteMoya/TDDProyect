package main;

import java.util.Scanner;

public class Main {

    private static final int PRECIO_VASO_PEQ = 10;
    private static final int PRECIO_VASO_MED = 15;
    private static final int PRECIO_VASO_GRAN = 20;
    private static final int PRECIO_CAFE_ONZ = 2;
    private static final int PRECIO_AZUCAR_CDA = 1;

    public static MaquinaDeCafe crearMaquinaDeCafe() {
        Cafetera cafetera = new Cafetera(50);
        Vaso vasosPequeno = new Vaso(5, 3);
        Vaso vasosMediano = new Vaso(5, 5);
        Vaso vasosGrande = new Vaso(5, 7);
        Azucarero azucarero = new Azucarero(20);

        MaquinaDeCafe maquina = new MaquinaDeCafe();
        maquina.setCafetera(cafetera);
        maquina.setVasosPequeno(vasosPequeno);
        maquina.setVasosMediano(vasosMediano);
        maquina.setVasosGrande(vasosGrande);
        maquina.setAzucarero(azucarero);

        return maquina;
    }

    public static void main(String[] args) {
        MaquinaDeCafe maquina = crearMaquinaDeCafe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido a la Máquina de Café!");

        while (true) {
            mostrarInventarioConPrecios(maquina);

            System.out.println("\nElige tamaño de vaso:");
            System.out.println("1 - Pequeño");
            System.out.println("2 - Mediano");
            System.out.println("3 - Grande");
            System.out.println("0 - Salir");

            int opcion = pedirEntero(scanner, "Ingresa el número de tu opción:", 0, 3);
            if (opcion == -1) continue;

            if (opcion == 0) {
                System.out.println("Gracias por usar la máquina. ¡Hasta luego!");
                break;
            }

            Vaso vaso = null;
            String tipo = "";
            int precioVaso = 0;

            switch (opcion) {
                case 1:
                    vaso = maquina.getTipoDeVaso("pequeno");
                    tipo = "pequeño";
                    precioVaso = PRECIO_VASO_PEQ;
                    break;
                case 2:
                    vaso = maquina.getTipoDeVaso("mediano");
                    tipo = "mediano";
                    precioVaso = PRECIO_VASO_MED;
                    break;
                case 3:
                    vaso = maquina.getTipoDeVaso("grande");
                    tipo = "grande";
                    precioVaso = PRECIO_VASO_GRAN;
                    break;
            }

            if (vaso == null) {
                System.out.println("Error inesperado: vaso no seleccionado correctamente.");
                continue;
            }

            int cantidadVasos = pedirEntero(scanner, "¿Cuántos vasos quieres?", 1, Integer.MAX_VALUE);
            if (cantidadVasos == -1) continue;

            int cucharadasAzucar = pedirEntero(scanner, "¿Cuántas cucharadas de azúcar quieres?", 0, Integer.MAX_VALUE);
            if (cucharadasAzucar == -1) continue;

            System.out.println("Procesando tu pedido...");

            String resultado = maquina.getVasoDeCafe(vaso, cantidadVasos, cucharadasAzucar);

            switch (resultado) {
                case "Felicitaciones":
                    int totalPrecio = precioVaso * cantidadVasos +
                            vaso.getContenido() * PRECIO_CAFE_ONZ * cantidadVasos +
                            cucharadasAzucar * PRECIO_AZUCAR_CDA;

                    System.out.println("Sirviendo " + cantidadVasos + " vaso(s) de café tamaño " + tipo + ".");
                    System.out.println("Añadiendo " + cucharadasAzucar + " cucharada(s) de azúcar.");
                    System.out.println("El total a pagar es: $" + totalPrecio);
                    System.out.println("Disfruta tu café ☕");
                    break;

                case "No hay Vasos":
                    System.out.println("Lo siento, no hay suficientes vasos.");
                    break;
                case "No hay Cafe":
                    System.out.println("Lo siento, no hay suficiente café.");
                    break;
                case "No hay Azucar":
                    System.out.println("Lo siento, no hay suficiente azúcar.");
                    break;
                default:
                    System.out.println("Error inesperado.");
                    break;
            }
        }

        scanner.close();
    }

    private static int pedirEntero(Scanner scanner, String mensaje, int minimo, int maximo) {
        System.out.println(mensaje);
        String linea = scanner.nextLine().trim();
        int valor;
        try {
            valor = Integer.parseInt(linea);
            if (valor < minimo || valor > maximo) {
                System.out.println("Cantidad inválida, debe estar entre " + minimo + " y " + maximo + ". Intenta de nuevo.");
                return -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("Número inválido, intenta de nuevo.");
            return -1;
        }
        return valor;
    }

    private static void mostrarInventarioConPrecios(MaquinaDeCafe maquina) {
        System.out.println("\nInventario y precios actuales:");
        System.out.println("Vasos pequeños: " + maquina.getVasosPequeno().getCantidadVasos() + " (Precio c/u: $" + PRECIO_VASO_PEQ + ")");
        System.out.println("Vasos medianos: " + maquina.getVasosMediano().getCantidadVasos() + " (Precio c/u: $" + PRECIO_VASO_MED + ")");
        System.out.println("Vasos grandes: " + maquina.getVasosGrande().getCantidadVasos() + " (Precio c/u: $" + PRECIO_VASO_GRAN + ")");
        System.out.println("Café disponible: " + maquina.getCafetera().getCantidadCafe() + " oz (Precio oz: $" + PRECIO_CAFE_ONZ + ")");
        System.out.println("Azúcar disponible: " + maquina.getAzucarero().getCantidadAzucar() + " cucharadas (Precio c/u: $" + PRECIO_AZUCAR_CDA + ")");
    }
}
