/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateursystemescomplexe;

import generateursystemescomplexe.autres.Conclusion;
import generateursystemescomplexe.autres.Premisse;
import generateursystemescomplexe.faits.BaseFait;
import generateursystemescomplexe.faits.Fait;
import generateursystemescomplexe.moteurs.ChainageArriere;
import generateursystemescomplexe.moteurs.ChainageAvant;
import generateursystemescomplexe.regles.BaseRegle;
import generateursystemescomplexe.regles.Regle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ibrahim DJINA
 */
public class GenerateurSystemesComplexe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Liste des faits 
        Fait faitA = new Fait("FaitA", "A");
        Fait faitB = new Fait("FaitB", "B");
        Fait faitC = new Fait("FaitC", "C");
        Fait faitD = new Fait("FaitD", "D");
        Fait faitE = new Fait("FaitE", "E");
        Fait faitF = new Fait("FaitF", "F");
        Fait faitG = new Fait("FaitG", "G");
        Fait faitH = new Fait("FaitH", "H");
        Fait faitX = new Fait("FaitX", "X");

        List<Fait> faits = new ArrayList<Fait>() {
            {
                add(faitA);
                add(faitB);
                add(faitC);
                add(faitD);
                add(faitE);
                add(faitF);
                add(faitG);
                add(faitH);
                add(faitX);
            }
        };

        for (Fait fait : faits) {
            System.out.println(fait.getIdFait() + " " + fait.getDescriptionFait() + " " + fait.getDesignationFait());
        }

        // Base de faits
        BaseFait baseFait = new BaseFait();
        baseFait.ajoutFait(faitB);
        baseFait.ajoutFait(faitC);

        for (Fait fait : baseFait.getFaits()) {
            System.out.println(fait.getIdFait() + " " + fait.getDescriptionFait() + " " + fait.getDesignationFait());
        }

        // Liste des regles ( base de règles) 
        Regle regle1 = new Regle(new Premisse(faitB, faitD, "et"), new Conclusion(faitF));
        Regle regle2 = new Regle(new Premisse(faitG, faitD, "et"), new Conclusion(faitA));
        Regle regle3 = new Regle(new Premisse(faitC, faitF, "et"), new Conclusion(faitA));
        Regle regle4 = new Regle(new Premisse(faitB), new Conclusion(faitX));
        Regle regle5 = new Regle(new Premisse(faitD), new Conclusion(faitE));
        Regle regle6 = new Regle(new Premisse(faitX, faitA, "et"), new Conclusion(faitH));
        Regle regle7 = new Regle(new Premisse(faitC), new Conclusion(faitD));
        Regle regle8 = new Regle(new Premisse(faitX, faitC, "et"), new Conclusion(faitA));
        Regle regle9 = new Regle(new Premisse(faitX, faitB, "et"), new Conclusion(faitD));

        BaseRegle baseregles = new BaseRegle(new ArrayList<Regle>() {
            {
                add(regle1);
                add(regle2);
                add(regle3);
                add(regle4);
                add(regle5);
                add(regle6);
                add(regle7);
                add(regle8);
                add(regle9);
            }
        });

        for (Regle regle : baseregles.getRegles()) {
            System.out.println(regle.getIdRegle() + " " + regle.isStatutRegle());
        }

//        new ChainageAvant(baseFait, baseregles, faitH);

        boolean retour = new ChainageArriere().chainageArriere(baseFait, baseregles, faitH);
        if(retour == true){
            System.out.println("\n\n\nLe fait " + faitH.getDescriptionFait() + " est établi");
        } else{
            System.out.println("\n\n\nLe fait " + faitH.getDescriptionFait() + " n'est pas établi");
        }

        for (Fait fait : baseFait.getFaits()) {
            System.out.println(fait.getIdFait() + " " + fait.getDescriptionFait() + " " + fait.getDesignationFait());
        }
    }

}
