package workmanager.config;

import workmanager.interceptors.CommonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    // 多个拦截器组成一个拦截器链
    // addPathPatterns 用于添加拦截规则
    // excludePathPatterns 用户排除拦截

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommonInterceptor())//添加拦截器
                .addPathPatterns("/**") //拦截所有请求
                .excludePathPatterns("/UserCon/**", "/Doctor/**", "/SMS/**");//对应的不拦截的请求
    }
}
