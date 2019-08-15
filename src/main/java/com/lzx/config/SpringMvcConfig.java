package com.lzx.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Spring MVC 配置类（注入FastJson）
 *
 * @author : lzx
 * Created by lzx on 18/12/10.
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {


    /**
     * 设置编码，解决中文乱码
     */
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }

    /**
     * 添加到内置转换器之后（移除jackson，使用fastJson）
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(next -> next instanceof MappingJackson2HttpMessageConverter);
        converters.add(fastJsonConverter());
        //为了适配某些模块使用了特定的Jackson所以添加在最后默认解析fastjson没有处理完的特殊json格式
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    /**
     * 配置fastJson
     */
    private AbstractHttpMessageConverter fastJsonConverter() {
        final FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        final FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.IgnoreErrorGetter, SerializerFeature.WriteNullStringAsEmpty);
        config.setCharset(StandardCharsets.UTF_8);
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConverter.setFastJsonConfig(config);
        //spring要求Content-Type不能含有通配符，fastJson默认为MediaType.ALL不可使用，这应该是一种保护机制,并强制用户自己配置MediaType
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonConverter.setSupportedMediaTypes(supportedMediaTypes);

        return fastJsonConverter;
    }

}
