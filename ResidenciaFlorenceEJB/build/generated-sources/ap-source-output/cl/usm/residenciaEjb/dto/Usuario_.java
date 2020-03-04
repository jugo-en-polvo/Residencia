package cl.usm.residenciaEjb.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-04T04:36:15")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, Integer> estado;
    public static volatile SingularAttribute<Usuario, String> nombre_usuario;
    public static volatile SingularAttribute<Usuario, String> rut_usuario;
    public static volatile SingularAttribute<Usuario, Integer> nivel_acceso;

}