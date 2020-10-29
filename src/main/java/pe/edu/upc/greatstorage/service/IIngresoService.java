package pe.edu.upc.greatstorage.service;

import pe.edu.upc.greatstorage.model.Ingreso;

import java.util.List;

public interface IIngresoService {
    public List<Ingreso> Mostrar();
    public Long Guardar(Ingreso ingreso);
}
