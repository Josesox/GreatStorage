package pe.edu.upc.greatstorage.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greatstorage.model.DetalleIngreso;
import pe.edu.upc.greatstorage.repository.IDetalleIngresoDAO;
import pe.edu.upc.greatstorage.service.IDetalleIngresoService;

@Service
public class DetalleIngresoImpl implements IDetalleIngresoService {
    @Autowired
    private IDetalleIngresoDAO data;

    @Override
    public Long AñadirDetalle(DetalleIngreso detalleingreso) {
        long rpta = 0;
        DetalleIngreso di = data.save(detalleingreso);

        if (!di.equals(null)) {
            rpta = 1;
        }

        return rpta;
    }
}
