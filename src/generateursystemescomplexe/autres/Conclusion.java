/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateursystemescomplexe.autres;

import generateursystemescomplexe.faits.Fait;

/**
 *
 * @author Ibrahim DJINA
 */
public class Conclusion extends Premisse {

    public Conclusion() {
    }

    public Conclusion(Fait faitGauchePremisse, Fait faitDroitePremisse, String operateurPremisse) {
        super(faitGauchePremisse, faitDroitePremisse, operateurPremisse);
    }

    public Conclusion(Fait faitGauchePremisse) {
        super(faitGauchePremisse);
    }

}
