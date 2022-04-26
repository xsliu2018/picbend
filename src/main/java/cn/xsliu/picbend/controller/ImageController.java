package cn.xsliu.picbend.controller;

import cn.xsliu.picbend.vo.Result;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.xsliu.picbend.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @description: <a href="mailto:xsl2011@outlook.com" />
 * @time: 2022/4/26/15:39
 * @author: lxs
 */

@RestController
@SuppressWarnings("all")
@Slf4j
@RequestMapping("/pic_bend")
public class ImageController {

    @Resource
    HttpServletRequest request;

    @PutMapping("/upload")
    public Result uploadImg(@RequestBody MultipartFile img, @RequestParam(value = "name", required = false) String name) throws IOException {
        if (img == null || img.isEmpty()) {
            return Result.fail("PARAM_ERROR: EMPTY IMAGE");
        }
        if (img.getSize() > Constants.MAX_IMG_SIZE) {
            return Result.fail("PARAM_ERROR: IMAGE SIZE MUST BE LESS THAN" + Constants.MAX_IMG_SIZE / Constants.M + "MB");
        }

        if (StrUtil.isBlank(name)) {
            name = UUID.randomUUID().toString();
        }
        String ext = FileUtil.extName(img.getOriginalFilename());


        name = String.format("%s.%s", name, ext);
        File saveFile = new File(Constants.ROOT_DIR, name);
        if (saveFile.exists()) {
            return Result.fail(String.format("PARAM_ERROR: %s already exist", name));
        }
        img.transferTo(saveFile);

        return Result.success("http://" + Constants.IP + ":9999/" + name);
    }

}
