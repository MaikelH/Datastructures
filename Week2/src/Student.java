/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 3-9-12
 * Time: 9:32
 */
public class Student implements Comparable {
    private int studentnummer;
    private String naam;
    private int leeftijd;
    private Geslacht geslacht;

    public Student(int studentnummer, String naam, int leeftijd, Geslacht geslacht) {
        this.studentnummer = studentnummer;
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.geslacht = geslacht;
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

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }

    public int getStudentnummer() {
        return studentnummer;
    }

    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    /**
     * Comparison of the student is done on studentnumber.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     *         is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
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
}
