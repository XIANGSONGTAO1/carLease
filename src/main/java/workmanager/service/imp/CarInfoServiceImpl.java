package workmanager.service.imp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.show.api.ShowApiRequest;
import org.springframework.stereotype.Service;
import workmanager.service.CarInfoService;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class CarInfoServiceImpl implements CarInfoService{
//    public static void main(String path[]) throws Exception {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = simpleDateFormat.parse("2016-06-06");
//        double price = GetCarValuation("lfv2a2150a3043256",20,date,0.6);
//        System.out.println(price);
//    }

    @Override
    public double GetCarValuation(String vinCode,double mileage, Date registration, double condition) {
        String carDetail = getCarDetailByVinCode(vinCode);
        JSONObject jsonObject = JSONObject.parseObject(carDetail);
        String detail = jsonObject.getString("showapi_res_body");
        if (detail.equals("{}")){
            return 0.0;
        }
        JSONObject jsonObject1 = JSONObject.parseObject(detail);
        String originalPrice = jsonObject1.getString("guiding_price");
        Double price = Double.valueOf(originalPrice);
        double price2 = price*10000;
        double priceYear = price2*0.5;
        double priceRoad = price2*0.3;
        double priceCondition = price2*0.2;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        int a = (int) ((now.getTime() - registration.getTime()) / (1000*3600*24));
        double years = a/365;
        years = (double) Math.round(years * 100) / 100;
        double priceYearsNow = priceYear*Math.pow(0.85, years);
        double priceRoadNow = priceRoad*Math.pow(0.9,mileage);
        double priceConditionNow = priceCondition*condition;
        double priceFinal = priceYearsNow+priceConditionNow+priceRoadNow;
        return priceFinal;
    }

    public static String getCarDetailByVinCode(String vinCode){
        String res=new ShowApiRequest("http://route.showapi.com/1142-1","118373","1590bafee1bf41a797a47d9b65690fb8")
                .addTextPara("vin","lfv2a2150a3043256")
                .post();
        return res;
    }

}
