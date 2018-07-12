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
import java.util.List;

/**
 *
 * @author Ibrahim DJINA
 */
public class ChainageArriere {

    public ChainageArriere() {

    }

    public boolean chainageArriere(BaseFait baseFait, BaseRegle baseRegle, Fait faitRechercher) {
        if (baseFait.chercherFait(faitRechercher)) {
//            System.out.println("Le fait " + faitRechercher.getDescriptionFait() + " est établi.");
            return true;
        } else {
            List<Regle> ER = baseRegle.contruireER(faitRechercher);
            for (int i = 0, tailleER = ER.size(); i < tailleER; i++) {
                Regle R = ER.get(i);
                List<Fait> Fr = R.getPremisseRegle().faitsPremisse();
                // On récupére l'opérateur de la prémisse de la règle
                String operateurFr = R.getPremisseRegle().getOperateurPremisse();
                for (int j = 0, tailleFr = Fr.size(); j < tailleFr; j++) {
                    Fait newFaitRechercher = Fr.get(j);
                    chainageArriere(baseFait, baseRegle, newFaitRechercher);
                }
                if (operateurFr.equals("et")) {
                    if (baseFait.chercherFait(R.getPremisseRegle().getFaitGauchePremisse()) && baseFait.chercherFait(R.getPremisseRegle().getFaitDroitePremisse())) {
                        if (!baseFait.chercherFait(R.getConclusionRegle().getFaitGauchePremisse())) {
                            baseFait.ajoutFait(R.getConclusionRegle().getFaitGauchePremisse());
                            return true;
                        }
                    }
                } else if (operateurFr.equals("ou")) {
                    if (baseFait.chercherFait(R.getPremisseRegle().getFaitGauchePremisse()) || baseFait.chercherFait(R.getPremisseRegle().getFaitDroitePremisse())) {
                        if (!baseFait.chercherFait(R.getConclusionRegle().getFaitGauchePremisse())) {
                            baseFait.ajoutFait(R.getConclusionRegle().getFaitGauchePremisse());
                            return true;
                        }
                    }
                } else {
                    if (baseFait.chercherFait(R.getPremisseRegle().getFaitGauchePremisse())) {
                        if (!baseFait.chercherFait(R.getConclusionRegle().getFaitGauchePremisse())) {
                            baseFait.ajoutFait(R.getConclusionRegle().getFaitGauchePremisse());
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
