package pe.edu.upc.greatstorage.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.greatstorage.model.Ingreso;
import pe.edu.upc.greatstorage.repository.IIngresoDAO;
import pe.edu.upc.greatstorage.service.IIngresoService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class IngresoServiceImpl implements IIngresoService {

    @Autowired
    private IIngresoDAO data;

    @Override
    public List<Ingreso> Mostrar() {
        return data.findAllByOrderByIdIngresoAsc();
    }

    @Override
    public Long Guardar(Ingreso ingreso) {
        //ingreso.setFechaIngreso(LocalDate.now());
        long rpta = 0;
        Ingreso i = data.save(ingreso);

        if (!i.equals(null)) {
            rpta = 1;
        }

        return rpta;
    }
}
