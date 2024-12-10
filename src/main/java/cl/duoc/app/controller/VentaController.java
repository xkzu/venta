package cl.duoc.app.controller;

import cl.duoc.app.dto.VentaDTO;
import cl.duoc.app.mapper.VentaMapper;
import cl.duoc.app.model.Venta;
import cl.duoc.app.service.VentaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Log4j2
@RestController
@RequestMapping("/venta")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class VentaController {

    private final VentaService service;

    @Autowired
    public VentaController(VentaService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<VentaDTO> addVenta(@RequestBody VentaDTO ventaDto) {
        log.info("venta {}", ventaDto);
        try {
            Venta venta = VentaMapper.toEntity(ventaDto);
            venta.setFecha(LocalDateTime.now());
            log.info("venta {}", venta);
            return ResponseEntity.ok().body(VentaMapper.toDTO(service.add(venta)));
        } catch (Exception e) {
            log.error("Error al guardar la venta: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
