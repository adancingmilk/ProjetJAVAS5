package themes;

import java.util.Objects;

public class Theme {
    private String nom;

    public Theme(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theme theme = (Theme) o;
        return Objects.equals(nom, theme.nom);
    }

    @Override
    public String toString() {
        return nom;
    }
}
