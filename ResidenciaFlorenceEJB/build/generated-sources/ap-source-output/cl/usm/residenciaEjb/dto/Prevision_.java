package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Residente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-04T15:22:39")
@StaticMetamodel(Prevision.class)
public class Prevision_ { 

    public static volatile SingularAttribute<Prevision, String> nombre_prevision;
    public static volatile SingularAttribute<Prevision, Long> id_prevision;
    public static volatile ListAttribute<Prevision, Residente> residentes;

}