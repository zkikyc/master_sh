package com.kikyc.utils.reptile;

import com.kikyc.utils.entity.R;
import com.kikyc.utils.reptile.util.ReptileUtils;
import com.sun.deploy.net.HttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reptile")
public class ReptileController {

    @RequestMapping("/getHtml")
    public R getHtml(@RequestParam("url") String url,@RequestParam(value="fileName",required=false)  String fileName,
                     @RequestParam(value = "path",required=false) String path,@RequestParam(value = "mode ",required=false) String mode,
                     HttpResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("url",url);
        map.put("fileName",fileName);
        map.put("path",path);
        map.put("mode",mode);
        R result = ReptileUtils.getHtml(map,response);
        return result;
    }
}
