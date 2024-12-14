package cl.duoc.app.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VentaDTOTest {

    @Test
    void testGettersAndSetters() {
        VentaDTO ventaDTO = new VentaDTO();

        ventaDTO.setId(1L);
        ventaDTO.setUsuarioId(10L);
        ventaDTO.setProductos("Producto1, Producto2");
        ventaDTO.setFecha(LocalDateTime.of(2024, 12, 14, 15, 30));
        ventaDTO.setTotal(new BigDecimal("1500.75"));

        assertEquals(1L, ventaDTO.getId());
        assertEquals(10L, ventaDTO.getUsuarioId());
        assertEquals("Producto1, Producto2", ventaDTO.getProductos());
        assertEquals(LocalDateTime.of(2024, 12, 14, 15, 30), ventaDTO.getFecha());
        assertEquals(new BigDecimal("1500.75"), ventaDTO.getTotal());
    }

    @Test
    void testAllArgsConstructor() {
        VentaDTO ventaDTO = new VentaDTO(
                2L,
                20L,
                "Producto3",
                LocalDateTime.of(2024, 12, 14, 16, 0),
                new BigDecimal("2000.50")
        );

        assertEquals(2L, ventaDTO.getId());
        assertEquals(20L, ventaDTO.getUsuarioId());
        assertEquals("Producto3", ventaDTO.getProductos());
        assertEquals(LocalDateTime.of(2024, 12, 14, 16, 0), ventaDTO.getFecha());
        assertEquals(new BigDecimal("2000.50"), ventaDTO.getTotal());
    }

    @Test
    void testNoArgsConstructor() {
        VentaDTO ventaDTO = new VentaDTO();

        assertNull(ventaDTO.getId());
        assertNull(ventaDTO.getUsuarioId());
        assertNull(ventaDTO.getProductos());
        assertNull(ventaDTO.getFecha());
        assertNull(ventaDTO.getTotal());
    }

    @Test
    void testToString() {
        VentaDTO ventaDTO = new VentaDTO(
                3L,
                30L,
                "Producto4",
                LocalDateTime.of(2024, 12, 14, 17, 0),
                new BigDecimal("3000.25")
        );

        String toString = ventaDTO.toString();

        assertNotNull(toString);
        assertTrue(toString.contains("id=3"));
        assertTrue(toString.contains("usuarioId=30"));
        assertTrue(toString.contains("productos=Producto4"));
        assertTrue(toString.contains("fecha=2024-12-14T17:00"));
        assertTrue(toString.contains("total=3000.25"));
    }

}
