package com.movies.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-18T19:57:27")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, String> userdata;
    public static volatile SingularAttribute<Orders, Integer> id;
    public static volatile SingularAttribute<Orders, Date> ordertime;
    public static volatile SingularAttribute<Orders, String> products;

}