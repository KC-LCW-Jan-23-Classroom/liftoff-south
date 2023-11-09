package boozeblender.controllers;

import boozeblender.models.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping("/byIngredient")
    public String searchByIngredient(Model model) {
        model.addAttribute(new Search());
        return "search/byIngredient";
    }
    @GetMapping("/byIngredientResults")
    public String get(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?i=Vodka";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        return "search/byIngredientResults";
    }

    @PostMapping("/byIngredient")
    public String searchByIngredient (@ModelAttribute Search search, Errors errors, Model model) {
        return "search/byIngredientResults";
    }

    @GetMapping("/byGlass")
    public String searchByGlass(Model model) {
        model.addAttribute(new Search());
        return "search/byGlass";
    }

    @PostMapping("/byGlass")
    public String searchByGlass(@ModelAttribute Search search, Errors errors, Model model) {
        return "index";
    }

    @GetMapping("/alcoholicFilter")
    public String alcoholicFilter(Model model) {
        model.addAttribute(new Search());
        return "search/alcoholicFilter";
    }

    @PostMapping("/alcoholicFilter")
    public String alcoholicFilter (@ModelAttribute Search search, Errors errors, Model model) {
        return "index";
    }

    @GetMapping("/randomCocktailGenerator")
    public String randomCocktailGenerator(Model model) {
        model.addAttribute(new Search());
        return "search/randomCocktailGenerator";
    }

    @PostMapping("/randomCocktailGenerator")
    public String randomCocktailGenerator (@ModelAttribute Search search, Errors errors, Model model) {
        return "index";
    }

}