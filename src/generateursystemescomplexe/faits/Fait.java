/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateursystemescomplexe.faits;

/**
 *
 * @author Ibrahim DJINA
 */
public class Fait {

    private static int staticId = 0;

    private int idFait;
    private String descriptionFait;
    private String designationFait;
    private boolean ajouterFait;

    public Fait() {
        this.idFait = ++staticId;
        this.ajouterFait = false;
    }

    public Fait(String descriptionFait, String designationFait) {
        this.idFait = ++staticId;
        this.descriptionFait = descriptionFait;
        this.designationFait = designationFait;
        this.ajouterFait = false;
    }

    public int getIdFait() {
        return idFait;
    }

    public String getDescriptionFait() {
        return descriptionFait;
    }

    public void setDescriptionFait(String descriptionFait) {
        this.descriptionFait = descriptionFait;
    }

    public String getDesignationFait() {
        return designationFait;
    }

    public void setDesignationFait(String designationFait) {
        this.designationFait = designationFait;
    }

    public boolean isAjouterFait() {
        return ajouterFait;
    }

    public void setAjouterFait(boolean ajouterFait) {
        this.ajouterFait = ajouterFait;
    }

}
