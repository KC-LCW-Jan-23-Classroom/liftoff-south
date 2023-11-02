package boozeblender.CocktailDB;

import java.util.ArrayList;

public class Ingredient{
    public String idIngredient;
    public String strIngredient;
    public String strDescription;
    public String strType;
    public String strAlcohol;
    public String strABV;

    @Override
    public String toString() {
        return "Ingredient{" +
                "idIngredient='" + idIngredient + '\'' +
                ", strIngredient='" + strIngredient + '\'' +
                ", strDescription='" + strDescription + '\'' +
                ", strType='" + strType + '\'' +
                ", strAlcohol='" + strAlcohol + '\'' +
                ", strABV='" + strABV + '\'' +
                '}';
    }
}

class Ingredients {
    ArrayList<Ingredient> ingredients;
}