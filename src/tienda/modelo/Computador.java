package tienda.modelo;

public class Computador extends Producto {

    private String procesador;
    private int ramGB;

    // Constructor parametrizado completo
    public Computador(String codigo, String nombre, double precio,
                      String procesador, int ramGB) {
        super(codigo, nombre, precio);
        setProcesador(procesador);
        setRamGB(ramGB);
    }

    // Constructor alternativo usando this()
    public Computador(String codigo, String nombre, double precio) {
        this(codigo, nombre, precio, "Sin especificar", 8);
        System.out.println("Computador creado con valores por defecto.");
    }

    // Getters
    public String getProcesador() {
        return procesador; 
    }
    public int getRamGB()         {
        return ramGB; 
    }

    // Setters con validación
    public void setProcesador(String procesador) {
        if (procesador == null || procesador.isEmpty()) {
            System.out.println("Error: El procesador no puede estar vacío.");
            this.procesador = "Sin especificar";
        } else {
            this.procesador = procesador;
        }
    }

    public void setRamGB(int ramGB) {
        if (ramGB <= 0) {
            System.out.println("Error: La RAM debe ser mayor a 0.");
            this.ramGB = 4;
        } else {
            this.ramGB = ramGB;
        }
    }
    // Sobreescritura: descuento del 15% para computadores
    @Override
    public double calcularDescuento() {
    return getPrecio() * 0.15;
    }    

    @Override
    public void mostrarInformacion() {
        System.out.println("=== Computador ===");
        System.out.println("Código     : " + getCodigo());
        System.out.println("Nombre     : " + getNombre());
        System.out.println("Precio     : $" + getPrecio());
        System.out.println("Procesador : " + procesador);
        System.out.println("RAM        : " + ramGB + " GB");
    }
}