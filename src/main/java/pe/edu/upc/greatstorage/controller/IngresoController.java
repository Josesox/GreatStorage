package pe.edu.upc.greatstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.greatstorage.model.DetalleIngreso;
import pe.edu.upc.greatstorage.model.Ingreso;
import pe.edu.upc.greatstorage.service.IDetalleIngresoService;
import pe.edu.upc.greatstorage.service.IIngresoService;
import pe.edu.upc.greatstorage.service.IProductoService;
import pe.edu.upc.greatstorage.service.ITipoComprobanteService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class IngresoController
{
    @Autowired
    private IIngresoService ingresoservice;

    @Autowired
    private IDetalleIngresoService detalleingresoservice;

    @Autowired
    private ITipoComprobanteService tipocomprobanteservice;

    @Autowired
    private IProductoService productoservice;

    @GetMapping("/ingresos")
    String Mostrar(Model model)
    {
        List<Ingreso> ingresos = ingresoservice.Mostrar();
        model.addAttribute("ingresos",ingresos);
        return "ingreso";
    }

    @GetMapping("/ingresos/nuevo")
    public String GuardarMethod(Model model)
    {
        model.addAttribute("ingreso", new Ingreso());
        model.addAttribute("listaproductos",productoservice.Mostrar());
        model.addAttribute("listatipocomprobante",tipocomprobanteservice.Mostrar());

        return "newingreso";
    }
}
