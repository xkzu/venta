package cl.duoc.app.service;

import cl.duoc.app.model.Venta;
import cl.duoc.app.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository repository;

    @Autowired
    public VentaServiceImpl(VentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Venta add(Venta venta) {
        return repository.save(venta);
    }
}
