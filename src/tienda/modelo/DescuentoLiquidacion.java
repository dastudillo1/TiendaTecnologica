package tienda.modelo;

public class DescuentoLiquidacion implements IEstrategiaDescuento {

    private double porcentaje;

    public DescuentoLiquidacion(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularDescuento(double precio) {
        return precio * (porcentaje / 100);
    }

    @Override
    public String getNombreEstrategia() {
        return "Descuento por liquidación (" + porcentaje + "%)";
    }
}