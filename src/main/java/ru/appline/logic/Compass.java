package ru.appline.logic;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Compass implements Serializable {
    private static final Compass instance = new Compass();
    private final Map<String, Integer> model;

    public Compass() {
        model = new HashMap<String, Integer>();
    }
//т.к. в каждой стороне света всего 45 градусов, достаточно иметь лишь начало диопазона, что и принимается в качестве параметра
    public void setSides(Map<String, Integer> map) {
        model.put("North", map.get("North"));
        model.put("Northeast", map.get("Northeast"));
        model.put("East", map.get("East"));
        model.put("Southeast", map.get("Southeast"));
        model.put("South", map.get("South"));
        model.put("Southwest", map.get("Southwest"));
        model.put("West", map.get("West"));
        model.put("Northwest", map.get("Northwest"));
    }

    public String getSide(int degree) {
        String result = "";
        for (Map.Entry<String, Integer> side : model.entrySet()) {
            if ((degree >= side.getValue()) && (degree < (side.getValue() + 45))) {
                result = side.getKey();
            }
        }
        return result;
    }

    public static Compass getInstance() {
        return instance;
    }

    public String getAll() {
        return model.values().toString();
    }
}

// задать стороны
//{
//        "North":0,
//        "Northeast":45,
//        "East":90,
//        "Southeast":135,
//        "South":180,
//        "Southwest":225,
//        "West":270,
//        "Northwest":315
//        }

// Запросить сторону
//        {
//        "Degree":333
//        }