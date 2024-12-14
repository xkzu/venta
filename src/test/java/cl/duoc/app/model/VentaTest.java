package cl.duoc.app.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VentaTest {

    @Test
    void testGettersAndSetters() {
        Venta venta = new Venta();

        venta.setId(1L);
        venta.setUsuarioId(10L);
        venta.setProductos("Producto1, Producto2");
        venta.setFecha(LocalDateTime.of(2024, 12, 14, 15, 30));
        venta.setTotal(new BigDecimal("1500.75"));

        assertEquals(1L, venta.getId());
        assertEquals(10L, venta.getUsuarioId());
        assertEquals("Producto1, Producto2", venta.getProductos());
        assertEquals(LocalDateTime.of(2024, 12, 14, 15, 30), venta.getFecha());
        assertEquals(new BigDecimal("1500.75"), venta.getTotal());
    }

    @Test
    void testAllArgsConstructor() {
        Venta venta = new Venta(
                2L,
                20L,
                "Producto3",
                LocalDateTime.of(2024, 12, 14, 16, 0),
                new BigDecimal("2000.50")
        );

        assertEquals(2L, venta.getId());
        assertEquals(20L, venta.getUsuarioId());
        assertEquals("Producto3", venta.getProductos());
        assertEquals(LocalDateTime.of(2024, 12, 14, 16, 0), venta.getFecha());
        assertEquals(new BigDecimal("2000.50"), venta.getTotal());
    }

    @Test
    void testNoArgsConstructor() {
        Venta venta = new Venta();

        assertNull(venta.getId());
        assertNull(venta.getUsuarioId());
        assertNull(venta.getProductos());
        assertNull(venta.getFecha());
        assertNull(venta.getTotal());
    }

    @Test
    void testToString() {
        Venta venta = new Venta(
                3L,
                30L,
                "Producto4",
                LocalDateTime.of(2024, 12, 14, 17, 0),
                new BigDecimal("3000.25")
        );

        String toString = venta.toString();

        assertNotNull(toString);
        assertTrue(toString.contains("id=3"));
        assertTrue(toString.contains("usuarioId=30"));
        assertTrue(toString.contains("productos=Producto4"));
        assertTrue(toString.contains("fecha=2024-12-14T17:00"));
        assertTrue(toString.contains("total=3000.25"));
    }

}
