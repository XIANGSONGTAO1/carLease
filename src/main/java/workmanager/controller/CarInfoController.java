package workmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import workmanager.service.CarInfoService;
import workmanager.util.MyResult;

import java.util.Date;

@Controller
@RequestMapping("/CarInfoController")
public class CarInfoController {
    @Autowired
    private CarInfoService carInfoService;
    @ResponseBody
    @GetMapping("/getCarPrice")
    public MyResult getCarPrice(@RequestParam("vinCode") String vinCode, @RequestParam("mileage") Double mileage, @RequestParam("registration") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date registration, @RequestParam("condition") Double condition){
        MyResult myResult = new MyResult();
        double price = carInfoService.GetCarValuation(vinCode,mileage,registration,condition);
        if (price==0.0){
            myResult.setMessage("VINCODE码错误");
            myResult.setCode(500);
            return myResult;
        }
        myResult.setCode(200);
        myResult.setObj(price);
        return myResult;
    }
}
