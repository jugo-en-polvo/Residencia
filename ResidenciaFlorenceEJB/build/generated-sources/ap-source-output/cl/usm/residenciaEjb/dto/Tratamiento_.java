package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Medicamento;
import cl.usm.residenciaEjb.dto.Residente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-29T16:29:21")
@StaticMetamodel(Tratamiento.class)
public class Tratamiento_ { 

    public static volatile SingularAttribute<Tratamiento, String> hora;
    public static volatile SingularAttribute<Tratamiento, Double> dosis;
    public static volatile SingularAttribute<Tratamiento, Medicamento> medicamento;
    public static volatile SingularAttribute<Tratamiento, Long> id_tratamiento;
    public static volatile SingularAttribute<Tratamiento, Residente> residente;

}