package lab.mvc.form.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CountryFormBean {
    public CountryFormBean(){}

    @NotNull(message="{NotNull.countryCodeName.codeName}")
    @Size(min = 2, max = 6)
    private String codeName;

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [codeName=" + codeName + ", name=" + name + "]";
    }
}
