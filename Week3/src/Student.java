import org.hofman.collection.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel Hofman
 * Date: 16-10-12
 * Time: 10:38
 */
public class Student implements Comparable {
    private int studentnummer;
    private String naam;
    private int leeftijd;
    private Geslacht geslacht;
    private LinkedList vakken;

    @Override
    public String toString()
    {
        return String.format("Naam: %s Nummer: %s leeftijd: %s Geslacht: %s", naam, studentnummer, leeftijd, geslacht.toString());
    }

    @Override
    public boolean equals(Object object)
    {
        if(object == null) return false;

        if(object instanceof Student)
        {
            Student other = (Student) object;

            // Assume that Studentnummer is unique
            if(other.getStudentnummer() == this.studentnummer)
            {
                return true;
            }
        }
        else
        {
            return false;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student)
        {
            Student object = (Student) o;

            if(this.getStudentnummer() < object.getStudentnummer())
            {
                return -1;
            }
            if(this.getStudentnummer() == object.getStudentnummer())
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
        else
        {
            throw new ClassCastException("Class cannot be compared");
        }
    }

    public void addVak(Vak vak)
    {
        if(!this.vakken.contains(vak))
        {
            this.vakken.add(vak);
        }
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getStudentnummer() {
        return studentnummer;
    }

    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }

    public LinkedList getVakken() {
        return vakken;
    }
}
