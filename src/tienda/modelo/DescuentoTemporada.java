package tienda.modelo;

public class DescuentoTemporada implements IEstrategiaDescuento {

    private double porcentaje;

    public DescuentoTemporada(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularDescuento(double precio) {
        return precio * (porcentaje / 100);
    }

    @Override
    public String getNombreEstrategia() {
        return "Descuento por temporada (" + porcentaje + "%)";
    }
}