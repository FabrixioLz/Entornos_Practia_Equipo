package JunitTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Proveedor;

class ProveedorTest {

    private Proveedor proveedor;

    @BeforeEach
    void setUp() {
        proveedor = new Proveedor();
    }

    @Test
    void testConstructorPorDefecto() {
        assertEquals(0, proveedor.getIdProveedor());
        assertEquals("ERROR", proveedor.getDni());
        assertEquals("ERROR", proveedor.getNombre());
        assertEquals("ERROR", proveedor.getTipo());
        assertEquals("ERROR", proveedor.getDireccion());
        assertEquals("ERROR", proveedor.getTelefono());
    }

    @Test
    void testConstructorConParametros() {
        proveedor = new Proveedor(1, "12345678A", "Proveedor A", "Tipo A", "Calle Falsa 123", "123456789");

        assertEquals(1, proveedor.getIdProveedor());
        assertEquals("12345678A", proveedor.getDni());
        assertEquals("Proveedor A", proveedor.getNombre());
        assertEquals("Tipo A", proveedor.getTipo());
        assertEquals("Calle Falsa 123", proveedor.getDireccion());
        assertEquals("123456789", proveedor.getTelefono());
    }

    @Test
    void testSettersYGetters() {
        proveedor.setIdProveedor(2);
        proveedor.setDni("87654321B");
        proveedor.setNombre("Proveedor B");
        proveedor.setTipo("Tipo B");
        proveedor.setDireccion("Avenida Siempre Viva 456");
        proveedor.setTelefono("987654321");

        assertEquals(2, proveedor.getIdProveedor());
        assertEquals("87654321B", proveedor.getDni());
        assertEquals("Proveedor B", proveedor.getNombre());
        assertEquals("Tipo B", proveedor.getTipo());
        assertEquals("Avenida Siempre Viva 456", proveedor.getDireccion());
        assertEquals("987654321", proveedor.getTelefono());
    }

}
