package pe.edu.upc.greatstorage.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.upc.greatstorage.model.DetalleIngreso;

//detalle
public interface IDetalleIngresoDAO extends CrudRepository<DetalleIngreso,Long> {}
