package tienda.modelo;

public interface IGestionable {

    // Contrato: aplicar oferta al producto
    void aplicarOferta(double porcentaje);

    // Contrato: generar reporte del producto
    String generarReporte();
}