package cn.xsliu.picbend.vo;

import cn.hutool.json.JSONObject;
import lombok.Data;

/**
 * @description: <a href="mailto:xsl2011@outlook.com" />
 * @time: 2022/4/26/16:20
 * @author: lxs
 */
@Data
public class Result {
    private String url;
    private String code;
    private boolean success;

    public static Result fail(String code){
        Result result = new Result();
        result.setCode(code);
        result.setSuccess(false);
        return result;
    }

    public static Result success(String path){
        Result result = new Result();
        result.setUrl(path);
        result.setSuccess(true);
        return result;

    }
}
