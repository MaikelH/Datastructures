

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
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p/>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p/>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p/>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p/>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p/>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
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
