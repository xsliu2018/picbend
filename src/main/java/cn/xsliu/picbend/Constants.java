package cn.xsliu.picbend;

import cn.hutool.core.io.FileUtil;
import cn.hutool.setting.Setting;
import cn.hutool.system.SystemUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: <a href="mailto:xsl2011@outlook.com" />
 * @time: 2022/4/26/17:17
 * @author: lxs
 */
@Slf4j
public class Constants {

    public static int K = 1024;
    public static int M = K * 1024;
    public static int MAX_IMG_SIZE = 3;

    public static final Set<String> SUPPORTED_FORMATS;

    public static final String formats = "jpg png gif jpeg tif";

    public static String IP = "127.0.0.1";
    public static String ROOT_DIR = "/home/pic_bend/";
    static{
        String userDir = SystemUtil.get("user.dir");
        System.out.println(userDir);
        File config = new File(userDir, "pic_bend.setting");
        Setting setting = new Setting(config, StandardCharsets.UTF_8, true);

        IP = setting.getOrDefault("ip", IP);
        log.info("公网IP:" + IP);

        ROOT_DIR = setting.getOrDefault("root_dir", ROOT_DIR);
        if (!FileUtil.exist(ROOT_DIR)){
            FileUtil.mkdir(ROOT_DIR);
        }
        log.info("图像存储路径: " + ROOT_DIR);

        MAX_IMG_SIZE = setting.getInt("max_img_size", MAX_IMG_SIZE) * M;
        log.info("单次最大支持图像: " + MAX_IMG_SIZE);

        String[] strings = setting.getOrDefault("format", formats).split(" ");
        SUPPORTED_FORMATS = new HashSet<>();
        SUPPORTED_FORMATS.addAll(Arrays.asList(strings));
        log.info("支持的文件类型: " + Arrays.toString(SUPPORTED_FORMATS.toArray()));


    }
}
