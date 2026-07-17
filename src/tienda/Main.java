package tienda;

import tienda.modelo.AccesorioElectronico;
import tienda.modelo.Computador;
import tienda.modelo.TelefonoMovil;
import tienda.modelo.Producto;
import tienda.modelo.ReporteProducto;

public class Main {

    public static void main(String[] args) {

        System.out.println("================================================");
        System.out.println("   SISTEMA DE GESTIÓN - TIENDA TECNOLÓGICA      ");
        System.out.println("================================================");

        // Pregunta 1: jerarquía de clases
        System.out.println("\n--- Pregunta 1: Jerarquía de clases ---");
        Computador comp1 = new Computador("COMP-001", "MacBook Pro",
                                           1500000, "Apple M3", 16);
        TelefonoMovil tel1 = new TelefonoMovil("TEL-001", "iPhone 15",
                                                999000, "Apple", 6.1);
        AccesorioElectronico acc1 = new AccesorioElectronico("ACC-001",
                                    "Audífonos Bluetooth", 89000,
                                    "Audífono", "Universal");
        comp1.mostrarInformacion();
        System.out.println();
        tel1.mostrarInformacion();
        System.out.println();
        acc1.mostrarInformacion();

        // Pregunta 2: constructores con super() y this()
        System.out.println("\n--- Pregunta 2: Constructores super() y this() ---");

        // Constructor completo con super()
        System.out.println("\n> Constructor completo (super):");
        Computador comp2 = new Computador("COMP-002", "Dell XPS",
                                           1200000, "Intel i7", 32);
        comp2.mostrarInformacion();

        // Constructor alternativo con this()
        System.out.println("\n> Constructor alternativo (this):");
        Computador comp3 = new Computador("COMP-003", "Lenovo IdeaPad",
                                           750000);
        comp3.mostrarInformacion();

        System.out.println();
        TelefonoMovil tel2 = new TelefonoMovil("TEL-002", "Samsung Basic",
                                                350000);
        tel2.mostrarInformacion();

        System.out.println();
        AccesorioElectronico acc2 = new AccesorioElectronico("ACC-002",
                                    "Cable USB-C", 15000);
        acc2.mostrarInformacion();

        // Pregunta 3 3: sobreescritura de métodos
        System.out.println("\n--- Pregunta 3: Sobreescritura de métodos ---");

        System.out.println("\n> Descuentos calculados por tipo de producto:");
        System.out.println("Computador  - Descuento 15%: $" + comp1.calcularDescuento());
        System.out.println("Teléfono    - Descuento 10%: $" + tel1.calcularDescuento());
        System.out.println("Accesorio   - Descuento 20%: $" + acc1.calcularDescuento());

        System.out.println("\n> Precio final después del descuento:");
        System.out.println("MacBook Pro  : $" +
                        (comp1.getPrecio() - comp1.calcularDescuento()));
        System.out.println("iPhone 15    : $" +
                        (tel1.getPrecio() - tel1.calcularDescuento()));
        System.out.println("Audífonos    : $" +
                        (acc1.getPrecio() - acc1.calcularDescuento()));

        // Pregunta 4 4: polimorfismo
        System.out.println("\n--- Pregunta 4: Polimorfismo ---");

        // Array de referencias tipo base Producto
        Producto[] catalogo = new Producto[5];
        catalogo[0] = comp1;
        catalogo[1] = tel1;
        catalogo[2] = acc1;
        catalogo[3] = new Computador("COMP-004", "HP Pavilion",
                                    890000, "Intel i5", 8);
        catalogo[4] = new TelefonoMovil("TEL-003", "Xiaomi Redmi",
                                        299000, "Xiaomi", 6.5);

        System.out.println("\n> Catálogo completo de productos:");
        System.out.println("Total de productos: " + catalogo.length);
        System.out.println();

        for (tienda.modelo.Producto p : catalogo) {
            p.mostrarInformacion();
            System.out.println("Descuento aplicado: $" + p.calcularDescuento());
            System.out.println("Precio final      : $" +
                            (p.getPrecio() - p.calcularDescuento()));
            System.out.println();
        }

        // Pregunta 5: interfaz IGestionable
        System.out.println("\n--- Pregunta 5: Interfaz IGestionable ---");

        // Uso de la interfaz con distintos tipos de productos
        System.out.println("\n> Generando reportes:");
        for (tienda.modelo.Producto p : catalogo) {
            System.out.println(p.generarReporte());
        }

        System.out.println("\n> Aplicando ofertas:");
        System.out.println("Oferta en MacBook Pro (10%):");
        comp1.aplicarOferta(10);

        System.out.println("Oferta en iPhone 15 (15%):");
        tel1.aplicarOferta(15);

        System.out.println("Oferta en Audífonos (25%):");
        acc1.aplicarOferta(25);

        System.out.println("\n> Reportes actualizados tras oferta:");
        System.out.println(comp1.generarReporte());
        System.out.println(tel1.generarReporte());
        System.out.println(acc1.generarReporte());

        // Pregunta 6: principio SOLID - SRP
        System.out.println("\n--- Pregunta 6: Principio SOLID (SRP) ---");

        ReporteProducto reporte = new ReporteProducto();

        System.out.println("\n> Reporte individual:");
        reporte.generarReporte(comp1);
        System.out.println();
        reporte.generarReporte(tel1);
        System.out.println();
        reporte.generarReporte(acc1);

        System.out.println();
        System.out.println("> Reporte general del catálogo:");
        reporte.generarReporteCatalogo(catalogo);

        // Pregunta 7: patrón Strategy
        System.out.println("\n--- Pregunta 7: Patrón Strategy ---");

        // Crear estrategias de descuento
        tienda.modelo.IEstrategiaDescuento temporada =
            new tienda.modelo.DescuentoTemporada(20);
        tienda.modelo.IEstrategiaDescuento liquidacion =
            new tienda.modelo.DescuentoLiquidacion(35);
        tienda.modelo.IEstrategiaDescuento preferente =
            new tienda.modelo.DescuentoClientePreferente(12);

        // Crear gestor con estrategia inicial
        tienda.modelo.GestorDescuento gestor =
            new tienda.modelo.GestorDescuento(temporada);

        // Aplicar estrategia de temporada
        System.out.println("\n> Estrategia: Descuento por temporada");
        gestor.aplicarDescuento(comp1);
        gestor.aplicarDescuento(tel1);

        // Cambiar estrategia dinámicamente a liquidación
        System.out.println("> Estrategia: Descuento por liquidación");
        gestor.setEstrategia(liquidacion);
        gestor.aplicarDescuento(acc1);
        gestor.aplicarDescuento(comp2);

        // Cambiar estrategia dinámicamente a cliente preferente
        System.out.println("> Estrategia: Descuento cliente preferente");
        gestor.setEstrategia(preferente);
        gestor.aplicarDescuento(tel1);
        gestor.aplicarDescuento(acc1);
    }
}