package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Prevision;
import cl.usm.residenciaEjb.dto.Residente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-24T12:23:13")
@StaticMetamodel(PrevisionNombreTipo.class)
public class PrevisionNombreTipo_ { 

    public static volatile SingularAttribute<PrevisionNombreTipo, String> descripcion;
    public static volatile SingularAttribute<PrevisionNombreTipo, String> nombre_prevision;
    public static volatile SingularAttribute<PrevisionNombreTipo, Long> id_prevision_nombre_tipo;
    public static volatile SingularAttribute<PrevisionNombreTipo, Prevision> prevision;
    public static volatile ListAttribute<PrevisionNombreTipo, Residente> residentes;

}