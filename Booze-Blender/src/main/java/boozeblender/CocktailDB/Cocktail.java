package boozeblender.CocktailDB;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Cocktail {
    public String idDrink;
    public String strDrink;
    public String strDrinkAlternate;
    public String strTags;
    public String strVideo;
    public String strCategory;
    public String strIBA;
    public String strAlcoholic;
    public String strGlass;
    public String strInstructions;
    public String strInstructionsES;
    public String strInstructionsDE;
    public String strInstructionsFR;
    public String strInstructionsIT;
    @SerializedName("strInstructionsZH-HANS")
    public String strInstructionsZHHANS;
    @SerializedName("strInstructionsZH-HANT")
    public String strInstructionsZHHANT;
    public String strDrinkThumb;
    public String strIngredient1;
    public String strIngredient2;
    public String strIngredient3;
    public String strIngredient4;
    public String strIngredient5;
    public String strIngredient6;
    public String strIngredient7;
    public String strIngredient8;
    public String strIngredient9;
    public String strIngredient10;
    public String strIngredient11;
    public String strIngredient12;
    public String strIngredient13;
    public String strIngredient14;
    public String strIngredient15;
    public String strMeasure1;
    public String strMeasure2;
    public String strMeasure3;
    public String strMeasure4;
    public String strMeasure5;
    public String strMeasure6;
    public String strMeasure7;
    public String strMeasure8;
    public String strMeasure9;
    public String strMeasure10;
    public String strMeasure11;
    public String strMeasure12;
    public String strMeasure13;
    public String strMeasure14;
    public String strMeasure15;
    public String strImageSource;
    public String strImageAttribution;
    public String strCreativeCommonsConfirmed;
    public String dateModified;

    @Override
    public String toString() {
        return "Cocktail{" +
                "idDrink='" + idDrink + '\'' +
                ", strDrink='" + strDrink + '\'' +
                ", strDrinkAlternate='" + strDrinkAlternate + '\'' +
                ", strTags='" + strTags + '\'' +
                ", strVideo='" + strVideo + '\'' +
                ", strCategory='" + strCategory + '\'' +
                ", strIBA='" + strIBA + '\'' +
                ", strAlcoholic='" + strAlcoholic + '\'' +
                ", strGlass='" + strGlass + '\'' +
                ", strInstructions='" + strInstructions + '\'' +
                ", strInstructionsES='" + strInstructionsES + '\'' +
                ", strInstructionsDE='" + strInstructionsDE + '\'' +
                ", strInstructionsFR='" + strInstructionsFR + '\'' +
                ", strInstructionsIT='" + strInstructionsIT + '\'' +
                ", strInstructionsZHHANS='" + strInstructionsZHHANS + '\'' +
                ", strInstructionsZHHANT='" + strInstructionsZHHANT + '\'' +
                ", strDrinkThumb='" + strDrinkThumb + '\'' +
                ", strIngredient1='" + strIngredient1 + '\'' +
                ", strIngredient2='" + strIngredient2 + '\'' +
                ", strIngredient3='" + strIngredient3 + '\'' +
                ", strIngredient4='" + strIngredient4 + '\'' +
                ", strIngredient5='" + strIngredient5 + '\'' +
                ", strIngredient6='" + strIngredient6 + '\'' +
                ", strIngredient7='" + strIngredient7 + '\'' +
                ", strIngredient8='" + strIngredient8 + '\'' +
                ", strIngredient9='" + strIngredient9 + '\'' +
                ", strIngredient10='" + strIngredient10 + '\'' +
                ", strIngredient11='" + strIngredient11 + '\'' +
                ", strIngredient12='" + strIngredient12 + '\'' +
                ", strIngredient13='" + strIngredient13 + '\'' +
                ", strIngredient14='" + strIngredient14 + '\'' +
                ", strIngredient15='" + strIngredient15 + '\'' +
                ", strMeasure1='" + strMeasure1 + '\'' +
                ", strMeasure2='" + strMeasure2 + '\'' +
                ", strMeasure3='" + strMeasure3 + '\'' +
                ", strMeasure4='" + strMeasure4 + '\'' +
                ", strMeasure5='" + strMeasure5 + '\'' +
                ", strMeasure6='" + strMeasure6 + '\'' +
                ", strMeasure7='" + strMeasure7 + '\'' +
                ", strMeasure8='" + strMeasure8 + '\'' +
                ", strMeasure9='" + strMeasure9 + '\'' +
                ", strMeasure10='" + strMeasure10 + '\'' +
                ", strMeasure11='" + strMeasure11 + '\'' +
                ", strMeasure12='" + strMeasure12 + '\'' +
                ", strMeasure13='" + strMeasure13 + '\'' +
                ", strMeasure14='" + strMeasure14 + '\'' +
                ", strMeasure15='" + strMeasure15 + '\'' +
                ", strImageSource='" + strImageSource + '\'' +
                ", strImageAttribution='" + strImageAttribution + '\'' +
                ", strCreativeCommonsConfirmed='" + strCreativeCommonsConfirmed + '\'' +
                ", dateModified='" + dateModified + '\'' +
                '}';
    }
}

class Cocktails {
    ArrayList<Cocktail> drinks;
}