/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateursystemescomplexe.regles;

import generateursystemescomplexe.autres.Conclusion;
import generateursystemescomplexe.autres.Premisse;

/**
 *
 * @author Ibrahim DJINA
 */
public class Regle {

    private static int staticId = 0;

    private int idRegle;
    private Premisse PremisseRegle;
    private Conclusion ConclusionRegle;
    private boolean statutRegle;

    public Regle() {
        this.idRegle = ++staticId;
        this.statutRegle = true;
    }

    public Regle(Premisse PremisseRegle, Conclusion ConclusionRegle) {
        this.idRegle = ++staticId;
        this.PremisseRegle = PremisseRegle;
        this.ConclusionRegle = ConclusionRegle;
        this.statutRegle = true;
    }

    public int getIdRegle() {
        return idRegle;
    }

    public Premisse getPremisseRegle() {
        return PremisseRegle;
    }

    public void setPremisseRegle(Premisse PremisseRegle) {
        this.PremisseRegle = PremisseRegle;
    }

    public Conclusion getConclusionRegle() {
        return ConclusionRegle;
    }

    public void setConclusionRegle(Conclusion ConclusionRegle) {
        this.ConclusionRegle = ConclusionRegle;
    }

    public boolean isStatutRegle() {
        return statutRegle;
    }

    public void setStatutRegle(boolean statutRegle) {
        this.statutRegle = statutRegle;
    }

}
