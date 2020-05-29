package json;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import json.pojo.FinanceProfit;
import json.pojo.ListData;
import json.pojo.ResponeResult;
import json.pojo.UserAndVa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yangheng on 2017/6/9.
 */
public class GsonTest {
    public static void main(String[] args) {
        Map<String, Long> userAndVa = Maps.newHashMap();
        List userAndVaList = new ArrayList();
        userAndVaList.add(new UserAndVa(5336984l, 349481l));
        userAndVaList.add(new UserAndVa(2153551l, 349541l));
        userAndVaList.add(new UserAndVa(105487l, 349571l));
        userAndVaList.add(new UserAndVa(834104l, 349919l));
        userAndVaList.add(new UserAndVa(6782630l, 350002l));
        userAndVaList.add(new UserAndVa(326658l, 350041l));
        userAndVaList.add(new UserAndVa(7478216l, 350065l));
        userAndVaList.add(new UserAndVa(1067146l, 350335l));
        userAndVaList.add(new UserAndVa(7654111l, 351327l));
        userAndVaList.add(new UserAndVa(806995l, 351374l));
        userAndVaList.add(new UserAndVa(1415322l, 351375l));
        userAndVaList.add(new UserAndVa(6754109l, 351427l));
        userAndVaList.add(new UserAndVa(5084567l, 351469l));
        userAndVaList.add(new UserAndVa(3408295l, 351908l));
        userAndVaList.add(new UserAndVa(7660064l, 351939l));
        userAndVaList.add(new UserAndVa(4325221l, 351985l));
        userAndVaList.add(new UserAndVa(5267313l, 352128l));
        userAndVaList.add(new UserAndVa(3388079l, 352216l));
        userAndVaList.add(new UserAndVa(3629867l, 352863l));
        userAndVaList.add(new UserAndVa(1004021l, 352894l));
        userAndVaList.add(new UserAndVa(1188184l, 352918l));
        userAndVaList.add(new UserAndVa(422645l, 352971l));
        userAndVaList.add(new UserAndVa(1302249l, 352992l));
        userAndVaList.add(new UserAndVa(1154276l, 353214l));
        userAndVaList.add(new UserAndVa(97800l, 353241l));
        userAndVaList.add(new UserAndVa(5542675l, 353245l));
        userAndVaList.add(new UserAndVa(7204240l, 353261l));
        userAndVaList.add(new UserAndVa(7398061l, 353315l));
        userAndVaList.add(new UserAndVa(3554629l, 353428l));
        userAndVaList.add(new UserAndVa(2170430l, 353429l));
        userAndVaList.add(new UserAndVa(293030l, 353439l));
        userAndVaList.add(new UserAndVa(961866l, 353446l));
        userAndVaList.add(new UserAndVa(4356349l, 353458l));
        userAndVaList.add(new UserAndVa(109540l, 349661l));
        userAndVaList.add(new UserAndVa(3760779l, 349692l));
        userAndVaList.add(new UserAndVa(7538467l, 349770l));
        userAndVaList.add(new UserAndVa(7518513l, 349842l));
        userAndVaList.add(new UserAndVa(982345l, 349915l));
        userAndVaList.add(new UserAndVa(7642483l, 350560l));
        userAndVaList.add(new UserAndVa(7642764l, 350567l));
        userAndVaList.add(new UserAndVa(1363063l, 350772l));
        userAndVaList.add(new UserAndVa(770688l, 350823l));
        userAndVaList.add(new UserAndVa(132608l, 350865l));
        userAndVaList.add(new UserAndVa(103688l, 351494l));
        userAndVaList.add(new UserAndVa(2143642l, 351539l));
        userAndVaList.add(new UserAndVa(7624720l, 351615l));
        userAndVaList.add(new UserAndVa(129275l, 351788l));
        userAndVaList.add(new UserAndVa(136699l, 351897l));
        userAndVaList.add(new UserAndVa(7281705l, 352279l));
        userAndVaList.add(new UserAndVa(6916584l, 352353l));
        userAndVaList.add(new UserAndVa(5371764l, 353721l));
        userAndVaList.add(new UserAndVa(4768634l, 352543l));
        userAndVaList.add(new UserAndVa(415222l, 353724l));
        userAndVaList.add(new UserAndVa(4547171l, 352635l));
        userAndVaList.add(new UserAndVa(4348263l, 353727l));
        userAndVaList.add(new UserAndVa(7282408l, 352736l));
        userAndVaList.add(new UserAndVa(928382l, 353786l));
        userAndVaList.add(new UserAndVa(1442148l, 353015l));
        userAndVaList.add(new UserAndVa(1008080l, 353798l));
        userAndVaList.add(new UserAndVa(936607l, 353132l));
        userAndVaList.add(new UserAndVa(6838447l, 354159l));
        userAndVaList.add(new UserAndVa(7493451l, 353157l));
        userAndVaList.add(new UserAndVa(4125558l, 354170l));
        userAndVaList.add(new UserAndVa(5462488l, 353164l));
        userAndVaList.add(new UserAndVa(422972l, 354252l));
        userAndVaList.add(new UserAndVa(1244372l, 353178l));
        userAndVaList.add(new UserAndVa(104450l, 354279l));
        userAndVaList.add(new UserAndVa(2142329l, 353349l));
        userAndVaList.add(new UserAndVa(7133367l, 354403l));
        userAndVaList.add(new UserAndVa(5444784l, 353369l));
        userAndVaList.add(new UserAndVa(7260116l, 353392l));
        userAndVaList.add(new UserAndVa(5500809l, 353399l));
        userAndVaList.add(new UserAndVa(3743871l, 353423l));
        userAndVaList.add(new UserAndVa(1003976l, 353547l));
        userAndVaList.add(new UserAndVa(1324579l, 353626l));
        userAndVaList.add(new UserAndVa(7537476l, 353631l));
        userAndVaList.add(new UserAndVa(1357288l, 353644l));
        userAndVaList.add(new UserAndVa(1356051l, 353682l));
        userAndVaList.add(new UserAndVa(97216l, 353871l));
        userAndVaList.add(new UserAndVa(92620l, 353902l));
        userAndVaList.add(new UserAndVa(930670l, 353929l));
        userAndVaList.add(new UserAndVa(5648613l, 353961l));
        userAndVaList.add(new UserAndVa(1109666l, 354085l));
        userAndVaList.add(new UserAndVa(7232353l, 354409l));
        userAndVaList.add(new UserAndVa(113806l, 354612l));
        userAndVaList.add(new UserAndVa(948117l, 354652l));
        userAndVaList.add(new UserAndVa(7151178l, 354703l));
        userAndVaList.add(new UserAndVa(408123l, 354704l));
        Gson gson = new Gson();
        //String json.json = gson.toJson(new AccParam(userAndVaList));
        //System.out.println(json.json);
        String result = "{\n" +
                "  \"data\": {\n" +
                "    \"listData\": [\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 3107,\n" +
                "        \"receivedProfit\": 114.38,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 5084,\n" +
                "        \"receivedProfit\": 118.00,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 6975,\n" +
                "        \"receivedProfit\": 118.00,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 2934,\n" +
                "        \"receivedProfit\": 114.74,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 497,\n" +
                "        \"receivedProfit\": 233.02,\n" +
                "        \"vipBalance\": 2000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 781,\n" +
                "        \"receivedProfit\": 116.89,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1921,\n" +
                "        \"receivedProfit\": 1180.00,\n" +
                "        \"vipBalance\": 10000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1359,\n" +
                "        \"receivedProfit\": 1298.00,\n" +
                "        \"vipBalance\": 11000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 657,\n" +
                "        \"receivedProfit\": 1178.01,\n" +
                "        \"vipBalance\": 10000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 7351,\n" +
                "        \"receivedProfit\": 115.40,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 4957,\n" +
                "        \"receivedProfit\": 114.93,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1493,\n" +
                "        \"receivedProfit\": 1163.19,\n" +
                "        \"vipBalance\": 10000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 582,\n" +
                "        \"receivedProfit\": 590.00,\n" +
                "        \"vipBalance\": 5000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 2138,\n" +
                "        \"receivedProfit\": 7064.98,\n" +
                "        \"vipBalance\": 60000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 3244,\n" +
                "        \"receivedProfit\": 590.00,\n" +
                "        \"vipBalance\": 5000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 802,\n" +
                "        \"receivedProfit\": 115.54,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 702,\n" +
                "        \"receivedProfit\": 118.00,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1870,\n" +
                "        \"receivedProfit\": 5900.00,\n" +
                "        \"vipBalance\": 50000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1764,\n" +
                "        \"receivedProfit\": 1178.33,\n" +
                "        \"vipBalance\": 10000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 4806,\n" +
                "        \"receivedProfit\": 113.34,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 2374,\n" +
                "        \"receivedProfit\": 572.89,\n" +
                "        \"vipBalance\": 5000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 9037,\n" +
                "        \"receivedProfit\": 118.00,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1344,\n" +
                "        \"receivedProfit\": 110.50,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 547,\n" +
                "        \"receivedProfit\": 590.00,\n" +
                "        \"vipBalance\": 5000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 7423,\n" +
                "        \"receivedProfit\": 111.42,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 342,\n" +
                "        \"receivedProfit\": 587.96,\n" +
                "        \"vipBalance\": 5000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 43863,\n" +
                "        \"receivedProfit\": 28614.36,\n" +
                "        \"vipBalance\": 250000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 335,\n" +
                "        \"receivedProfit\": 590.00,\n" +
                "        \"vipBalance\": 5000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 226,\n" +
                "        \"receivedProfit\": 112.64,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 2239,\n" +
                "        \"receivedProfit\": 111.80,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 23822,\n" +
                "        \"receivedProfit\": 112.60,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 7162,\n" +
                "        \"receivedProfit\": 117.16,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1737,\n" +
                "        \"receivedProfit\": 352.21,\n" +
                "        \"vipBalance\": 3000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 21243,\n" +
                "        \"receivedProfit\": 472.00,\n" +
                "        \"vipBalance\": 4000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1028,\n" +
                "        \"receivedProfit\": 115.95,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 150,\n" +
                "        \"receivedProfit\": 118.00,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1632,\n" +
                "        \"receivedProfit\": 115.71,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 13618,\n" +
                "        \"receivedProfit\": 117.03,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 204,\n" +
                "        \"receivedProfit\": 348.71,\n" +
                "        \"vipBalance\": 3000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 170,\n" +
                "        \"receivedProfit\": 337.60,\n" +
                "        \"vipBalance\": 3000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 2336,\n" +
                "        \"receivedProfit\": 587.43,\n" +
                "        \"vipBalance\": 5000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 2491,\n" +
                "        \"receivedProfit\": 115.15,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 15525,\n" +
                "        \"receivedProfit\": 1180.00,\n" +
                "        \"vipBalance\": 10000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 15468,\n" +
                "        \"receivedProfit\": 12980.00,\n" +
                "        \"vipBalance\": 110000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 2347,\n" +
                "        \"receivedProfit\": 231.55,\n" +
                "        \"vipBalance\": 2000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 419,\n" +
                "        \"receivedProfit\": 108.73,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 3910,\n" +
                "        \"receivedProfit\": 17348.41,\n" +
                "        \"vipBalance\": 150000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 22579,\n" +
                "        \"receivedProfit\": 232.63,\n" +
                "        \"vipBalance\": 2000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 252,\n" +
                "        \"receivedProfit\": 236.00,\n" +
                "        \"vipBalance\": 2000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1569,\n" +
                "        \"receivedProfit\": 2302.00,\n" +
                "        \"vipBalance\": 20000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 5494,\n" +
                "        \"receivedProfit\": 1157.59,\n" +
                "        \"vipBalance\": 10000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 558,\n" +
                "        \"receivedProfit\": 236.00,\n" +
                "        \"vipBalance\": 2000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 77192,\n" +
                "        \"receivedProfit\": 231.01,\n" +
                "        \"vipBalance\": 2000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1993,\n" +
                "        \"receivedProfit\": 115.71,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 643,\n" +
                "        \"receivedProfit\": 695.19,\n" +
                "        \"vipBalance\": 6000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1050,\n" +
                "        \"receivedProfit\": 113.09,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 12353,\n" +
                "        \"receivedProfit\": 111.91,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 7086,\n" +
                "        \"receivedProfit\": 1848.86,\n" +
                "        \"vipBalance\": 16000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 5738,\n" +
                "        \"receivedProfit\": 457.80,\n" +
                "        \"vipBalance\": 4000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 6148,\n" +
                "        \"receivedProfit\": 340.36,\n" +
                "        \"vipBalance\": 3000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 442,\n" +
                "        \"receivedProfit\": 1161.77,\n" +
                "        \"vipBalance\": 10000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 709,\n" +
                "        \"receivedProfit\": 1147.96,\n" +
                "        \"vipBalance\": 10000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1856,\n" +
                "        \"receivedProfit\": 112.51,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 478,\n" +
                "        \"receivedProfit\": 583.15,\n" +
                "        \"vipBalance\": 5000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 4102,\n" +
                "        \"receivedProfit\": 112.31,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1852,\n" +
                "        \"receivedProfit\": 1169.85,\n" +
                "        \"vipBalance\": 10000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 9413,\n" +
                "        \"receivedProfit\": 110.68,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 2735,\n" +
                "        \"receivedProfit\": 113.74,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 2288,\n" +
                "        \"receivedProfit\": 1180.00,\n" +
                "        \"vipBalance\": 10000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 2836,\n" +
                "        \"receivedProfit\": 112.82,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 966,\n" +
                "        \"receivedProfit\": 111.77,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 818,\n" +
                "        \"receivedProfit\": 590.00,\n" +
                "        \"vipBalance\": 5000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 906,\n" +
                "        \"receivedProfit\": 112.87,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 6819,\n" +
                "        \"receivedProfit\": 112.93,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 1770,\n" +
                "        \"receivedProfit\": 114.81,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 395,\n" +
                "        \"receivedProfit\": 1180.00,\n" +
                "        \"vipBalance\": 10000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 15236,\n" +
                "        \"receivedProfit\": 112.36,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 13504,\n" +
                "        \"receivedProfit\": 112.96,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 7696,\n" +
                "        \"receivedProfit\": 5763.33,\n" +
                "        \"vipBalance\": 50000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 27869,\n" +
                "        \"receivedProfit\": 111.30,\n" +
                "        \"vipBalance\": 1000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 41199,\n" +
                "        \"receivedProfit\": 1674.21,\n" +
                "        \"vipBalance\": 11535.28\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 3723,\n" +
                "        \"receivedProfit\": 5684.15,\n" +
                "        \"vipBalance\": 50000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 15323,\n" +
                "        \"receivedProfit\": 2347.05,\n" +
                "        \"vipBalance\": 20000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 892,\n" +
                "        \"receivedProfit\": 1180.00,\n" +
                "        \"vipBalance\": 10000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 3010,\n" +
                "        \"receivedProfit\": 1759.43,\n" +
                "        \"vipBalance\": 15000.00\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 11434,\n" +
                "        \"receivedProfit\": 94.74,\n" +
                "        \"vipBalance\": 807.89\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 3555,\n" +
                "        \"receivedProfit\": 112.11,\n" +
                "        \"vipBalance\": 116.02\n" +
                "      },\n" +
                "      {\n" +
                "        \"profitAccountVersion\": 8700,\n" +
                "        \"receivedProfit\": 2242.00,\n" +
                "        \"vipBalance\": 19000.00\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"errorCode\": \"0000000\",\n" +
                "  \"errorMessage\": \"处理成功\",\n" +
                "  \"succeed\": true\n" +
                "}";
        ResponeResult rr = gson.fromJson(result,ResponeResult.class);
        ListData data = rr.getData();
        for (FinanceProfit financeProfit : data.getListData()) {
            //System.out.println(financeProfit.getReceivedProfit());
            System.out.println(financeProfit.getVipBalance());
        }


    }


}
