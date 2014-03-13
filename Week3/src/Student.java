import org.hofman.base.Function;
import org.hofman.base.Predicate;
import org.hofman.collection.IList;
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
    private LinkedList<Vak> vakken;
    private String klas;
    private String studieRichting;

    public Student()
    {
        vakken = new LinkedList<Vak>();
    }

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

    /**
     * Voegt een vak toe aan de lijst met vakken
     * @param vak
     */
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

    public IList<Vak> getVakken(final int jaar) {
        if(jaar == 0)
        {
            return vakken.where(new Predicate<Vak>() {
                @Override
                public Boolean apply(Vak object) {
                    return object.getCijfer() != -1;
                }
            });
        }
        return vakken.where(new Predicate<Vak>() {
            @Override
            public Boolean apply(Vak object) {
                return object.getCijfer() != 1 && object.getJaar() == jaar;
            }
        });
    }

    public String getKlas() {
        return klas;
    }

    public void setKlas(String klas) {
        this.klas = klas;
    }

    public String getStudieRichting() {
        return studieRichting;
    }

    public void setStudieRichting(String studieRichting) {
        this.studieRichting = studieRichting;
    }

    /**
     * Retourneert het gemiddelde van alle vakken
     * @return Gemiddelde
     */
    public double gemiddelde() {
        return this.vakken.where(new Predicate<Vak>() {
            @Override
            public Boolean apply(Vak object) {return object.getCijfer() != -1;}
        }).average(new Function<Vak, Double>() {
            @Override
            public Double apply(Vak input) {
                return (double)input.getCijfer();
            }
        });
    }
}
