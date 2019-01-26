package com.movies.controller;

import com.movies.model.Category;
import com.movies.model.CategoryDao;
import com.movies.model.Movie;
import com.movies.model.MovieDao;
import com.movies.model.OrdersDao;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    MovieDao movieDao;

    @Autowired
    OrdersDao ordersDao;

    @RequestMapping("/")
    public String index() {

        return "admin/index";

    }

    @RequestMapping("/movies")
    public String movies(@RequestParam(defaultValue = "1") Integer page, ModelMap model) {
        List<Movie> movies = movieDao.findByPage(page - 1);
        model.addAttribute("movies", movies);
        model.addAttribute("totalpages", movieDao.pages());
        return "admin/movies";
    }

    @RequestMapping(value = "/entermovie", method = RequestMethod.POST)
    public String enterMoviePost(
            @RequestParam String title,
            @RequestParam String price,
            @RequestParam Integer supersaver,
            @RequestParam String availability,
            @RequestParam MultipartFile photo,
            @RequestParam Integer category,
            ModelMap model, HttpServletRequest request) {
        
        List<Category> categories = categoryDao.find();
        model.addAttribute("categories",categories);
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setPrice(new BigDecimal(price));
        movie.setSupersaver(new BigDecimal(supersaver));
        movie.setAvailability(new Short(availability));
        
        if (photo != null && !photo.isEmpty()) {
            try {
            String filePath = request.getServletContext().getRealPath("resources/images");
            FileOutputStream fos = new FileOutputStream(filePath + "/" + photo.getOriginalFilename());
            movie.setPhoto(photo.getOriginalFilename());
            fos.write(photo.getBytes());
            fos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        movie.setCategory(category);
        movieDao.save(movie);
        return "admin/entermovie";
        
    }

    
    @RequestMapping("/entermovie")
    public String enterMovie(ModelMap model){
        List<Category> categories = categoryDao.find();
        model.addAttribute("categories",categories);
        
        return "admin/entermovie";
    }
    
    
    @RequestMapping(value = "/updatemovie", method = RequestMethod.POST)
    public String updateMoviePost(
            @RequestParam Integer id,
            @RequestParam String title,
            @RequestParam String price,
            @RequestParam Integer category,
            @RequestParam MultipartFile photo,
            ModelMap model,
            HttpServletRequest request) throws FileNotFoundException, IOException {
        List<Category> categories = categoryDao.find();
        Movie movie = movieDao.getById(id);
        movie.setTitle(title);
        movie.setPrice(new BigDecimal(price));
        movie.setCategory(category);

        if (photo != null && !photo.isEmpty()) {
            String filePath = request.getServletContext().getRealPath("resources/images");
            FileOutputStream fos = new FileOutputStream(filePath + "/" + photo.getOriginalFilename());
            movie.setPhoto(photo.getOriginalFilename());
            fos.write(photo.getBytes());
            fos.close();
        }
        model.addAttribute("categories", categories);

        movieDao.update(movie);
        model.addAttribute("movie", movie);
        return "admin/updatemovie";
    }

    @RequestMapping(value = "/updatemovie", method = RequestMethod.GET)
    public String updateMovie(@RequestParam Integer id, ModelMap model) {
        List<Category> categories = categoryDao.find();
        model.addAttribute("categories", categories);
        Movie movie = movieDao.getById(id);
        model.addAttribute("movie", movie);
        return "admin/updatemovie";
    }

    @RequestMapping("/updatecategory")
    public String updateCategory(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam String description,
            ModelMap model) {

        List<Category> categories = categoryDao.find();
        Category selectedCategory = categoryDao.getById(id);
        selectedCategory.setName(name);
        selectedCategory.setDescription(description);
        categoryDao.update(selectedCategory);
        model.addAttribute("categories", categories);
        model.addAttribute("selectedCategory", selectedCategory);
        return "admin/categories";
    }

    @RequestMapping("/categories")
    public String categories(@RequestParam(required = false) Integer id, ModelMap model) {

        List<Category> categories = categoryDao.find();
        model.addAttribute("categories", categories);
        if (id != null) {
            Category selectedCategory = categoryDao.getById(id);
            model.addAttribute("selectedCategory", selectedCategory);
        }
        return "admin/categories";
    }
}
