package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Control_Medico;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-04T15:22:39")
@StaticMetamodel(Lugar.class)
public class Lugar_ { 

    public static volatile SingularAttribute<Lugar, String> fono_lugar;
    public static volatile SingularAttribute<Lugar, Long> id_lugar;
    public static volatile ListAttribute<Lugar, Control_Medico> controlesMedicos;
    public static volatile SingularAttribute<Lugar, String> direccion_lugar;
    public static volatile SingularAttribute<Lugar, String> nombre_lugar;

}