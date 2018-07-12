/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateursystemescomplexe.regles;

import generateursystemescomplexe.faits.Fait;
import generateursystemescomplexe.regles.Regle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ibrahim DJINA
 */
public class BaseRegle {

    // La liste des fait utilis
    List<Regle> regles;

    public BaseRegle() {
        this.regles = new ArrayList<Regle>();
    }

    public BaseRegle(List<Regle> regles) {
        this.regles = regles;
    }

    public List<Regle> getRegles() {
        return regles;
    }

    public void setRegles(List<Regle> regles) {
        this.regles = regles;
    }

    // Définition de la règle appliquable
    public Regle applicable() {

        for (Regle regle : this.regles) {

            // Récupération du fait gauche de la prémisse de la règle
            Fait faitGaucheP = regle.getPremisseRegle().getFaitGauchePremisse();
            // Récupération du fait droit de la prémisse de la règle
            Fait faitDroiteP = regle.getPremisseRegle().getFaitDroitePremisse();
            // Récupération du l'operateur de la prémisse de la règle
            String operateurP = regle.getPremisseRegle().getOperateurPremisse();
            // Récupération du statut de la règle
            boolean statutR = regle.isStatutRegle();

            // Que les règles qui n'ont pas été désactivé (dont stattut = true)
            if (statutR) {
//                System.out.println("Operateur = " + operateurP.length() + "." + statutR);
                if (operateurP.equals("et")) {
                    if (faitGaucheP.isAjouterFait() && faitDroiteP.isAjouterFait()) {
//                        System.out.println("sddsdsdsdsd : " + faitGaucheP.getDescriptionFait() + " et " + faitDroiteP.getDescriptionFait() + " alors " + regle.getConclusionRegle().getFaitGauchePremisse().getDescriptionFait());
                        return regle;
                    }
                } else if (operateurP.equals("ou")) {
                    if (faitGaucheP.isAjouterFait() || faitDroiteP.isAjouterFait()) {
//                        System.out.println("Applicable : " + faitGaucheP.getDescriptionFait() + " et " + regle.getConclusionRegle().getFaitGauchePremisse().getDescriptionFait());
                        return regle;
                    }
                } else {
                    if (faitGaucheP.isAjouterFait()) {
//                        System.out.println("Applicabsdsdsle : " + faitGaucheP.getDescriptionFait() + " et " + regle.getConclusionRegle().getFaitGauchePremisse().getDescriptionFait());
                        return regle;
                    }
                }
            }
        }

        return null;
    }

    public List<Regle> contruireER(Fait faitRechercher) {

        List<Regle> ER = new ArrayList<Regle>();
        for (Regle regle : this.regles) {
            Fait faitGaucheC = regle.getConclusionRegle().getFaitGauchePremisse();
            Fait faitDroiteC = regle.getConclusionRegle().getFaitDroitePremisse();
            String operateurC = regle.getConclusionRegle().getOperateurPremisse();
            boolean statutR = regle.isStatutRegle();

            Fait faitGaucheP = regle.getPremisseRegle().getFaitGauchePremisse();
            Fait faitDroiteP = regle.getPremisseRegle().getFaitDroitePremisse();
            String operateurP = regle.getPremisseRegle().getOperateurPremisse();

            // Que les règles qui n'ont pas été désactivé (dont stattut = true)
            if (statutR) {
                if (operateurC.equals("et")) {
                    if (faitGaucheC.equals(faitRechercher) && faitDroiteC.equals(faitRechercher)) {
                        ER.add(regle);
                    }
                } else if (operateurC.equals("ou")) {
                    if (faitGaucheC.equals(faitRechercher) || faitDroiteC.equals(faitRechercher)) {
                        ER.add(regle);
                    }
                } else {
                    if (faitGaucheC.equals(faitRechercher)) {
                        ER.add(regle);
                    }
                }
            }
        }

        return ER;
    }
}
