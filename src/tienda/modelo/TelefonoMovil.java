package tienda.modelo;

public class TelefonoMovil extends Producto {

    private String marca;
    private double pulgadas;

    // Constructor parametrizado completo
    public TelefonoMovil(String codigo, String nombre, double precio,
                         String marca, double pulgadas) {
        super(codigo, nombre, precio);
        setMarca(marca);
        setPulgadas(pulgadas);
    }

    // Constructor alternativo usando this()
    public TelefonoMovil(String codigo, String nombre, double precio) {
        this(codigo, nombre, precio, "Sin marca", 6.0);
        System.out.println("Teléfono creado con valores por defecto.");
    }

    // Getters
    public String getMarca()    {
        return marca; 
    }
    public double getPulgadas() {
        return pulgadas; 
    }

    // Setters con validación
    public void setMarca(String marca) {
        if (marca == null || marca.isEmpty()) {
            System.out.println("Error: La marca no puede estar vacía.");
            this.marca = "Sin marca";
        } else {
            this.marca = marca;
        }
    }

    public void setPulgadas(double pulgadas) {
        if (pulgadas <= 0) {
            System.out.println("Error: Las pulgadas deben ser mayor a 0.");
            this.pulgadas = 5.0;
        } else {
            this.pulgadas = pulgadas;
        }
    }

    // Sobreescritura: descuento del 10% para teléfonos
    @Override
    public double calcularDescuento() {
        return getPrecio() * 0.10;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("=== Teléfono Móvil ===");
        System.out.println("Código   : " + getCodigo());
        System.out.println("Nombre   : " + getNombre());
        System.out.println("Precio   : $" + getPrecio());
        System.out.println("Marca    : " + marca);
        System.out.println("Pantalla : " + pulgadas + " pulgadas");
    }
}