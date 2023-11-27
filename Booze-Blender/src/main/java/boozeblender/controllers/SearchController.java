package boozeblender.controllers;

import boozeblender.models.Search;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping("/byIngredient")
    public String searchByIngredient(Model model) {
        model.addAttribute(new Search());
        return "search/byIngredient";
    }
//    @GetMapping("/byIngredientResults")
//    public String get(String uri) throws Exception {
//        HttpClient client = HttpClient.newHttpClient();
//        String url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?i=Vodka";
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .build();
//
//        HttpResponse<String> response =
//                client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.body());
//        return "search/byIngredientResults";
//    }

    @PostMapping("/byIngredientResults")
    public String searchByIngredient (@ModelAttribute Search search, Errors errors, Model model) throws IOException, InterruptedException {
        if (errors.hasErrors()) {
            System.out.println(errors.getAllErrors().toString());
            return "search/byIngredient";
        }
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=" +search.getSearchParameter();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseString = response.body().toString();
        // Map JSON string to an object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(response.body(), Map.class);

        // the API returns an object containing an array with a key of "drinks".
        // So get the value for "drinks", and cast it to an ArrayList so that we can iterate over the drinks.
        ArrayList drinksArray = (ArrayList) map.get("drinks");

        // Pass a list of drinks to the template
        model.addAttribute("drinksArray", drinksArray);
        System.out.println(response.body());
        model.addAttribute("response", response.body().toString());
        model.addAttribute("search", search.getSearchParameter());
        return "search/byIngredientResults";
    }


    @GetMapping("/byGlass")
    public String searchByGlass(Model model) {
        model.addAttribute(new Search());
        return "search/byGlass";
    }

    @GetMapping("/byGlassResults")
    public String searchByGlass(@RequestParam String glassType, Model model) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String encodedSearchParameter = URLEncoder.encode(glassType, StandardCharsets.UTF_8);
        String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?g=" + encodedSearchParameter;
        System.out.println("Request URL: " + url);
        System.out.println("Search Parameters: " + glassType);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseString = response.body().toString();

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(response.body(), Map.class);

        ArrayList drinksArray = (ArrayList) map.get("drinks");

        model.addAttribute("glassType", glassType);
        model.addAttribute("drinksArray", drinksArray);

        return "search/byGlassResults";
    }


//www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic
//www.thecocktaildb.com/api/json/v1/1/filter.php?a=Non_Alcoholic
    @GetMapping("/alcoholicFilter")
    public String alcoholicFilter(Model model) {
        model.addAttribute(new Search());
        return "search/alcoholicFilter";
    }

    @PostMapping("/alcoholicFilterResults")
    public String alcoholicFilter (@ModelAttribute Search search, Errors errors, Model model) throws IOException, InterruptedException {
        if (errors.hasErrors()) {
            System.out.println(errors.getAllErrors().toString());
            return "search/alcoholicFilter";
        }
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=" +search.getSearchParameter();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseString = response.body().toString();
        // Map JSON string to an object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(response.body(), Map.class);

        // the API returns an object containing an array with a key of "drinks".
        // So get the value for "drinks", and cast it to an ArrayList so that we can iterate over the drinks.
        ArrayList drinksArray = (ArrayList) map.get("drinks");

        // Pass a list of drinks to the template
        model.addAttribute("drinksArray", drinksArray);
        System.out.println(response.body());
        model.addAttribute("response", response.body().toString());
        model.addAttribute("search", search.getSearchParameter());
        return "search/alcoholicFilterResults";
    }

    @GetMapping("/randomCocktailGenerator")
    public String randomCocktailGenerator(Model model) {
        model.addAttribute(new Search());
        return "search/randomCocktailGenerator";
    }
    @PostMapping("/randomCocktailGenerator")
    public String randomCocktailGenerator (@ModelAttribute Search search, Errors errors, Model model) throws IOException, InterruptedException {
        if (errors.hasErrors()) {
            System.out.println(errors.getAllErrors().toString());
            return "search/randomCocktailGenerator";
        }
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://www.thecocktaildb.com/api/json/v1/1/random.php";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseString = response.body().toString();
        // Map JSON string to an object
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.readValue(response.body(), Map.class);

        // the API returns an object containing an array with a key of "drinks".
        // So get the value for "drinks", and cast it to an ArrayList so that we can iterate over the drinks.
        ArrayList drinksArray = (ArrayList) map.get("drinks");

        // Pass a list of drinks to the template
        model.addAttribute("drinksArray", drinksArray);
        System.out.println(response.body());
        model.addAttribute("response", response.body().toString());
        model.addAttribute("search", search.getSearchParameter());
        return "search/randomGeneratorResults";
    }

    @GetMapping("/recipe")
    public String displayRecipe(@RequestParam String cocktailId, Model model) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        String encodedId = URLEncoder.encode(cocktailId, StandardCharsets.UTF_8);
        String url = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + encodedId;
        System.out.println("Request URL: " + url);
        System.out.println("ID: " + encodedId);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseString = response.body().toString();
        // Map JSON string to an object
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(response.body(), Map.class);

        // the API returns an object containing an array with a key of "drinks".
        // So get the value for "drinks", and cast it to an ArrayList so that we can iterate over the drinks.
        ArrayList drinksArray = (ArrayList) map.get("drinks");


        model.addAttribute("drinksArray", drinksArray);
        model.addAttribute("cocktailId", cocktailId);


        // Pass a list of drinks to the template
        System.out.println(response.body());
        return "search/recipe";
    }

}