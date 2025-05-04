package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductoTest {

    @Test
    public void testConstructorPorDefecto() {
        Producto producto = new Producto();

        assertEquals(0, producto.getIdProducto());
        assertEquals("ERROR", producto.getNombre());
        assertEquals(-1, producto.getCantidad());
        assertEquals(-1.1f, producto.getPrecio(), 0.01);
        assertEquals(0, producto.getIdProveedor());
    }

    @Test
    public void testConstructorConParametros() {
        Producto producto = new Producto(1, "Producto A", 100, 20.5f, 10);

        assertEquals(1, producto.getIdProducto());
        assertEquals("Producto A", producto.getNombre());
        assertEquals(100, producto.getCantidad());
        assertEquals(20.5f, producto.getPrecio(), 0.01);
        assertEquals(10, producto.getIdProveedor());
    }

    @Test
    public void testSettersYGetters() {
        Producto producto = new Producto();

        producto.setIdProducto(2);
        producto.setNombre("Producto B");
        producto.setCantidad(200);
        producto.setPrecio(30.75f);
        producto.setIdProveedor(20);

        assertEquals(2, producto.getIdProducto());
        assertEquals("Producto B", producto.getNombre());
        assertEquals(200, producto.getCantidad());
        assertEquals(30.75f, producto.getPrecio(), 0.01);
        assertEquals(20, producto.getIdProveedor());
    }

}
