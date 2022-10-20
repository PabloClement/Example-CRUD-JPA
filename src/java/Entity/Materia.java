package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pablo
 */

@Entity
@Table(name = "dbmateria")

public class Materia implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_materia;
    
    @Column(name = "materia")
    private String Materia;

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id_materia;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia other = (Materia) obj;
        if (this.id_materia != other.id_materia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Materia{" + "id_materia=" + id_materia + '}';
    } 
    
    
}

