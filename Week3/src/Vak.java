/**
 * Created with IntelliJ IDEA.
 * User: Maikel Hofman
 * Date: 16-10-12
 * Time: 10:38
 */
public class Vak implements Comparable<Vak> {

    private String moduleCode;
    private int cijfer;
    private int jaar;

    @Override
    public int compareTo(Vak o) {
        // TODO: Toevoegen compareTo functie
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object object)
    {
        if(object == null) return false;

        if(object instanceof Vak)
        {
            Vak other = (Vak) object;

            // Assume that ModuleCode is unique
            if(other.getModuleCode().equals(this.getModuleCode()))
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

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getCijfer() {
        return cijfer;
    }

    public void setCijfer(int cijfer) {
        this.cijfer = cijfer;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }
}
