package tienda.modelo;

public class DescuentoClientePreferente implements IEstrategiaDescuento {

    private double porcentaje;

    public DescuentoClientePreferente(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularDescuento(double precio) {
        return precio * (porcentaje / 100);
    }

    @Override
    public String getNombreEstrategia() {
        return "Descuento cliente preferente (" + porcentaje + "%)";
    }
}