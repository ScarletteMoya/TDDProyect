package main;

public class Azucarero {
    private int cantidadAzucar;

    public Azucarero(int cantidadAzucar) {
        this.cantidadAzucar = cantidadAzucar;
    }

    public boolean hasAzucar(int cantidad) {
        return cantidadAzucar >= cantidad;
    }

    public void giveAzucar(int cantidad) {
        if (hasAzucar(cantidad)) {
            cantidadAzucar -= cantidad;
        }
    }

    public int getCantidadAzucar() {
        return cantidadAzucar;
    }
}