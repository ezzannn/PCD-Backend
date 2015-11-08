package models;

import com.avaje.ebean.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.util.List;

public class Excel {

    public static void writeDocument() {
        //tirage
        String sql = "SELECT vendeur.boutique_id, objectifs.produit_id, sum(objectifs.objectif) as objectif, sum(objectifs.realisation) as realisation FROM boutique, vendeur, objectifs WHERE boutique.id = vendeur.boutique_id AND vendeur.id = objectifs.vendeur_id GROUP BY vendeur.boutique_id, objectifs.produit_id";
        RawSql rawSql = RawSqlBuilder
                .parse(sql)
                .columnMapping("vendeur.boutique_id", "boutique_id")
                .columnMapping("objectifs.produit_id", "produit_id")
                .columnMapping("sum(objectifs.objectif)", "objectif")
                .columnMapping("sum(objectifs.realisation)", "realisation")
                .create();
        Query<ObjectifsBoutique> query = Ebean.find(ObjectifsBoutique.class).setRawSql(rawSql);

        String sql1 = "SELECT vendeur.franchise_id, objectifs.produit_id, sum(objectifs.objectif) as objectif, sum(objectifs.realisation) as realisation FROM franchise, vendeur, objectifs WHERE franchise.id = vendeur.franchise_id AND vendeur.id = objectifs.vendeur_id GROUP BY vendeur.franchise_id, objectifs.produit_id";
        RawSql rawSql1 = RawSqlBuilder
                .parse(sql1)
                .columnMapping("vendeur.franchise_id", "franchise_id")
                .columnMapping("objectifs.produit_id", "produit_id")
                .columnMapping("sum(objectifs.objectif)", "objectif")
                .columnMapping("sum(objectifs.realisation)", "realisation")
                .create();
        Query<ObjectifsFranchise> query1 = Ebean.find(ObjectifsFranchise.class).setRawSql(rawSql1);

        String sql2 = "SELECT boutique.rgb_id, objectifs.produit_id, sum(objectifs.objectif) as objectif, sum(objectifs.realisation) as realisation FROM responsable_regional_boutique, boutique, vendeur, objectifs WHERE responsable_regional_boutique.id = boutique.rgb_id AND boutique.id = vendeur.boutique_id AND vendeur.id = objectifs.vendeur_id GROUP BY boutique.rgb_id, objectifs.produit_id";
        RawSql rawSql2 = RawSqlBuilder
                .parse(sql2)
                .columnMapping("boutique.rgb_id", "rgb_id")
                .columnMapping("objectifs.produit_id", "produit_id")
                .columnMapping("sum(objectifs.objectif)", "objectif")
                .columnMapping("sum(objectifs.realisation)", "realisation")
                .create();
        Query<ObjectifsRgb> query2 = Ebean.find(ObjectifsRgb.class).setRawSql(rawSql2);

        String sql3 = "SELECT responsable_regional_boutique.cdd_id, objectifs.produit_id, sum(objectifs.objectif) as objectif, sum(objectifs.realisation) as realisation FROM chef_departement_direct, responsable_regional_boutique, boutique, vendeur, objectifs WHERE chef_departement_direct.id = responsable_regional_boutique.cdd_id AND responsable_regional_boutique.id = boutique.rgb_id AND boutique.id = vendeur.boutique_id AND vendeur.id = objectifs.vendeur_id GROUP BY responsable_regional_boutique.cdd_id, objectifs.produit_id";
        RawSql rawSql3 = RawSqlBuilder
                .parse(sql3)
                .columnMapping("responsable_regional_boutique.cdd_id", "cdd_id")
                .columnMapping("objectifs.produit_id", "produit_id")
                .columnMapping("sum(objectifs.objectif)", "objectif")
                .columnMapping("sum(objectifs.realisation)", "realisation")
                .create();
        Query<ObjectifsCdd> query3 = Ebean.find(ObjectifsCdd.class).setRawSql(rawSql3);

        String sql4 = "SELECT vendeur.rgd_id, objectifs.produit_id, sum(objectifs.objectif) as objectif, sum(objectifs.realisation) as realisation FROM responsable_regional_distribution, vendeur, objectifs  WHERE responsable_regional_distribution.id = vendeur.rgd_id AND vendeur.id = objectifs.vendeur_id GROUP BY vendeur.rgd_id, objectifs.produit_id";
        RawSql rawSql4 = RawSqlBuilder
                .parse(sql4)
                .columnMapping("vendeur.rgd_id", "rgd_id")
                .columnMapping("objectifs.produit_id", "produit_id")
                .columnMapping("sum(objectifs.objectif)", "objectif")
                .columnMapping("sum(objectifs.realisation)", "realisation")
                .create();
        Query<ObjectifsRgd> query4 = Ebean.find(ObjectifsRgd.class).setRawSql(rawSql4);

        String sql5 = "SELECT vendeur.rgp_id, objectifs.produit_id, sum(objectifs.objectif) as objectif, sum(objectifs.realisation) as realisation FROM responsable_regional_pdv, vendeur, objectifs WHERE responsable_regional_pdv.id = vendeur.rgp_id AND vendeur.id = objectifs.vendeur_id GROUP BY vendeur.rgp_id, objectifs.produit_id";
        RawSql rawSql5 = RawSqlBuilder
                .parse(sql5)
                .columnMapping("vendeur.rgp_id", "rgp_id")
                .columnMapping("objectifs.produit_id", "produit_id")
                .columnMapping("sum(objectifs.objectif)", "objectif")
                .columnMapping("sum(objectifs.realisation)", "realisation")
                .create();
        Query<ObjectifsRgp> query5 = Ebean.find(ObjectifsRgp.class).setRawSql(rawSql5);

        String sql6 = "SELECT responsable_regional_pdv.csp_id, objectifs.produit_id, sum(objectifs.objectif) as objectif, sum(objectifs.realisation) as realisation FROM chef_service_pdv, responsable_regional_pdv, vendeur, objectifs WHERE chef_service_pdv.id = responsable_regional_pdv.csp_id AND responsable_regional_pdv.id = vendeur.rgp_id AND vendeur.id = objectifs.vendeur_id GROUP BY responsable_regional_pdv.csp_id, objectifs.produit_id";
        RawSql rawSql6 = RawSqlBuilder
                .parse(sql6)
                .columnMapping("responsable_regional_pdv.csp_id", "csp_id")
                .columnMapping("objectifs.produit_id", "produit_id")
                .columnMapping("sum(objectifs.objectif)", "objectif")
                .columnMapping("sum(objectifs.realisation)", "realisation")
                .create();
        Query<ObjectifsCsp> query6 = Ebean.find(ObjectifsCsp.class).setRawSql(rawSql6);

        String sql7 = "SELECT responsable_regional_distribution.csd_id, objectifs.produit_id, sum(objectifs.objectif) as objectif, sum(objectifs.realisation) as realisation FROM chef_service_distribution, responsable_regional_distribution, vendeur, objectifs WHERE chef_service_distribution.id = responsable_regional_distribution.csd_id AND responsable_regional_distribution.id = vendeur.rgd_id AND vendeur.id = objectifs.vendeur_id GROUP BY responsable_regional_distribution.csd_id, objectifs.produit_id";
        RawSql rawSql7 = RawSqlBuilder
                .parse(sql7)
                .columnMapping("responsable_regional_distribution.csd_id", "csd_id")
                .columnMapping("objectifs.produit_id", "produit_id")
                .columnMapping("sum(objectifs.objectif)", "objectif")
                .columnMapping("sum(objectifs.realisation)", "realisation")
                .create();
        Query<ObjectifsCsd> query7 = Ebean.find(ObjectifsCsd.class).setRawSql(rawSql7);

        String sql8 = "SELECT chef_service_distribution.cdi_id, objectifs.produit_id, sum(objectifs.objectif) as objectif, sum(objectifs.realisation) as realisation FROM chef_departement_indirect, chef_service_distribution, responsable_regional_distribution, vendeur, objectifs WHERE chef_departement_indirect.id = chef_service_distribution.cdi_id AND chef_service_distribution.id = responsable_regional_distribution.csd_id AND responsable_regional_distribution.id = vendeur.rgd_id AND vendeur.id = objectifs.vendeur_id GROUP BY chef_service_distribution.cdi_id, objectifs.produit_id";
        RawSql rawSql8 = RawSqlBuilder
                .parse(sql8)
                .columnMapping("chef_service_distribution.cdi_id", "cdi_id")
                .columnMapping("objectifs.produit_id", "produit_id")
                .columnMapping("sum(objectifs.objectif)", "objectif")
                .columnMapping("sum(objectifs.realisation)", "realisation")
                .create();
        Query<ObjectifsCdi> query8 = Ebean.find(ObjectifsCdi.class).setRawSql(rawSql8);


        List<Objectifs> objectifs = Objectifs.find().findList();
        List<ChefDepartementDirect> cdds = ChefDepartementDirect.find().findList();
        List<ChefDepartementIndirect> cdis = ChefDepartementIndirect.find().findList();
        List<ChefServiceDistribution> csds = ChefServiceDistribution.find().findList();
        List<ChefServicePdv> csps = ChefServicePdv.find().findList();
        List<ResponsableRegionalBoutique> rgbs = ResponsableRegionalBoutique.find().findList();
        List<ResponsableRegionalDistribution> rgds = ResponsableRegionalDistribution.find().findList();
        List<ResponsableRegionalPdv> rgps = ResponsableRegionalPdv.find().findList();
        List<Boutique> boutiques = Boutique.find().findList();
        List<Franchise> franchises = Franchise.find().findList();
        List<Pdv> pdvs = Pdv.find.findList();
        List<Distributeur> distributeurs = Distributeur.find.findList();
        List<Conseiller> conseillers = Conseiller.find.findList();
        List<Produit> produits = Produit.find().findList();
        Integer nbProduit = Produit.find().findRowCount();
        Integer nbCdd = ChefDepartementDirect.find().findRowCount();
        Integer nbCdi = ChefDepartementIndirect.find().findRowCount();
        Integer nbCsd = ChefServiceDistribution.find().findRowCount();
        Integer nbCsp = ChefServicePdv.find().findRowCount();
        Integer nbRgb = ResponsableRegionalBoutique.find().findRowCount();
        Integer nbRgp = ResponsableRegionalPdv.find().findRowCount();
        Integer nbRgd = ResponsableRegionalDistribution.find().findRowCount();
        Integer nbBoutique = Boutique.find().findRowCount();
        Integer nbFranchise = Franchise.find().findRowCount();
        Integer nbPdv = Pdv.find().findRowCount();
        Integer nbDistributeur = Distributeur.find().findRowCount();
        Integer nbConseiller = Conseiller.find().findRowCount();
        Integer n = nbCdd + nbCdi + nbCsd + nbCsp + nbRgb + nbRgp + nbRgd + nbBoutique + nbFranchise + nbPdv + nbDistributeur + nbConseiller;
        //configuration preliminaire
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet");
        //first font
        Font font1 = workbook.createFont();
        font1.setBoldweight(Font.BOLDWEIGHT_BOLD);
        //second font
        Font font2 = workbook.createFont();
        font2.setColor(IndexedColors.DARK_BLUE.getIndex());
        font2.setBoldweight(Font.BOLDWEIGHT_BOLD);
        //style
        CellStyle style = workbook.createCellStyle();
        style.setFont(font1);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.ROSE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(CellStyle.BORDER_MEDIUM);
        style.setBottomBorderColor(IndexedColors.DARK_BLUE.getIndex());
        style.setBorderLeft(CellStyle.BORDER_MEDIUM);
        style.setLeftBorderColor(IndexedColors.DARK_BLUE.getIndex());
        style.setBorderRight(CellStyle.BORDER_MEDIUM);
        style.setRightBorderColor(IndexedColors.DARK_BLUE.getIndex());
        style.setBorderTop(CellStyle.BORDER_MEDIUM);
        style.setTopBorderColor(IndexedColors.DARK_BLUE.getIndex());
        //first style
        CellStyle style1 = workbook.createCellStyle();
        style1.setBorderLeft(CellStyle.BORDER_NONE);
        style1.setBorderRight(CellStyle.BORDER_NONE);
        style1.setBorderBottom(CellStyle.BORDER_NONE);
        style1.setBorderTop(CellStyle.BORDER_NONE);
        //second style
        CellStyle style2 =  workbook.createCellStyle();
        style2.setFont(font1);
        style2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style2.setAlignment(CellStyle.ALIGN_CENTER);
        style2.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());
        style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(CellStyle.BORDER_MEDIUM);
        style2.setBottomBorderColor(IndexedColors.DARK_BLUE.getIndex());
        style2.setBorderLeft(CellStyle.BORDER_MEDIUM);
        style2.setLeftBorderColor(IndexedColors.DARK_BLUE.getIndex());
        style2.setBorderRight(CellStyle.BORDER_MEDIUM);
        style2.setRightBorderColor(IndexedColors.DARK_BLUE.getIndex());
        style2.setBorderTop(CellStyle.BORDER_MEDIUM);
        style2.setTopBorderColor(IndexedColors.DARK_BLUE.getIndex());
        //third style
        CellStyle style3 = workbook.createCellStyle();
        style3.setFont(font1);
        style3.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style3.setAlignment(CellStyle.ALIGN_CENTER);
        style3.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
        style3.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style3.setBorderBottom(CellStyle.BORDER_MEDIUM);
        style3.setBottomBorderColor(IndexedColors.DARK_BLUE.getIndex());
        style3.setBorderLeft(CellStyle.BORDER_MEDIUM);
        style3.setLeftBorderColor(IndexedColors.DARK_BLUE.getIndex());
        style3.setBorderRight(CellStyle.BORDER_MEDIUM);
        style3.setRightBorderColor(IndexedColors.DARK_BLUE.getIndex());
        style3.setBorderTop(CellStyle.BORDER_MEDIUM);
        style3.setTopBorderColor(IndexedColors.DARK_BLUE.getIndex());
        //4eme style
        CellStyle style4 = workbook.createCellStyle();
        style4.setFont(font1);
        style4.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style4.setAlignment(CellStyle.ALIGN_CENTER);
        style4.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style4.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style4.setBorderBottom(CellStyle.BORDER_MEDIUM);
        style4.setBottomBorderColor(IndexedColors.DARK_BLUE.getIndex());
        style4.setBorderLeft(CellStyle.BORDER_MEDIUM);
        style4.setLeftBorderColor(IndexedColors.DARK_BLUE.getIndex());
        style4.setBorderRight(CellStyle.BORDER_MEDIUM);
        style4.setRightBorderColor(IndexedColors.DARK_BLUE.getIndex());
        style4.setBorderTop(CellStyle.BORDER_MEDIUM);
        style4.setTopBorderColor(IndexedColors.DARK_BLUE.getIndex());



        sheet.setColumnWidth(1, 7000);
        sheet.setColumnWidth(2, 5000);
        sheet.setColumnWidth(3, 5000);

        sheet.setColumnWidth(5, 4000);
        sheet.setColumnWidth(7 + nbProduit, 4000);
        sheet.setColumnWidth(7 + 2 * nbProduit + 2, 4000);

        sheet.setColumnWidth(6, 4000);
        sheet.setColumnWidth(8 + nbProduit, 4000);
        sheet.setColumnWidth(8 + 2 * nbProduit + 2, 4000);

        sheet.setColumnWidth(4, 200);
        sheet.setColumnWidth(6 + nbProduit, 200);
        sheet.setColumnWidth(6 + 2 * nbProduit + 2, 200);
        //creation cellules
        for(int i=0; i< n + 5 ; i++){
            for(int j=0; j< nbProduit * 3 + 10; j++){
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(j);
                cell.setCellStyle(style1);
            }
        }

        Row row1 =sheet.createRow(1);
        row1.setHeightInPoints(20);
        Cell cell1 = row1.createCell(1);

        CellRangeAddress region = new CellRangeAddress(1, 1, 5, 5 + nbProduit);
        cleanBeforeMergeOnValidCells(sheet, region, style2);
        sheet.addMergedRegion(region);
        cell1 = row1.getCell(5);
        cell1.setCellValue("O = Objectif");

        region = new CellRangeAddress(1, 1, 5 + nbProduit + 2, 5 + 2 * nbProduit + 2);
        cleanBeforeMergeOnValidCells(sheet, region, style2);
        sheet.addMergedRegion(region);
        cell1 = row1.getCell( 5 + nbProduit + 2);
        cell1.setCellValue("O = Realisation");

        region = new CellRangeAddress(1, 1, 5 + 2 * nbProduit + 4, 5 + 3 * nbProduit + 4);
        cleanBeforeMergeOnValidCells(sheet, region, style2);
        sheet.addMergedRegion(region);
        cell1 = row1.getCell(5 + 2 * nbProduit + 4);
        cell1.setCellValue("O/R = Objectif / Realisation");

        row1 =sheet.createRow(2);
        row1.setHeightInPoints(20);

        cell1 = row1.createCell(1);
        cell1.setCellValue("Cible");
        cell1.setCellStyle(style2);

        cell1 = row1.createCell(2);
        cell1.setCellValue("Niveau N");
        cell1.setCellStyle(style2);

        cell1 = row1.createCell(3);
        cell1.setCellValue("Niveau N + 1");
        cell1.setCellStyle(style2);
        int j=5;
        for(Produit produit : produits){
            cell1 = row1.createCell(j);
            cell1.setCellValue(produit.type);
            cell1.setCellStyle(style2);

            cell1=row1.createCell(j + nbProduit + 2);
            cell1.setCellValue(produit.type);
            cell1.setCellStyle(style2);

            cell1=row1.createCell(j + 2 * nbProduit + 4);
            cell1.setCellValue(produit.type);
            cell1.setCellStyle(style2);
            j++;
        }
        cell1=row1.createCell(5 + nbProduit);
        cell1.setCellValue("Total");
        cell1.setCellStyle(style2);

        cell1=row1.createCell(5 + 2 * nbProduit + 2);
        cell1.setCellValue("Total");
        cell1.setCellStyle(style2);

        cell1=row1.createCell(5 + 3 * nbProduit + 4);
        cell1.setCellValue("Total");
        cell1.setCellStyle(style2);


        //remplissage des lignes des pdvs
        int i=3;
        for(Pdv pdv : pdvs){
            Row row = sheet.createRow(i);
            //pdv.nom pdv.prenom
            Cell cell=row.createCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(pdv.nom+" "+pdv.prenom);
            cell.setCellStyle(style3);
            //pdv.dtype
            cell=row.createCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(pdv.dtype);
            cell.setCellStyle(style3);
            //conseiller niveau n+1
            cell=row.createCell(3);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("RP"+pdv.rgp.id);
            cell.setCellStyle(style3);
            j=5;
            Long s1=new Long(0);
            Long s2=new Long(0);
            for(Produit produit : produits){
                Objectifs obj = Objectifs.find().where().and(
                        com.avaje.ebean.Expr.eq("produit_id", produit.id),
                        com.avaje.ebean.Expr.eq("vendeur_id", pdv.id)
                ).findUnique();
                cell=row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.objectif);
                cell.setCellStyle(style3);
                s1=s1+obj.objectif;

                cell=row.createCell(j + nbProduit + 2);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.realisation);
                cell.setCellStyle(style3);
                s2=s2+obj.realisation;

                cell=row.createCell(j + 2 * nbProduit + 4);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(new Double(obj.realisation) / new Double(obj.objectif));
                cell.setCellStyle(style3);
                j++;
            }
            cell=row.createCell(5 + nbProduit);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s1);
            cell.setCellStyle(style3);

            cell=row.createCell(5 + 2 * nbProduit + 2);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s2);
            cell.setCellStyle(style3);

            cell=row.createCell(5 + 3 * nbProduit + 4);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(new Double(s2) / new Double(s1));
            cell.setCellStyle(style3);
            i++;
        }
        for(Distributeur distributeur : distributeurs){
            Row row = sheet.createRow(i);
            //pdv.nom pdv.prenom
            Cell cell=row.createCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(distributeur.nom+" "+distributeur.prenom);
            cell.setCellStyle(style4);
            //pdv.dtype
            cell=row.createCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(distributeur.dtype);
            cell.setCellStyle(style4);
            //conseiller niveau n+1
            cell=row.createCell(3);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("RD"+distributeur.rgd.id);
            cell.setCellStyle(style4);
            j=5;
            Long s1=new Long(0);
            Long s2=new Long(0);
            for(Produit produit : produits){
                Objectifs obj = Objectifs.find().where().and(
                        com.avaje.ebean.Expr.eq("produit_id", produit.id),
                        com.avaje.ebean.Expr.eq("vendeur_id", distributeur.id)
                ).findUnique();
                cell=row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.objectif);
                cell.setCellStyle(style4);
                s1=s1+obj.objectif;

                cell=row.createCell(j + nbProduit + 2);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.realisation);
                cell.setCellStyle(style4);
                s2=s2+obj.realisation;

                cell=row.createCell(j + 2 * nbProduit + 4);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(new Double(obj.realisation) / new Double(obj.objectif));
                cell.setCellStyle(style4);
                j++;
            }
            cell=row.createCell(5 + nbProduit);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s1);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 2 * nbProduit + 2);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s2);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 3 * nbProduit + 4);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(new Double(s2) / new Double(s1));
            cell.setCellStyle(style4);
            i++;
        }
        for(Boutique boutique : boutiques){
            Row row = sheet.createRow(i);
            //boutique.nom
            Cell cell=row.createCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(boutique.nom);
            cell.setCellStyle(style);
            //pdv.dtype
            cell=row.createCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("Boutique");
            cell.setCellStyle(style);
            //Boutique niveau n+1
            cell=row.createCell(3);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("RB"+boutique.rgb.id);
            cell.setCellStyle(style);
            j=5;
            Long s1=new Long(0);
            Long s2=new Long(0);
            for(Produit produit : produits){
                ObjectifsBoutique obj = query.having().and(
                        Expr.eq("produit_id", produit.id),
                        Expr.eq("boutique_id", boutique.id)
                ).findUnique();
                cell=row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.objectif);
                cell.setCellStyle(style4);
                s1=s1+obj.objectif;

                cell=row.createCell(j + nbProduit + 2);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.realisation);
                cell.setCellStyle(style4);
                s2=s2+obj.realisation;

                cell=row.createCell(j + 2 * nbProduit + 4);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(new Double(obj.realisation) / new Double(obj.objectif));
                cell.setCellStyle(style4);
                j++;
            }
            cell=row.createCell(5 + nbProduit);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s1);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 2 * nbProduit + 2);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s2);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 3 * nbProduit + 4);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(new Double(s2) / new Double(s1));
            cell.setCellStyle(style4);
            i++;
        }
        for(Franchise franchise : franchises){
            Row row = sheet.createRow(i);
            //franchise.nom
            Cell cell=row.createCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(franchise.nom);
            cell.setCellStyle(style);
            //franchise
            cell=row.createCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("Franchise");
            cell.setCellStyle(style);
            //Boutique niveau n+1
            cell=row.createCell(3);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("RB"+franchise.rgb.id);
            cell.setCellStyle(style);
            j=5;
            Long s1=new Long(0);
            Long s2=new Long(0);
            for(Produit produit : produits){
                ObjectifsFranchise obj = query1.having().and(
                        Expr.eq("produit_id", produit.id),
                        Expr.eq("franchise_id", franchise.id)
                ).findUnique();
                cell=row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.objectif);
                cell.setCellStyle(style4);
                s1=s1+obj.objectif;

                cell=row.createCell(j + nbProduit + 2);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.realisation);
                cell.setCellStyle(style4);
                s2=s2+obj.realisation;

                cell=row.createCell(j + 2 * nbProduit + 4);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(new Double(obj.realisation) / new Double(obj.objectif));
                cell.setCellStyle(style4);
                j++;
            }
            cell=row.createCell(5 + nbProduit);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s1);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 2 * nbProduit + 2);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s2);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 3 * nbProduit + 4);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(new Double(s2) / new Double(s1));
            cell.setCellStyle(style4);
            i++;
        }
        for(ResponsableRegionalBoutique rgb : rgbs){
            Row row = sheet.createRow(i);
            //franchise.nom
            Cell cell=row.createCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(rgb.nom+" "+rgb.prenom);
            cell.setCellStyle(style);
            //franchise
            cell=row.createCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("RGB");
            cell.setCellStyle(style);
            //Boutique niveau n+1
            cell=row.createCell(3);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("CDD"+rgb.cdd.id);
            cell.setCellStyle(style);
            j=5;
            Long s1=new Long(0);
            Long s2=new Long(0);
            for(Produit produit : produits){
                ObjectifsRgb obj = query2.having().and(
                        Expr.eq("produit_id", produit.id),
                        Expr.eq("rgb_id", rgb.id)
                ).findUnique();
                cell=row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.objectif);
                cell.setCellStyle(style4);
                s1=s1+obj.objectif;

                cell=row.createCell(j + nbProduit + 2);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.realisation);
                cell.setCellStyle(style4);
                s2=s2+obj.realisation;

                cell=row.createCell(j + 2 * nbProduit + 4);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(new Double(obj.realisation) / new Double(obj.objectif));
                cell.setCellStyle(style4);
                j++;
            }
            cell=row.createCell(5 + nbProduit);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s1);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 2 * nbProduit + 2);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s2);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 3 * nbProduit + 4);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(new Double(s2) / new Double(s1));
            cell.setCellStyle(style4);
            i++;
        }
        for(ResponsableRegionalDistribution rgd : rgds){
            Row row = sheet.createRow(i);
            //franchise.nom
            Cell cell=row.createCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(rgd.nom+" "+rgd.prenom);
            cell.setCellStyle(style);
            //franchise
            cell=row.createCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("RGD");
            cell.setCellStyle(style);
            //Boutique niveau n+1
            cell=row.createCell(3);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("CSD"+rgd.csd.id);
            cell.setCellStyle(style);
            j=5;
            Long s1=new Long(0);
            Long s2=new Long(0);
            for(Produit produit : produits){
                ObjectifsRgd obj = query4.having().and(
                        Expr.eq("produit_id", produit.id),
                        Expr.eq("rgd_id", rgd.id)
                ).findUnique();
                cell=row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.objectif);
                cell.setCellStyle(style4);
                s1=s1+obj.objectif;

                cell=row.createCell(j + nbProduit + 2);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.realisation);
                cell.setCellStyle(style4);
                s2=s2+obj.realisation;

                cell=row.createCell(j + 2 * nbProduit + 4);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(new Double(obj.realisation) / new Double(obj.objectif));
                cell.setCellStyle(style4);
                j++;
            }
            cell=row.createCell(5 + nbProduit);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s1);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 2 * nbProduit + 2);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s2);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 3 * nbProduit + 4);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(new Double(s2) / new Double(s1));
            cell.setCellStyle(style4);
            i++;
        }
        for(ResponsableRegionalPdv rgp : rgps){
            Row row = sheet.createRow(i);
            //franchise.nom
            Cell cell=row.createCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(rgp.nom+" "+rgp.prenom);
            cell.setCellStyle(style);
            //franchise
            cell=row.createCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("RGP");
            cell.setCellStyle(style);
            //Boutique niveau n+1
            cell=row.createCell(3);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("CSP"+rgp.csp.id);
            cell.setCellStyle(style);
            j=5;
            Long s1=new Long(0);
            Long s2=new Long(0);
            for(Produit produit : produits){
                ObjectifsRgp obj = query5.having().and(
                        Expr.eq("produit_id", produit.id),
                        Expr.eq("rgp_id", rgp.id)
                ).findUnique();
                cell=row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.objectif);
                cell.setCellStyle(style4);
                s1=s1+obj.objectif;

                cell=row.createCell(j + nbProduit + 2);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.realisation);
                cell.setCellStyle(style4);
                s2=s2+obj.realisation;

                cell=row.createCell(j + 2 * nbProduit + 4);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(new Double(obj.realisation) / new Double(obj.objectif));
                cell.setCellStyle(style4);
                j++;
            }
            cell=row.createCell(5 + nbProduit);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s1);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 2 * nbProduit + 2);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s2);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 3 * nbProduit + 4);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(new Double(s2) / new Double(s1));
            cell.setCellStyle(style4);
            i++;
        }
        for(ChefServiceDistribution csd : csds){
            Row row = sheet.createRow(i);
            //franchise.nom
            Cell cell=row.createCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(csd.nom+" "+csd.prenom);
            cell.setCellStyle(style);
            //franchise
            cell=row.createCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("CSD");
            cell.setCellStyle(style);
            //Boutique niveau n+1
            cell=row.createCell(3);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("CDI"+ csd.cdi.id);
            cell.setCellStyle(style);
            j=5;
            Long s1=new Long(0);
            Long s2=new Long(0);
            for(Produit produit : produits){
                ObjectifsCsd obj = query7.having().and(
                        Expr.eq("produit_id", produit.id),
                        Expr.eq("csd_id", csd.id)
                ).findUnique();
                cell=row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.objectif);
                cell.setCellStyle(style4);
                s1=s1+obj.objectif;

                cell=row.createCell(j + nbProduit + 2);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.realisation);
                cell.setCellStyle(style4);
                s2=s2+obj.realisation;

                cell=row.createCell(j + 2 * nbProduit + 4);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(new Double(obj.realisation) / new Double(obj.objectif));
                cell.setCellStyle(style4);
                j++;
            }
            cell=row.createCell(5 + nbProduit);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s1);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 2 * nbProduit + 2);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s2);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 3 * nbProduit + 4);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(new Double(s2) / new Double(s1));
            cell.setCellStyle(style4);
            i++;
        }
        for(ChefServicePdv csp : csps){
            Row row = sheet.createRow(i);
            //franchise.nom
            Cell cell=row.createCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(csp.nom+" "+csp.prenom);
            cell.setCellStyle(style);
            //franchise
            cell=row.createCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("CSP");
            cell.setCellStyle(style);
            //Boutique niveau n+1
            cell=row.createCell(3);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("CDI"+ csp.cdi.id);
            cell.setCellStyle(style);
            j=5;
            Long s1=new Long(0);
            Long s2=new Long(0);
            for(Produit produit : produits){
                ObjectifsCsd obj = query7.having().and(
                        Expr.eq("produit_id", produit.id),
                        Expr.eq("csp_id", csp.id)
                ).findUnique();
                cell=row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.objectif);
                cell.setCellStyle(style4);
                s1=s1+obj.objectif;

                cell=row.createCell(j + nbProduit + 2);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.realisation);
                cell.setCellStyle(style4);
                s2=s2+obj.realisation;

                cell=row.createCell(j + 2 * nbProduit + 4);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(new Double(obj.realisation) / new Double(obj.objectif));
                cell.setCellStyle(style4);
                j++;
            }
            cell=row.createCell(5 + nbProduit);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s1);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 2 * nbProduit + 2);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s2);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 3 * nbProduit + 4);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(new Double(s2) / new Double(s1));
            cell.setCellStyle(style4);
            i++;
        }
        for(ChefDepartementDirect cdd : cdds){
            Row row = sheet.createRow(i);
            //franchise.nom
            Cell cell=row.createCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(cdd.nom+" "+cdd.prenom);
            cell.setCellStyle(style);
            //franchise
            cell=row.createCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("CDD");
            cell.setCellStyle(style);
            //Boutique niveau n+1
            cell=row.createCell(3);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("DC"+cdd.dc.id);
            cell.setCellStyle(style);
            j=5;
            Long s1=new Long(0);
            Long s2=new Long(0);
            for(Produit produit : produits){
                ObjectifsCdd obj = query3.having().and(
                        Expr.eq("produit_id", produit.id),
                        Expr.eq("cdd_id", cdd.id)
                ).findUnique();
                cell=row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.objectif);
                cell.setCellStyle(style4);
                s1=s1+obj.objectif;

                cell=row.createCell(j + nbProduit + 2);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.realisation);
                cell.setCellStyle(style4);
                s2=s2+obj.realisation;

                cell=row.createCell(j + 2 * nbProduit + 4);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(new Double(obj.realisation) / new Double(obj.objectif));
                cell.setCellStyle(style4);
                j++;
            }
            cell=row.createCell(5 + nbProduit);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s1);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 2 * nbProduit + 2);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s2);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 3 * nbProduit + 4);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(new Double(s2) / new Double(s1));
            cell.setCellStyle(style4);
            i++;
        }
        for(ChefDepartementIndirect cdi : cdis){
            Row row = sheet.createRow(i);
            //franchise.nom
            Cell cell=row.createCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(cdi.nom+" "+cdi.prenom);
            cell.setCellStyle(style);
            //franchise
            cell=row.createCell(2);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("CDI");
            cell.setCellStyle(style);
            //Boutique niveau n+1
            cell=row.createCell(3);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue("DC"+cdi.dc.id);
            cell.setCellStyle(style);
            j=5;
            Long s1=new Long(0);
            Long s2=new Long(0);
            for(Produit produit : produits){
                ObjectifsCdi obj = query8.having().and(
                        Expr.eq("produit_id", produit.id),
                        Expr.eq("cdi_id", cdi.id)
                ).findUnique();
                cell=row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.objectif);
                cell.setCellStyle(style4);
                s1=s1+obj.objectif;

                cell=row.createCell(j + nbProduit + 2);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(obj.realisation);
                cell.setCellStyle(style4);
                s2=s2+obj.realisation;

                cell=row.createCell(j + 2 * nbProduit + 4);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(new Double(obj.realisation) / new Double(obj.objectif));
                cell.setCellStyle(style4);
                j++;
            }
            cell=row.createCell(5 + nbProduit);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s1);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 2 * nbProduit + 2);
            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
            cell.setCellValue(s2);
            cell.setCellStyle(style4);

            cell=row.createCell(5 + 3 * nbProduit + 4);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(new Double(s2) / new Double(s1));
            cell.setCellStyle(style4);
            i++;
        }
        try {
            FileOutputStream output = new FileOutputStream("tmp/rapport.xls");
            workbook.write(output);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void cleanBeforeMergeOnValidCells(Sheet sheet, CellRangeAddress region, CellStyle cellStyle) {
        for (int rowNum = region.getFirstRow(); rowNum <= region.getLastRow(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                sheet.createRow(rowNum);
            }
            for (int colNum = region.getFirstColumn(); colNum <= region.getLastColumn(); colNum++) {
                Cell currentCell = row.getCell(colNum);
                if (currentCell == null) {
                    currentCell = row.createCell(colNum);
                }

                currentCell.setCellStyle(cellStyle);

            }
        }

    }
}