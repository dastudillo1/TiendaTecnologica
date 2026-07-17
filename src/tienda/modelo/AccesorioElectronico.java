package tienda.modelo;

public class AccesorioElectronico extends Producto {

    private String tipo;
    private String compatibilidad;

    // Constructor parametrizado completo
    public AccesorioElectronico(String codigo, String nombre, double precio,
                                 String tipo, String compatibilidad) {
        super(codigo, nombre, precio);
        setTipo(tipo);
        setCompatibilidad(compatibilidad);
    }

    // Constructor alternativo usando this()
    public AccesorioElectronico(String codigo, String nombre, double precio) {
        this(codigo, nombre, precio, "Sin tipo", "Universal");
        System.out.println("Accesorio creado con valores por defecto.");
    }

    // Getters
    public String getTipo()           {
        return tipo; 
    }
    public String getCompatibilidad() {
        return compatibilidad; 
    }

    // Setters con validación
    public void setTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            System.out.println("Error: El tipo no puede estar vacío.");
            this.tipo = "Sin tipo";
        } else {
            this.tipo = tipo;
        }
    }

    public void setCompatibilidad(String compatibilidad) {
        if (compatibilidad == null || compatibilidad.isEmpty()) {
            System.out.println("Error: La compatibilidad no puede estar vacía.");
            this.compatibilidad = "Universal";
        } else {
            this.compatibilidad = compatibilidad;
        }
    }

    // Sobreescritura: descuento del 20% para accesorios
    @Override
    public double calcularDescuento() {
        return getPrecio() * 0.20;
    }    

    @Override
    public void mostrarInformacion() {
        System.out.println("=== Accesorio Electrónico ===");
        System.out.println("Código         : " + getCodigo());
        System.out.println("Nombre         : " + getNombre());
        System.out.println("Precio         : $" + getPrecio());
        System.out.println("Tipo           : " + tipo);
        System.out.println("Compatibilidad : " + compatibilidad);
    }
}