package cn.xsliu.picbend.vo;

import cn.hutool.json.JSONObject;

/**
 * @description: <a href="mailto:xsl2011@outlook.com" />
 * @time: 2022/4/26/16:20
 * @author: lxs
 */
public class Result extends JSONObject {


    public static Result fail(String code){
        Result result = new Result();
        result.set("code", code);
        return result;
    }

    public static Result success(String path){
        Result result = new Result();
        result.set("url", path);
        return result;

    }
}
