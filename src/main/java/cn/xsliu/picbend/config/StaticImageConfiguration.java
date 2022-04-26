package cn.xsliu.picbend.config;

import cn.xsliu.picbend.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: <a href="mailto:xsl2011@outlook.com" />
 * @time: 2022/4/26/17:15
 * @author: lxs
 */
@Configuration
public class StaticImageConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("file:" + Constants.ROOT_DIR);
    }
}
