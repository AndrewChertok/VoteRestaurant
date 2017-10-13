package com.restaurants.web;


import com.restaurants.model.Dish;
import com.restaurants.model.Restaurant;
import com.restaurants.util.DateTimeUtil;
import com.restaurants.web.dish.DishRestController;
import com.restaurants.web.restaurant.RestaurantRestController;
import com.restaurants.web.vote.VoteRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RestaurantServlet extends HttpServlet {

    private RestaurantRestController restaurantController;

    private VoteRestController voteController;

    private DishRestController dishController;

    private ConfigurableApplicationContext appCtx;

    private static final Logger log = LoggerFactory.getLogger(RestaurantServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml" );
        restaurantController = appCtx.getBean(RestaurantRestController.class);
        voteController = appCtx.getBean(VoteRestController.class);
        dishController = appCtx.getBean(DishRestController.class);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if("edit".equals(action)){
            String name = req.getParameter("name");
            Integer votes = Integer.valueOf(req.getParameter("votes"));
            String[] id = req.getParameterValues("id's");
            String[] dishes = req.getParameterValues("dishes");
            String[] prices = req.getParameterValues("prices");
            Restaurant editedRestaurant = restaurantController.getByName(name);

            if(editedRestaurant == null) editedRestaurant = new Restaurant(name);

            for(int i =0; i<id.length;i++){

                Dish dish = new Dish(Integer.valueOf(id[i]), dishes[i], Double.valueOf(prices[i]), editedRestaurant);
                dishController.save(dish);
            }


            req.setAttribute("restaurants",
                    restaurantController.getAll());
            req.getRequestDispatcher("restaurants.jsp").forward(req, resp);

        }

        if("create".equals(action)){
            String name = req.getParameter("name");
            String dish = req.getParameter("dish");
            String price = req.getParameter("price");
            Restaurant saved = restaurantController.save(new Restaurant(name));
            dishController.save(new Dish(null,dish, Double.valueOf(price), saved));


            req.setAttribute("restaurants",
                    restaurantController.getAll());
            req.getRequestDispatcher("restaurants.jsp").forward(req, resp);

        }

        if("filter".equals(action)){
            String start = req.getParameter("startDate");
            String end = req.getParameter("endDate");
            LocalDate startDate = DateTimeUtil.parseLocalDate(start);
            LocalDate endDate = DateTimeUtil.parseLocalDate(end);
            req.setAttribute("restaurants", restaurantController.getBetweenDates(startDate,
                    endDate));
            req.getRequestDispatcher("restaurants.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");



        switch (action == null ? "all" : action) {


            case "vote":
               voteController.vote(getId(request));
                request.setAttribute("restaurants",
                        restaurantController.getAll());
                request.getRequestDispatcher("restaurants.jsp").forward(request, response);
                break;

            case "create":
                request.getRequestDispatcher("restaurant.jsp").forward(request, response);
                break;

            case "edit":
               request.setAttribute("restaurant", restaurantController.get(getId(request)));
               request.getRequestDispatcher("restaurant.jsp").forward(request, response);
                break;

            case "delete":
                restaurantController.delete(getId(request));
                request.setAttribute("restaurants",
                        restaurantController.getAll());
                request.getRequestDispatcher("restaurants.jsp").forward(request, response);
                break;
            case "all":
            default:
                log.info("getAll");
                request.setAttribute("restaurants",
                        restaurantController.getAll());
                request.getRequestDispatcher("restaurants.jsp").forward(request, response);
                break;
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = request.getParameter("id");
        return Integer.valueOf(paramId);
    }

    @Override
    public void destroy() {
        super.destroy();
        appCtx.close();
    }

}
