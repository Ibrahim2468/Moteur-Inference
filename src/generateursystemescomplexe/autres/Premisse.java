/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateursystemescomplexe.autres;

import generateursystemescomplexe.faits.Fait;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ibrahim DJINA
 */
public class Premisse extends Fait {

    private static int staticId = 0;

    private int idPremisse;
    private Fait faitGauchePremisse;
    private Fait faitDroitePremisse;
    private String operateurPremisse;

    public Premisse() {
        this.idPremisse = ++staticId;
    }

    public Premisse(Fait faitGauchePremisse, Fait faitDroitePremisse, String operateurPremisse) {
        this.idPremisse = ++staticId;
        this.faitGauchePremisse = faitGauchePremisse;
        this.faitDroitePremisse = faitDroitePremisse;
        this.operateurPremisse = operateurPremisse;
    }

    public Premisse(Fait faitGauchePremisse) {
        this.idPremisse = ++staticId;
        this.faitGauchePremisse = faitGauchePremisse;
        this.operateurPremisse = "";
        this.faitDroitePremisse = null;
    }

    public Fait getFaitGauchePremisse() {
        return faitGauchePremisse;
    }

    public void setFaitGauchePremisse(Fait faitGauchePremisse) {
        this.faitGauchePremisse = faitGauchePremisse;
    }

    public Fait getFaitDroitePremisse() {
        return faitDroitePremisse;
    }

    public void setFaitDroitePremisse(Fait faitDroitePremisse) {
        this.faitDroitePremisse = faitDroitePremisse;
    }

    public String getOperateurPremisse() {
        return operateurPremisse;
    }

    public void setOperateurPremisse(String operateurPremisse) {
        this.operateurPremisse = operateurPremisse;
    }

    // Récupération des fait de la prémisse
    public List<Fait> faitsPremisse() {

        List<Fait> faits = new ArrayList<Fait>();

        faits.add(faitGauchePremisse);
        if (this.operateurPremisse.equals("et") || this.operateurPremisse.equals("ou")) {
            faits.add(faitDroitePremisse);
        }

        return faits;
    }

}
