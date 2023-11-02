package boozeblender.CocktailDB;

import java.util.ArrayList;

public class Filter {
    public String strDrink;
    public String strDrinkThumb;
    public String idDrink;

    @Override
    public String toString() {
        return "Filter{" +
                "strDrink='" + strDrink + '\'' +
                ", strDrinkThumb='" + strDrinkThumb + '\'' +
                ", idDrink='" + idDrink + '\'' +
                '}';
    }
}

class FilterDrinks {
    ArrayList<Filter> drinks;
}