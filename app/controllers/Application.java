package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;
import models.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Application extends Controller {
    private static final Form<DirecteurCommercial> dcForm= Form.form(DirecteurCommercial.class);
    private static final Form<ChefDepartementDirect> cddForm= Form.form(ChefDepartementDirect.class);
    private static final Form<ChefServiceDistribution> csdForm= Form.form(ChefServiceDistribution.class);
    private static final Form<ResponsableRegionalBoutique> rrbForm= Form.form(ResponsableRegionalBoutique.class);
    private static final Form<ResponsableRegionalDistribution> rrdForm= Form.form(ResponsableRegionalDistribution.class);
    private static final Form<ChefDepartementIndirect> cdiForm= Form.form(ChefDepartementIndirect.class);
    private static final Form<ChefServicePdv> cspForm= Form.form(ChefServicePdv.class);
    private static final Form<ResponsableRegionalPdv> rrpForm= Form.form(ResponsableRegionalPdv.class);

    public static Result traitement_dc(){
        Form<DirecteurCommercial> boundForm = dcForm.bindFromRequest();
        String message0 = "";
        String message1 = "";
        String message2 = "";
        String message3 = "";
        DirecteurCommercial dc = null;
        if(boundForm.field("login").valueOr("").equals("")){
            message0="Vous devez saisir un login";
        }else if(boundForm.field("passwd").valueOr("").equals("")){
            message3="Vous devez saisir un password";
        }
        else{
            dc= boundForm.get();
            DirecteurCommercial dc1 = DirecteurCommercial.find().where().eq("login", dc.login).findUnique();
            if(dc1 == null){
                message1="login uncorrect";
            }else if(!dc.passwd.equals(dc1.passwd)){
                message2="password uncorrect";
            }
        }
        return ok(Outil.writeObject(dc, message0, message1, message2, message3));
    }

    //traitement en backend pour la connexion de chef de departement direct

    public static Result traitement_cdd(){
        Form<ChefDepartementDirect> boundForm = cddForm.bindFromRequest();
        String message0 = "";
        String message1 = "";
        String message2 = "";
        String message3 = "";
        ChefDepartementDirect cdd = null;
        if(boundForm.field("login").valueOr("").equals("")){
            message0="Vous devez saisir un login";
        }else if(boundForm.field("passwd").valueOr("").equals("")){
            message3="Vous devez saisir un password";
        }
        else{
            cdd= boundForm.get();
            ChefDepartementDirect cdd1 = ChefDepartementDirect.find().where().eq("login", cdd.login).findUnique();
            if(cdd1 == null){
                message1="login uncorrect";
            }else if(!cdd.passwd.equals(cdd1.passwd)){
                message2="password uncorrect";
            }
        }
        return ok(Outil.writeObject(cdd, message0, message1, message2, message3));
    }

    //traitement en backend pour la connexion de chef service distribution

    public static Result traitement_csd(){
        Form<ChefServiceDistribution> boundForm = csdForm.bindFromRequest();
        String message0 = "";
        String message1 = "";
        String message2 = "";
        String message3 = "";
        ChefServiceDistribution csd = null;
        if(boundForm.field("login").valueOr("").equals("")){
            message0="Vous devez saisir un login";
        }else if(boundForm.field("passwd").valueOr("").equals("")){
            message3="Vous devez saisir un password";
        }else{
            csd =boundForm.get();
            ChefServiceDistribution csd1 = ChefServiceDistribution.find().where().eq("login", csd.login).findUnique();
            if(csd1 == null){
                message1="login uncorrect";
            }else if(!csd.passwd.equals(csd1.passwd)){
                message2="password uncorrect";
            }
        }
        return ok(Outil.writeObject(csd, message0, message1, message2, message3));
    }

    //traitement en backend pour le responsable regionale boutique

    public static Result traitement_rrb(){
        Form<ResponsableRegionalBoutique> boundForm = rrbForm.bindFromRequest();
        String message0 = "";
        String message1 = "";
        String message2 = "";
        String message3 = "";
        ResponsableRegionalBoutique rrb = null;
        if(boundForm.field("login").valueOr("").equals("")){
            message0="Vous devez saisir un login";
        }else if(boundForm.field("passwd").valueOr("").equals("")){
            message3="Vous devez saisir un password";
        }else{
            rrb =boundForm.get();
            ResponsableRegionalBoutique rrb1 = ResponsableRegionalBoutique.find().where().eq("login", rrb.login).findUnique();
            if(rrb1 == null){
                message1="login uncorrect";
            }else if(!rrb.passwd.equals(rrb1.passwd)){
                message2="password uncorrect";
            }
        }
        return ok(Outil.writeObject(rrb, message0, message1, message2, message3));
    }

    //traitement en backend pour le responsable regionale distribution

    public static Result traitement_rrd() {
        Form<ResponsableRegionalDistribution> boundForm = rrdForm.bindFromRequest();
        String message0 = "";
        String message1 = "";
        String message2 = "";
        String message3 = "";
        ResponsableRegionalDistribution rrd = null;
        if(boundForm.field("login").valueOr("").equals("")){
            message0="Vous devez saisir un login";
        }else if(boundForm.field("passwd").valueOr("").equals("")){
            message3="Vous devez saisir un password";
        }else{
            rrd =boundForm.get();
            ResponsableRegionalDistribution rrd1 = ResponsableRegionalDistribution.find().where().eq("login", rrd.login).findUnique();
            if(rrd1 == null){
                message1="login uncorrect";
            }else if(!rrd.passwd.equals(rrd1.passwd)){
                message2="password uncorrect";
            }
        }
        return ok(Outil.writeObject(rrd, message0, message1, message2, message3));
    }

    //traitement en backend de connexion de chef departement indirect

    public static Result traitement_cdi(){
        Form<ChefDepartementIndirect> boundForm = cdiForm.bindFromRequest();
        String message0 = "";
        String message1 = "";
        String message2 = "";
        String message3 = "";
        ChefDepartementIndirect cdi = null;
        if(boundForm.field("login").valueOr("").equals("")){
            message0="Vous devez saisir un login";
        }else if(boundForm.field("passwd").valueOr("").equals("")){
            message3="Vous devez saisir un password";
        }else{
            cdi =boundForm.get();
            ChefDepartementIndirect cdi1 = ChefDepartementIndirect.find().where().eq("login", cdi.login).findUnique();
            if(cdi1 == null){
                message1="login uncorrect";
            }else if(!cdi.passwd.equals(cdi1.passwd)){
                message2="password uncorrect";
            }
        }
        return ok(Outil.writeObject(cdi, message0, message1, message2, message3));
    }

    //traitement en backend de connexion de chef service pdv

    public static Result traitement_csp(){
        Form<ChefServicePdv> boundForm = cspForm.bindFromRequest();
        String message0 = "";
        String message1 = "";
        String message2 = "";
        String message3 = "";
        ChefServicePdv csp = null;
        if(boundForm.field("login").valueOr("").equals("")){
            message0="Vous devez saisir un login";
        }else if(boundForm.field("passwd").valueOr("").equals("")){
            message3="Vous devez saisir un password";
        }else{
            csp =boundForm.get();
            ChefServicePdv csp1 = ChefServicePdv.find().where().eq("login", csp.login).findUnique();
            if(csp1 == null){
                message1="login uncorrect";
            }else if(!csp.passwd.equals(csp1.passwd)){
                message2="password uncorrect";
            }
        }
        return ok(Outil.writeObject(csp, message0, message1, message2, message3));
    }

    //traitement en backend de connexion de responsable regional pdv

    public static Result traitement_rrp(){
        Form<ResponsableRegionalPdv> boundForm = rrpForm.bindFromRequest();
        String message0 = "";
        String message1 = "";
        String message2 = "";
        String message3 = "";
        ResponsableRegionalPdv csp = null;
        if(boundForm.field("login").valueOr("").equals("")){
            message0="Vous devez saisir un login";
        }else if(boundForm.field("passwd").valueOr("").equals("")){
            message3="Vous devez saisir un password";
        }else{
            csp =boundForm.get();
            ResponsableRegionalPdv csp1 = ResponsableRegionalPdv.find().where().eq("login", csp.login).findUnique();
            if(csp1 == null){
                message1="login uncorrect";
            }else if(!csp.passwd.equals(csp1.passwd)){
                message2="password uncorrect";
            }
        }
        return ok(Outil.writeObject(csp, message0, message1, message2, message3));
    }

    public static Result objectif_dc(){
        List<Produit> produits = Produit.find().findList();
        return ok(Outil.writeObject(produits));
    }
    
    public static Result traitement_objectif_dc(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String message0 ="";
        String message1 ="";
        String message2="";
        String message3="";
        String cible = requestData.get("cible");
        requestData.get("objectif");
        try{
            Long.valueOf(requestData.get("objectif"));
        }catch (Exception e){
            message2="l objectif doit etre de type entier";
        }
        try{
            Long produit = Long.valueOf(requestData.get("produit"));
            List<Produit> produits = Produit.find().findList();
            Boolean test=false;
            for(Produit prod : produits){
                if(produit==prod.id){
                    test=true;
                    break;
                }
            }
            if(test==false){
                message0="le produit choisi n'est pas reconnu";
            }
        }catch (Exception e){
            message0="le produit doit etre de type entier";
        }

        if(!cible.trim().equals("cdd") && !cible.trim().equals("cdi")){
            message1="la cible choisi n'est pas reconnue";
        }
        if(message0.equals("") && message1.equals("") && message2.equals("")) {
            if (cible.equals("cdd")){
                try{
                    String sql = "update objectifsChef_departement_direct  set objectif=? where produit_id=? and cdd_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 0);
                    Ebean.execute(update);
                } catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            } else if(cible.equals("cdi")){
                try{
                    String sql = "update objectifsChef_departement_indirect  set objectif=? where produit_id=? and cdi_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 0);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
        }
        return ok(Outil.writeObject(message0, message1, message2, message3));
    }

    public static Result objectif_cdd(){
        List<Produit> produits = Produit.find().findList();
        return ok(Outil.writeObject(produits));
    }

    public static Result traitement_objectif_cdd(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String message0 ="";
        String message1 ="";
        String message2="";
        String message3="";
        String cible = requestData.get("cible");
        try{
            Long.valueOf(requestData.get("objectif"));
        }catch (Exception e){
            message2="l objectif doit etre de type entier";
        }
        try{
            Long produit = Long.valueOf(requestData.get("produit"));
            List<Produit> produits = Produit.find().findList();
            Boolean test=false;
            for(Produit prod : produits){
                if(produit==prod.id){
                    test=true;
                    break;
                }
            }
            if(test==false){
                message0="le produit choisi n'est pas reconnu";
            }
        }catch (Exception e){
            message0="le produit doit etre de type entier";
        }

        if(!cible.trim().equals("rgb1") && !cible.trim().equals("rgb2") && !cible.trim().equals("rgb3") && !cible.trim().equals("rgb4") && !cible.trim().equals("rgb5")){
            message1="la cible choisi n'est pas reconnue";
        }
        if(message0.equals("") && message1.equals("") && message2.equals("")) {
            if (cible.equals("rgb1")){
                try{
                    String sql = "update ObjectifsResponsable_regional_boutique  set objectif=? where produit_id=? and rgb_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 0);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("rgb2")){
                try{
                    String sql = "update ObjectifsResponsable_regional_boutique  set objectif=? where produit_id=? and rgb_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 1);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("rgb3")){
                try{
                    String sql = "update ObjectifsResponsable_regional_boutique  set objectif=? where produit_id=? and rgb_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 2);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("rgb4")){
                try{
                    String sql = "update ObjectifsResponsable_regional_boutique  set objectif=? where produit_id=? and rgb_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 3);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("rgb5")){
                try{
                    String sql = "update ObjectifsResponsable_regional_boutique  set objectif=? where produit_id=? and rgb_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 4);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
        }
        return ok(Outil.writeObject(message0, message1, message2, message3));
    }

    public static Result objectif_cdi(){
        List<Produit> produits = Produit.find().findList();
        return ok(Outil.writeObject(produits));
    }

    public static Result traitement_objectif_cdi(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String message0 ="";
        String message1 ="";
        String message2="";
        String message3="";
        String cible = requestData.get("cible");
        try{
            Long.valueOf(requestData.get("objectif"));
        }catch (Exception e){
            message2="l objectif doit etre de type entier";
        }
        try{
            Long produit = Long.valueOf(requestData.get("produit"));
            List<Produit> produits = Produit.find().findList();
            Boolean test=false;
            for(Produit prod : produits){
                if(produit==prod.id){
                    test=true;
                    break;
                }
            }
            if(test==false){
                message0="le produit choisi n'est pas reconnu";
            }
        }catch (Exception e){
            message0="le produit doit etre de type entier";
        }

        if(!cible.trim().equals("csp") && !cible.trim().equals("csd")){
            message1="la cible choisi n'est pas reconnue";
        }
        if(message0.equals("") && message1.equals("") && message2.equals("")) {
            if (cible.equals("csp")){
                try{
                    String sql = "update ObjectifsChef_service_pdv  set objectif=? where produit_id=? and csp_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 0);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("csd")){
                try{
                    String sql = "update ObjectifsChef_service_distribution  set objectif=? where produit_id=? and csd_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 0);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
        }
        return ok(Outil.writeObject(message0, message1, message2, message3));
    }

    public static Result objectif_csp(){
        List<Produit> produits = Produit.find().findList();
        return ok(Outil.writeObject(produits));
    }

    public static Result traitement_objectif_csp(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String message0 ="";
        String message1 ="";
        String message2="";
        String message3="";
        String cible = requestData.get("cible");
        try{
            Long.valueOf(requestData.get("objectif"));
        }catch (Exception e){
            message2="l objectif doit etre de type entier";
        }
        try{
            Long produit = Long.valueOf(requestData.get("produit"));
            List<Produit> produits = Produit.find().findList();
            Boolean test=false;
            for(Produit prod : produits){
                if(produit==prod.id){
                    test=true;
                    break;
                }
            }
            if(test==false){
                message0="le produit choisi n'est pas reconnu";
            }
        }catch (Exception e){
            message0="le produit doit etre de type entier";
        }

        if(!cible.trim().equals("rgp1") && !cible.trim().equals("rgp2") && !cible.trim().equals("rgp3") && !cible.trim().equals("rgp4") && !cible.trim().equals("rgp5")){
            message1="la cible choisi n'est pas reconnue";
        }
        if(message0.equals("") && message1.equals("") && message2.equals("")) {
            if (cible.equals("rgp1")){
                try{
                    String sql = "update ObjectifsResponsable_regional_pdv  set objectif=? where produit_id=? and rgp_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 0);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("rgp2")){
                try{
                    String sql = "update ObjectifsResponsable_regional_pdv  set objectif=? where produit_id=? and rgp_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 1);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("rgp3")){
                try{
                    String sql = "update ObjectifsResponsable_regional_pdv  set objectif=? where produit_id=? and rgp_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 2);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("rgp4")){
                try{
                    String sql = "update ObjectifsResponsable_regional_pdv  set objectif=? where produit_id=? and rgp_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 3);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("rgp5")){
                try{
                    String sql = "update ObjectifsResponsable_regional_pdv  set objectif=? where produit_id=? and rgp_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 4);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
        }
        return ok(Outil.writeObject(message0, message1, message2, message3));
    }

    public static Result objectif_csd(){
        List<Produit> produits = Produit.find().findList();
        return ok(Outil.writeObject(produits));
    }

    public static Result traitement_objectif_csd(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String message0 ="";
        String message1 ="";
        String message2="";
        String message3="";
        String cible = requestData.get("cible");
        try{
            Long.valueOf(requestData.get("objectif"));
        }catch (Exception e){
            message2="l objectif doit etre de type entier";
        }
        try{
            Long produit = Long.valueOf(requestData.get("produit"));
            List<Produit> produits = Produit.find().findList();
            Boolean test=false;
            for(Produit prod : produits){
                if(produit==prod.id){
                    test=true;
                    break;
                }
            }
            if(test==false){
                message0="le produit choisi n'est pas reconnu";
            }
        }catch (Exception e){
            message0="le produit doit etre de type entier";
        }
        if(!cible.trim().equals("rgd1") && !cible.trim().equals("rgd2") && !cible.trim().equals("rgd3") && !cible.trim().equals("rgd4") && !cible.trim().equals("rgd5")){
            message1="la cible choisi n'est pas reconnue";
        }
        if(message0.equals("") && message1.equals("") && message2.equals("")) {
            if (cible.equals("rgd1")){
                try{
                    String sql = "update ObjectifsResponsable_regional_distribution  set objectif=? where produit_id=? and rgd_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 0);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("rgd2")){
                try{
                    String sql = "update ObjectifsResponsable_regional_distribution  set objectif=? where produit_id=? and rgd_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 1);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("rgd3")){
                try{
                    String sql = "update ObjectifsResponsable_regional_distribution  set objectif=? where produit_id=? and rgd_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 2);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("rgd4")){
                try{
                    String sql = "update ObjectifsResponsable_regional_distribution  set objectif=? where produit_id=? and rgd_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 3);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
            else if (cible.equals("rgd5")){
                try{
                    String sql = "update ObjectifsResponsable_regional_distribution  set objectif=? where produit_id=? and rgd_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, 4);
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }
        }
        return ok(Outil.writeObject(message0, message1, message2, message3));
    }

    public static Result objectif_rrb(){
        List<Produit> produits = Produit.find().findList();
        List<Boutique> boutiques = Boutique.find().findList();
        List<Franchise> franchises = Franchise.find().findList();
        return ok(Outil.writeObject(produits, boutiques, franchises));
    }

    public static Result traitement_objectif_rrb(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String message0 ="";
        String message1 ="";
        String message2="";
        String message3="";
        String cible = requestData.field("cible").valueOr("");
        Boolean test1=false;
        Boolean test2=false;
        try{
            Long.valueOf(requestData.field("objectif").valueOr(""));
        }catch (Exception e){
            message2="l objectif doit etre de type entier";
        }
        try{
            Long produit = Long.valueOf(requestData.field("produit").valueOr(""));
            List<Produit> produits = Produit.find().findList();
            Boolean test=false;
            for(Produit prod : produits){
                if(produit==prod.id){
                    test=true;
                    break;
                }
            }
            if(test==false){
                message0="le produit choisi n'est pas reconnu";
            }
        }catch (Exception e){
            message0="le produit doit etre de type entier";
        }
        try{
            Long id = Long.valueOf(requestData.field("cible").valueOr(""));
            List<Boutique> boutiques = Boutique.find().findList();

            for(Boutique b : boutiques){
                if(id==b.id){
                    test1=true;
                    break;
                }
            }
            if(test1==false){
                List<Franchise> franchises = Franchise.find().findList();
                for(Franchise f : franchises){
                    if(id==f.id){
                        test2=true;
                        break;
                    }
                }
            }
            if(test1==false && test2==false){
                message1="la cible choisi n'est pas reconnu";
            }
        }catch (Exception e){
            message1="la cible doit etre de type entier";
        }
        if(message0.equals("") && message1.equals("") && message2.equals("")) {
            if(test1==true){
                try{
                    String sql = "update ObjectifsBoutique  set objectif=? where produit_id=? and boutique_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, Long.valueOf(cible));
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }else{
                try{
                    String sql = "update ObjectifsFranchise  set objectif=? where produit_id=? and franchise_id=?";
                    SqlUpdate update = Ebean.createSqlUpdate(sql);
                    update.setParameter(1, Long.valueOf(requestData.field("objectif").value()));
                    update.setParameter(2, Long.valueOf(requestData.field("produit").value()));
                    update.setParameter(3, Long.valueOf(cible));
                    Ebean.execute(update);
                }catch (Exception e){
                    message3="erreur d'ecriture au niveau de base de donné";
                }
            }

        }
        return ok(Outil.writeObject(message0, message1, message2, message3));
    }

    public static Result objectif_rrp(){
        List<Produit> produits = Produit.find().findList();
        List<Pdv> pdvs = Pdv.find.findList();
        return ok(Outil.writeObject(produits, pdvs));
    }

    public static Result traitement_objectif_rrp(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String message0 ="";
        String message1 ="";
        String message2="";
        String message3="";
        String cible = requestData.field("cible").valueOr("");
        try{
            Long.valueOf( requestData.field("objectif").valueOr(""));
        }catch (Exception e){
            message2="l objectif doit etre de type entier";
        }
        try{
            Long produit = Long.valueOf( requestData.field("produit").valueOr(""));
            List<Produit> produits = Produit.find().findList();
            Boolean test=false;
            for(Produit prod : produits){
                if(produit==prod.id){
                    test=true;
                    break;
                }
            }
            if(test==false){
                message0="le produit choisi n'est pas reconnu";
            }
        }catch (Exception e){
            message0="le produit doit etre de type entier";
        }
        try{
            Long id = Long.valueOf(requestData.field("cible").valueOr(""));
            List<Pdv> pdvs = Pdv.find.findList();
            Boolean test=false;
            for(Vendeur pdv : pdvs){
                if(id==pdv.id){
                    test=true;
                    break;
                }
            }
            if(test==false){
                message1="le pdv choisi n'est pas reconnu";
            }
        }catch (Exception e){
            message1="le pdv doit etre de type entier";
        }
        if(message0.equals("") && message1.equals("") && message2.equals("")) {
            try{
                Objectifs objectif = Objectifs.find().where().and(
                        com.avaje.ebean.Expr.eq("produit_id", Long.valueOf(requestData.field("produit").value())),
                        com.avaje.ebean.Expr.eq("vendeur_id", Long.valueOf(cible))
                ).findUnique();
                objectif.objectif=Long.valueOf(requestData.field("objectif").value());
                objectif.save();
            }catch (Exception e){
                message3="erreur d'ecriture au niveau de base de donné";
            }
        }
        return ok(Outil.writeObject(message0, message1, message2, message3));
    }

    public static Result objectif_rrd(){
        List<Produit> produits = Produit.find().findList();
        List<Distributeur> distributeurs = Distributeur.find.findList();
        return ok(Outil.writeObject(produits, distributeurs));
    }

    public static Result traitement_objectif_rrd(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String message0 ="";
        String message1 ="";
        String message2="";
        String message3="";
        String cible = requestData.field("cible").valueOr("");
        try{
            Long.valueOf(requestData.field("objectif").valueOr(""));
        }catch (Exception e){
            message2="l objectif doit etre de type entier";
        }
        try{
            Long produit = Long.valueOf(requestData.field("produit").valueOr(""));
            List<Produit> produits = Produit.find().findList();
            Boolean test=false;
            for(Produit prod : produits){
                if(produit==prod.id){
                    test=true;
                    break;
                }
            }
            if(test==false){
                message0="le produit choisi n'est pas reconnu";
            }
        }catch (Exception e){
            message0="le produit doit etre de type entier";
        }
        try{
            Long id = Long.valueOf(requestData.field("cible").valueOr(""));
            List<Distributeur> distributeurs = Distributeur.find.findList();
            Boolean test=false;
            for(Distributeur distributeur : distributeurs){
                if(id==distributeur.id){
                    test=true;
                    break;
                }
            }
            if(test==false){
                message1="la cible choisi n'est pas reconnu";
            }
        }catch (Exception e){
            message1="la cible doit etre de type entier";
        }
        if(message0.equals("") && message1.equals("") && message2.equals("")) {
            try{
                Objectifs objectif = Objectifs.find().where().and(
                        com.avaje.ebean.Expr.eq("produit_id", Long.valueOf(requestData.field("produit").value())),
                        com.avaje.ebean.Expr.eq("vendeur_id", Long.valueOf(cible))
                ).findUnique();
                objectif.objectif=Long.valueOf(requestData.field("objectif").value());
                objectif.save();
            }catch (Exception e){
                message3="erreur d'ecriture au niveau de base de donné";
            }
        }
        return ok(Outil.writeObject(message0, message1, message2, message3));
    }

    public static Result rapport(){
        //response().setHeader("Content-Disposition", "attachment; filename=rapport.xls");
        Excel.writeDocument();
        return ok(new java.io.File("tmp/rapport.xls"));
    }

}


