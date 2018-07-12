/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateursystemescomplexe.faits;

import generateursystemescomplexe.regles.BaseRegle;
import generateursystemescomplexe.regles.Regle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ibrahim DJINA
 */
public class BaseFait {

    // La liste des fait utilis
    List<Fait> faits;

    public BaseFait() {
        this.faits = new ArrayList<Fait>();
    }

    public BaseFait(List<Fait> faits) {
        this.faits = faits;
    }

    public List<Fait> getFaits() {
        return faits;
    }

    // Ajout d'un fait dans la base
    public void ajoutFait(Fait fait) {
        this.faits.add(fait);
        fait.setAjouterFait(true);
    }

    // Chercher Un fait
    public boolean chercherFait(Fait fait) {

        for (int i = 0, taille = this.faits.size(); i < taille; i++) {
            if (this.faits.get(i).equals(fait)) {
                return true;
            }
        }

        return false;
    }

    public void ajouterRegle(Regle regle) {

        // Récupération du fait gauche de la conclusion de la règle
        Fait faitGaucheC = regle.getConclusionRegle().getFaitGauchePremisse();
        // Récupération du fait droit de la prémisse de la règle
        Fait faitDroiteC = regle.getConclusionRegle().getFaitDroitePremisse();
        // Récupération du l'operateur de la prémisse de la règle
        String operateurC = regle.getConclusionRegle().getOperateurPremisse();

//        System.out.println("Ajout conclusion de la regle : " + regle.getPremisseRegle().getFaitGauchePremisse().getDescriptionFait() + " " + regle.getConclusionRegle().getFaitGauchePremisse().getDescriptionFait());
        
        // Ajout du fait gauche de la conclusion
        if (!chercherFait(faitGaucheC)) {
            ajoutFait(faitGaucheC);
//            System.out.println("Le Fait gauche ajouter : " + faitGaucheC.getDescriptionFait());
        }

        // Si y'a pas d'opérateur
        if (operateurC.equals("et") || operateurC.equals("ou")){
            if (!chercherFait(faitDroiteC)) {
                ajoutFait(faitDroiteC);
            }
        }
    }

}
