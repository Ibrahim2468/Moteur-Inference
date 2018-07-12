/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateursystemescomplexe.moteurs;

import generateursystemescomplexe.faits.BaseFait;
import generateursystemescomplexe.faits.Fait;
import generateursystemescomplexe.regles.BaseRegle;
import generateursystemescomplexe.regles.Regle;

/**
 *
 * @author Ibrahim DJINA
 */
public class ChainageAvant {

    public ChainageAvant(BaseFait baseFait, BaseRegle baseRegle, Fait faitRechercher) {

        while (!baseFait.chercherFait(faitRechercher) && baseRegle.applicable() != null) {
            Regle regleApplicable = baseRegle.applicable();

            // Désacivation de la règle
            regleApplicable.setStatutRegle(false);

//            System.out.println("Applicable : " + regleApplicable.getPremisseRegle().getFaitGauchePremisse().getDescriptionFait() + " et " + regleApplicable.getConclusionRegle().getFaitGauchePremisse().getDescriptionFait() + " et statut : " + regleApplicable.isStatutRegle());

            // Ajout de la conclusion de la règle dans la base de fait
            baseFait.ajouterRegle(regleApplicable);

            System.out.println("\nLa base de fait devient : ");
            for (Fait fait : baseFait.getFaits()) {
                System.out.println(fait.getIdFait() + " " + fait.getDescriptionFait() + " " + fait.getDesignationFait());
            }
        }

        if (baseFait.chercherFait(faitRechercher)) {
            System.out.println("le fait " + faitRechercher.getDescriptionFait() + " est établi.");
        } else {
            System.out.println("Le fait " + faitRechercher.getDescriptionFait() + " n'est pas établi.");
        }
    }
}
