package beverage_order_kiosk_ver2.kiosk.data.beverageInfo;

import beverage_order_kiosk_ver2.kiosk.data.beverageInfo.enums.*;
import java.util.HashMap;
import java.util.Map;

//옵션 별 가격정보를 담은 Map
public class BeverageInfo {
    private static final Map<String, Integer> BEVERAGE_MAP_KIND = new HashMap<>();
    private static final Map<String, Integer> BEVERAGE_MAP_SHOT = new HashMap<>();
    private static final Map<String, Integer> BEVERAGE_MAP_SIZE = new HashMap<>();
    private static final Map<String, Integer> BEVERAGE_MAP_TEMPER = new HashMap<>();
    private static final Map<String, Integer> BEVERAGE_MAP_WHERE = new HashMap<>();

    public BeverageInfo() {
        setBeverageMap_kind();
        setBeverageMap_shot();
        setBeverageMap_size();
        setBeverageMap_temper();
        setBeverageMap_where();
    }

    public static Map<String, Integer> getBeverageMapKind() {
        return BEVERAGE_MAP_KIND;
    }
    public void setBeverageMap_kind() {
        BEVERAGE_MAP_KIND.put(KIND.AMERICANO.name(), 1000);
        BEVERAGE_MAP_KIND.put(KIND.VANILLA_LATTE.name(), 2500);
        BEVERAGE_MAP_KIND.put(KIND.LEMON_ADE.name(), 3000);
        BEVERAGE_MAP_KIND.put(KIND.GRAPEFRUIT_ADE.name(), 3000);
        BEVERAGE_MAP_KIND.put(KIND.WATERMELON_JUICE.name(), 4000);
        BEVERAGE_MAP_KIND.put(KIND.TOMATO_JUICE.name(), 4000);
    }

    public static Map<String, Integer> getBeverageMapShot() {
        return BEVERAGE_MAP_SHOT;
    }
    public void setBeverageMap_shot() {
        BEVERAGE_MAP_SHOT.put(SHOT.ONE_SHOT.name(), 1000);
        BEVERAGE_MAP_SHOT.put(SHOT.TWO_SHOT.name(), 1000);
    }

    public static Map<String, Integer> getBeverageMapSize() {
        return BEVERAGE_MAP_SIZE;
    }
    public void setBeverageMap_size() {
        BEVERAGE_MAP_SIZE.put(SIZE.S.name(), 1000);
        BEVERAGE_MAP_SIZE.put(SIZE.M.name(), 1000);
        BEVERAGE_MAP_SIZE.put(SIZE.L.name(), 1000);
    }

    public static Map<String, Integer> getBeverageMapTemper() {
        return BEVERAGE_MAP_TEMPER;
    }
    public void setBeverageMap_temper() {
        BEVERAGE_MAP_TEMPER.put(TEMPER.ICE.name(), 4000);
        BEVERAGE_MAP_TEMPER.put(TEMPER.HOT.name(), 4000);
    }

    public static Map<String, Integer> getBeverageMapWhere() {
        return BEVERAGE_MAP_WHERE;
    }
    public void setBeverageMap_where() {
        BEVERAGE_MAP_WHERE.put(WHERE.STORE.name(), 1000);
        BEVERAGE_MAP_WHERE.put(WHERE.TAKEOUT.name(), 1000);
    }
}
