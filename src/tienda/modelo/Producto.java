package tienda.modelo;

public class Producto implements IGestionable {

    private String codigo;
    private String nombre;
    private double precio;

    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        setNombre(nombre);
        setPrecio(precio);
    }

    // Getters
    public String getCodigo() {
        return codigo; 
    }
    public String getNombre() {
        return nombre; 
    }
    public double getPrecio() {
        return precio; 
    }

    // Setters con validación
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            System.out.println("Error: El código no puede estar vacío.");
        } else {
            this.codigo = codigo;
        }
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            this.nombre = "Sin nombre";
        } else {
            this.nombre = nombre;
        }
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            System.out.println("Error: El precio no puede ser negativo.");
            this.precio = 0.0;
        } else {
            this.precio = precio;
        }
    }

    // Método base de descuento
    public double calcularDescuento() {
        return precio * 0.05;
    }

    // Implementación de IGestionable
    @Override
    public void aplicarOferta(double porcentaje) {
        double descuento = precio * (porcentaje / 100);
        precio = precio - descuento;
        System.out.println("Oferta aplicada: " + porcentaje +
                           "% | Nuevo precio: $" + precio);
    }

    @Override
    public String generarReporte() {
        return "Producto | Código: " + codigo +
               " | Nombre: " + nombre +
               " | Precio: $" + precio;
    }

    // Método base mostrarInformacion
    public void mostrarInformacion() {
        System.out.println("=== Producto ===");
        System.out.println("Código  : " + codigo);
        System.out.println("Nombre  : " + nombre);
        System.out.println("Precio  : $" + precio);
    }
}