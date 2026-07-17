package tienda.modelo;

public interface IEstrategiaDescuento {

    // Contrato: calcular descuento según estrategia
    double calcularDescuento(double precio);
    String getNombreEstrategia();
}