package db;

import models.Advert;
import models.Category;
import models.Comment;
import models.User;

import java.util.List;

public class Seeds {
    public static void seedData(){

        DBHelper.deleteAll(Comment.class);
        DBHelper.deleteAll(Advert.class);
        DBHelper.deleteAll(User.class);




        User user1 = new User("Bob Smith", "bobsmith1@hotmail.com");
        DBHelper.save(user1);
        User user2 = new User("Fred Mercury", "IAmTheChampion@gmail.com");
        DBHelper.save(user2);

        User user = DBUser.findByEmail("bobsmith1@hotmail.com");

        Advert advert1 = new Advert("Nokia 3310", "Classic Nokia indestructable mobile phone for sale", Category.TECHNOLOGY, 50.00, "Glasgow", user1, "testphoto.imgur.com");
        DBHelper.save(advert1);

        Advert advert2 = new Advert ("Dyson", "new Dyson cordless vacuum cleaner for sale", Category.APPLIANCES, 250.00, "edinburgh", user2, "photourl.url.com");
        DBHelper.save(advert2);

        Advert advert3 = new Advert("Piano for Sale", "Yamaha U3H upright piano in excellent condition", Category.MUSICALINSTRUMENTS, 3000.00, "Glasgow", user1, "photo.com");
        DBHelper.save(advert3);

        Comment comment1 = new Comment("Does product have any changeable covers?", user1, advert1);
        DBHelper.save(comment1);
    }
}






