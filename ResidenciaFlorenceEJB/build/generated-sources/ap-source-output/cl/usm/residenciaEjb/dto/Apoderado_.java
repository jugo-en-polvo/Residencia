package cl.usm.residenciaEjb.dto;

import cl.usm.residenciaEjb.dto.Residente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-20T22:42:42")
@StaticMetamodel(Apoderado.class)
public class Apoderado_ { 

    public static volatile SingularAttribute<Apoderado, String> direccion_apoderado;
    public static volatile SingularAttribute<Apoderado, String> rut_apoderado;
    public static volatile SingularAttribute<Apoderado, String> nombre_apoderado;
    public static volatile SingularAttribute<Apoderado, String> fono_apoderado;
    public static volatile ListAttribute<Apoderado, Residente> residentes;

}