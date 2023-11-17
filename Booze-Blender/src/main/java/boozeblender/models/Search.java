package boozeblender.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Search {


    @NotBlank(message = "Please enter a valid search parameter. It cannot be blank.")
    @Size(min = 5, max = 20)
    @NotNull(message = "Please enter a valid search parameter.")
    private String searchParameter;

    public String getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(String searchParameter) {
        this.searchParameter = searchParameter;
    }



}
