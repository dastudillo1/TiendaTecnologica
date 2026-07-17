package tienda.modelo;

public class GestorDescuento {

    // Clase contexto que utiliza la estrategia
    private IEstrategiaDescuento estrategia;

    public GestorDescuento(IEstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    // Permite cambiar la estrategia dinámicamente
    public void setEstrategia(IEstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public void aplicarDescuento(Producto producto) {
        double descuento = estrategia.calcularDescuento(producto.getPrecio());
        double precioFinal = producto.getPrecio() - descuento;
        System.out.println("Producto   : " + producto.getNombre());
        System.out.println("Estrategia : " + estrategia.getNombreEstrategia());
        System.out.println("Precio     : $" + producto.getPrecio());
        System.out.println("Descuento  : $" + descuento);
        System.out.println("Precio final: $" + precioFinal);
        System.out.println();
    }
}