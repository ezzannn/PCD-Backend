package models;

import com.avaje.ebean.annotation.Sql;

import javax.persistence.Entity;

/**
 * Created by Dell on 18/04/2015.
 */
@Entity
@Sql
public class ObjectifsCsd {
    Long csd_id;
    Long produit_id;
    Long objectif;
    Long realisation;
}
