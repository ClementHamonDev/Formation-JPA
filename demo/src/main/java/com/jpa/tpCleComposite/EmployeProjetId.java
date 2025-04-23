package com.jpa.tpCleComposite;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeProjetId {

    private Long idEmploye;
    private Long idProjet;

    public Long getIdEmploye() {
        return this.idEmploye;
    }

    public void setIdEmploye(Long idEmploye) {
        this.idEmploye = idEmploye;
    }

    public Long getIdProjet() {
        return this.idProjet;
    }

    public void setIdProjet(Long idProjet) {
        this.idProjet = idProjet;
    }


    
}
