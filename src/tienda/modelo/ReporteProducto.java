package tienda.modelo;

public class ReporteProducto {

    // Responsabilidad única: generar reportes de productos
    public void generarReporte(Producto producto) {
        System.out.println("=== Reporte de Producto ===");
        System.out.println("Código       : " + producto.getCodigo());
        System.out.println("Nombre       : " + producto.getNombre());
        System.out.println("Precio actual: $" + producto.getPrecio());
        System.out.println("Descuento    : $" + producto.calcularDescuento());
        System.out.println("Precio final : $" +
                           (producto.getPrecio() - producto.calcularDescuento()));
    }

    public void generarReporteCatalogo(Producto[] catalogo) {
        System.out.println("=== Reporte General del Catálogo ===");
        System.out.println("Total de productos: " + catalogo.length);
        System.out.println();
        double totalCatalogo = 0;
        for (Producto p : catalogo) {
            System.out.println("- " + p.getNombre() +
                               " | Precio: $" + p.getPrecio() +
                               " | Descuento: $" + p.calcularDescuento());
            totalCatalogo += p.getPrecio();
        }
        System.out.println();
        System.out.println("Valor total del catálogo: $" + totalCatalogo);
    }
}