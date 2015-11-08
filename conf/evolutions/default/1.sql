# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table boutique (
  id                        bigint not null,
  nom                       varchar(255),
  nb_conseillers            integer,
  pond                      float,
  rgb_id                    bigint,
  constraint pk_boutique primary key (id))
;

create table chef_departement_direct (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  login                     varchar(255),
  salaire                   float,
  passwd                    varchar(255),
  tel                       bigint,
  pond                      float,
  dc_id                     bigint,
  constraint pk_chef_departement_direct primary key (id))
;

create table chef_departement_indirect (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  login                     varchar(255),
  salaire                   float,
  passwd                    varchar(255),
  tel                       bigint,
  pond                      float,
  dc_id                     bigint,
  constraint pk_chef_departement_indirect primary key (id))
;

create table chef_service_distribution (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  login                     varchar(255),
  salaire                   float,
  passwd                    varchar(255),
  tel                       bigint,
  pond                      float,
  cdi_id                    bigint,
  constraint pk_chef_service_distribution primary key (id))
;

create table chef_service_magasin (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  login                     varchar(255),
  salaire                   float,
  passwd                    varchar(255),
  tel                       bigint,
  pond                      float,
  cdi_id                    bigint,
  constraint pk_chef_service_magasin primary key (id))
;

create table chef_service_pdv (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  login                     varchar(255),
  salaire                   float,
  passwd                    varchar(255),
  tel                       bigint,
  pond                      float,
  cdi_id                    bigint,
  constraint pk_chef_service_pdv primary key (id))
;

create table directeur_commercial (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  login                     varchar(255),
  passwd                    varchar(255),
  tel                       bigint,
  constraint pk_directeur_commercial primary key (id))
;

create table franchise (
  id                        bigint not null,
  nom                       varchar(255),
  nb_conseillers            integer,
  pond                      float,
  rgb_id                    bigint,
  constraint pk_franchise primary key (id))
;

create table objectifs (
  produit_id                bigint,
  vendeur_id                bigint,
  objectif                  bigint,
  realisation               bigint,
  constraint pk_objectifs primary key (produit_id, vendeur_id))
;

create table produit (
  id                        bigint not null,
  type                      varchar(255),
  constraint pk_produit primary key (id))
;

create table responsable_regional_boutique (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  login                     varchar(255),
  salaire                   float,
  passwd                    varchar(255),
  tel                       bigint,
  pond                      float,
  zone                      varchar(255),
  cdd_id                    bigint,
  constraint pk_responsable_regional_boutique primary key (id))
;

create table responsable_regional_distribution (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  passwd                    varchar(255),
  login                     varchar(255),
  salaire                   float,
  tel                       bigint,
  pond                      float,
  zone                      varchar(255),
  csd_id                    bigint,
  constraint pk_responsable_regional_distribu primary key (id))
;

create table responsable_regional_pdv (
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  login                     varchar(255),
  salaire                   float,
  passwd                    varchar(255),
  tel                       bigint,
  pond                      float,
  zone                      varchar(255),
  csp_id                    bigint,
  constraint pk_responsable_regional_pdv primary key (id))
;

create table vendeur (
  dtype                     varchar(30) not null,
  id                        bigint not null,
  nom                       varchar(255),
  prenom                    varchar(255),
  login                     varchar(255),
  salaire                   float,
  passwd                    varchar(255),
  tel                       bigint,
  pond                      float,
  rgd_id                    bigint,
  rgp_id                    bigint,
  boutique_id               bigint,
  franchise_id              bigint,
  constraint pk_vendeur primary key (id))
;

create sequence boutique_seq;

create sequence chef_departement_direct_seq;

create sequence chef_departement_indirect_seq;

create sequence chef_service_distribution_seq;

create sequence chef_service_magasin_seq;

create sequence chef_service_pdv_seq;

create sequence directeur_commercial_seq;

create sequence franchise_seq;

create sequence objectifs_seq;

create sequence produit_seq;

create sequence responsable_regional_boutique_seq;

create sequence responsable_regional_distribution_seq;

create sequence responsable_regional_pdv_seq;

create sequence vendeur_seq;

alter table boutique add constraint fk_boutique_rgb_1 foreign key (rgb_id) references responsable_regional_boutique (id);
create index ix_boutique_rgb_1 on boutique (rgb_id);
alter table chef_departement_direct add constraint fk_chef_departement_direct_dc_2 foreign key (dc_id) references directeur_commercial (id);
create index ix_chef_departement_direct_dc_2 on chef_departement_direct (dc_id);
alter table chef_departement_indirect add constraint fk_chef_departement_indirect_d_3 foreign key (dc_id) references directeur_commercial (id);
create index ix_chef_departement_indirect_d_3 on chef_departement_indirect (dc_id);
alter table chef_service_distribution add constraint fk_chef_service_distribution_c_4 foreign key (cdi_id) references chef_departement_indirect (id);
create index ix_chef_service_distribution_c_4 on chef_service_distribution (cdi_id);
alter table chef_service_magasin add constraint fk_chef_service_magasin_cdi_5 foreign key (cdi_id) references chef_departement_indirect (id);
create index ix_chef_service_magasin_cdi_5 on chef_service_magasin (cdi_id);
alter table chef_service_pdv add constraint fk_chef_service_pdv_cdi_6 foreign key (cdi_id) references chef_departement_indirect (id);
create index ix_chef_service_pdv_cdi_6 on chef_service_pdv (cdi_id);
alter table franchise add constraint fk_franchise_rgb_7 foreign key (rgb_id) references responsable_regional_boutique (id);
create index ix_franchise_rgb_7 on franchise (rgb_id);
alter table objectifs add constraint fk_objectifs_vendeur_8 foreign key (vendeur_id) references vendeur (id);
create index ix_objectifs_vendeur_8 on objectifs (vendeur_id);
alter table objectifs add constraint fk_objectifs_produit_9 foreign key (produit_id) references produit (id);
create index ix_objectifs_produit_9 on objectifs (produit_id);
alter table responsable_regional_boutique add constraint fk_responsable_regional_bouti_10 foreign key (cdd_id) references chef_departement_direct (id);
create index ix_responsable_regional_bouti_10 on responsable_regional_boutique (cdd_id);
alter table responsable_regional_distribution add constraint fk_responsable_regional_distr_11 foreign key (csd_id) references chef_service_distribution (id);
create index ix_responsable_regional_distr_11 on responsable_regional_distribution (csd_id);
alter table responsable_regional_pdv add constraint fk_responsable_regional_pdv_c_12 foreign key (csp_id) references chef_service_pdv (id);
create index ix_responsable_regional_pdv_c_12 on responsable_regional_pdv (csp_id);
alter table vendeur add constraint fk_vendeur_rgd_13 foreign key (rgd_id) references responsable_regional_distribution (id);
create index ix_vendeur_rgd_13 on vendeur (rgd_id);
alter table vendeur add constraint fk_vendeur_rgp_14 foreign key (rgp_id) references responsable_regional_pdv (id);
create index ix_vendeur_rgp_14 on vendeur (rgp_id);
alter table vendeur add constraint fk_vendeur_boutique_15 foreign key (boutique_id) references boutique (id);
create index ix_vendeur_boutique_15 on vendeur (boutique_id);
alter table vendeur add constraint fk_vendeur_franchise_16 foreign key (franchise_id) references franchise (id);
create index ix_vendeur_franchise_16 on vendeur (franchise_id);



# --- !Downs

drop table if exists boutique cascade;

drop table if exists chef_departement_direct cascade;

drop table if exists chef_departement_indirect cascade;

drop table if exists chef_service_distribution cascade;

drop table if exists chef_service_magasin cascade;

drop table if exists chef_service_pdv cascade;

drop table if exists directeur_commercial cascade;

drop table if exists franchise cascade;

drop table if exists objectifs cascade;

drop table if exists produit cascade;

drop table if exists responsable_regional_boutique cascade;

drop table if exists responsable_regional_distribution cascade;

drop table if exists responsable_regional_pdv cascade;

drop table if exists vendeur cascade;

drop sequence if exists boutique_seq;

drop sequence if exists chef_departement_direct_seq;

drop sequence if exists chef_departement_indirect_seq;

drop sequence if exists chef_service_distribution_seq;

drop sequence if exists chef_service_magasin_seq;

drop sequence if exists chef_service_pdv_seq;

drop sequence if exists directeur_commercial_seq;

drop sequence if exists franchise_seq;

drop sequence if exists objectifs_seq;

drop sequence if exists produit_seq;

drop sequence if exists responsable_regional_boutique_seq;

drop sequence if exists responsable_regional_distribution_seq;

drop sequence if exists responsable_regional_pdv_seq;

drop sequence if exists vendeur_seq;

