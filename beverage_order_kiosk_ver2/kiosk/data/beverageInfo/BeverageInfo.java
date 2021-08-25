package beverage_order_kiosk_ver2.kiosk.data.beverageInfo;

import java.util.HashMap;
import java.util.Map;

public class BeverageInfo {
    public enum KIND {
        AMERICANO,
        VANILLA_LATTE,
        LEMON_ADE,
        GRAPEFRUIT_ADE,
        WATERMELON_JUICE,
        TOMATO_JUICE
    }
    public enum SHOT { ONE_SHOT, TWO_SHOT }
    public enum SIZE { S, M, L }
    public enum TEMPER { ICE, HOT }
    public enum WHERE { STORE, TAKEOUT}

    public Map<String, Integer> getBeverageMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put(KIND.AMERICANO.name(), 1000);
        map.put(KIND.VANILLA_LATTE.name(), 2500);
        map.put(KIND.LEMON_ADE.name(), 3000);
        map.put(KIND.GRAPEFRUIT_ADE.name(), 3000);
        map.put(KIND.WATERMELON_JUICE.name(), 4000);
        map.put(KIND.TOMATO_JUICE.name(), 4000);
        return map;
    }
}
