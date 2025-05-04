package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProveedorTest {

    @Test
    public void testConstructorPorDefecto() {
        Proveedor proveedor = new Proveedor();

        // Verificando que el constructor por defecto inicializa los valores correctamente
        assertEquals(0, proveedor.getIdProveedor());
        assertEquals("ERROR", proveedor.getDni());
        assertEquals("ERROR", proveedor.getNombre());
        assertEquals("ERROR", proveedor.getTipo());
        assertEquals("ERROR", proveedor.getDireccion());
        assertEquals("ERROR", proveedor.getTelefono());
    }

    @Test
    public void testConstructorConParametros() {
        // Verificando que el constructor por parámetros inicializa correctamente
        Proveedor proveedor = new Proveedor(1, "12345678A", "Distribuciones López", "Mayorista", "Calle Falsa 123", "600123456");

        assertEquals(1, proveedor.getIdProveedor());
        assertEquals("12345678A", proveedor.getDni());
        assertEquals("Distribuciones López", proveedor.getNombre());
        assertEquals("Mayorista", proveedor.getTipo());
        assertEquals("Calle Falsa 123", proveedor.getDireccion());
        assertEquals("600123456", proveedor.getTelefono());
    }

    @Test
    public void testSettersYGetters() {
        // Verificando que los setters y getters funcionan correctamente
        Proveedor proveedor = new Proveedor();

        proveedor.setIdProveedor(2);
        proveedor.setDni("87654321B");
        proveedor.setNombre("Proveedor S.A.");
        proveedor.setTipo("Minorista");
        proveedor.setDireccion("Avenida Siempre Viva 742");
        proveedor.setTelefono("611987654");

        assertEquals(2, proveedor.getIdProveedor());
        assertEquals("87654321B", proveedor.getDni());
        assertEquals("Proveedor S.A.", proveedor.getNombre());
        assertEquals("Minorista", proveedor.getTipo());
        assertEquals("Avenida Siempre Viva 742", proveedor.getDireccion());
        assertEquals("611987654", proveedor.getTelefono());
    }
}
