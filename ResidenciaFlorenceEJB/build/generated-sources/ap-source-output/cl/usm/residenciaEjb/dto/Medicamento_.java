package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Tratamiento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-29T16:29:21")
@StaticMetamodel(Medicamento.class)
public class Medicamento_ { 

    public static volatile SingularAttribute<Medicamento, String> tipo;
    public static volatile SingularAttribute<Medicamento, Long> id_medicamento;
    public static volatile SingularAttribute<Medicamento, String> nombre_generico;
    public static volatile SingularAttribute<Medicamento, Integer> stock_critico;
    public static volatile ListAttribute<Medicamento, Tratamiento> tratamientos;
    public static volatile SingularAttribute<Medicamento, String> nombre_fantasia;
    public static volatile SingularAttribute<Medicamento, Integer> stock;
    public static volatile SingularAttribute<Medicamento, String> detalle;

}