package main;

public class MaquinaDeCafe {
    private Cafetera cafetera;
    private Vaso vasosPequeno;
    private Vaso vasosMediano;
    private Vaso vasosGrande;
    private Azucarero azucarero;

    public Cafetera getCafetera() {
        return cafetera;
    }

    public void setCafetera(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

    public Vaso getVasosPequeno() {
        return vasosPequeno;
    }

    public void setVasosPequeno(Vaso vasosPequeno) {
        this.vasosPequeno = vasosPequeno;
    }

    public Vaso getVasosMediano() {
        return vasosMediano;
    }

    public void setVasosMediano(Vaso vasosMediano) {
        this.vasosMediano = vasosMediano;
    }

    public Vaso getVasosGrande() {
        return vasosGrande;
    }

    public void setVasosGrande(Vaso vasosGrande) {
        this.vasosGrande = vasosGrande;
    }

    public Azucarero getAzucarero() {
        return azucarero;
    }

    public void setAzucarero(Azucarero azucarero) {
        this.azucarero = azucarero;
    }

    public Vaso getTipoDeVaso(String tipo) {
        return switch (tipo) {
            case "pequeno" -> vasosPequeno;
            case "mediano" -> vasosMediano;
            case "grande" -> vasosGrande;
            default -> null;
        };
    }

    public String getVasoDeCafe(Vaso vaso, int cantidadVasos, int cucharadasAzucar) {
        if (!vaso.hasVasos(cantidadVasos)) {
            return "No hay Vasos";
        }
        if (!cafetera.hasCafe(vaso.getContenido() * cantidadVasos)) {
            return "No hay Cafe";
        }
        if (!azucarero.hasAzucar(cucharadasAzucar)) {
            return "No hay Azucar";
        }

        vaso.giveVasos(cantidadVasos);
        cafetera.giveCafe(vaso.getContenido() * cantidadVasos);
        azucarero.giveAzucar(cucharadasAzucar);

        return "Felicitaciones";
    }
}