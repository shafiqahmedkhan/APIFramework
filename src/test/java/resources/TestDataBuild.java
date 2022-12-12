package resources;

import pojo.Location;
import pojo.addPlace;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
    public addPlace addPlacePayload(String name, String language, String address){
        addPlace p = new addPlace();

        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        Location l = new Location();
        l.setLat(-38.383494);
        l.setLan(33.427362);

        p.setLocation(l);
        p.setAccuracy(50);
        p.setName(name);
        p.setPhone_number("(+91) 983 893 3937");
        p.setAddress(address);
        p.setTypes(myList);
        p.setWebsite("https://rahulshettyacademy.com");
        p.setLanguage(language);
        return p;
    }
}
