package models;

import com.avaje.ebean.annotation.Sql;

import javax.persistence.Entity;

/**
 * Created by Dell on 18/04/2015.
 */
@Entity
@Sql
public class ObjectifsRgd {
    Long rgd_id;
    Long produit_id;
    Long objectif;
    Long realisation;
}
