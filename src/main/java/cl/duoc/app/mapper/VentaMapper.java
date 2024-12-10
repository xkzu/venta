package cl.duoc.app.mapper;

import cl.duoc.app.dto.VentaDTO;
import cl.duoc.app.model.Venta;
import org.springframework.stereotype.Component;

@Component
public class VentaMapper {

    public static VentaDTO toDTO(Venta venta) {
        VentaDTO dto = new VentaDTO();
        dto.setId(venta.getId());
        dto.setUsuarioId(venta.getUsuarioId());
        dto.setProductos(venta.getProductos());
        dto.setFecha(venta.getFecha());
        dto.setTotal(venta.getTotal());
        return dto;
    }

    public static Venta toEntity(VentaDTO dto) {
        Venta venta = new Venta();
        venta.setId(dto.getId());
        venta.setUsuarioId(dto.getUsuarioId());
        venta.setProductos(dto.getProductos());
        venta.setFecha(dto.getFecha());
        venta.setTotal(dto.getTotal());
        return venta;
    }

}
