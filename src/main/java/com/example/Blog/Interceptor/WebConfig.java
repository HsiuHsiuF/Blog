package com.example.Blog.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns("/**") 表示攔截所有的請求
        //excludePathPatterns("/firstLogin","/zhuce");設置白名單，就是攔截器不攔截。
        // 登錄頁面在攔截器配置中配置的是排除路徑，可以看到即使放行了，還是會進入prehandle，但是不會執行任何操作。
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(
                        "/blogs/**",
                        "/blogsInput/**",
                        "/blogsUpdate/**",
                        "/tags/**",
                        "/tagsInput/**"
                        )
                .excludePathPatterns(
                        "/register",
                        "/login",
                        "/blog/**",
                        "/home/**",
                        "/homeTags/**",
                        "/**/*.js",
                        "/**/*.css",
                        "/**/*.jpg",
                        "/**/*.png",
                        "/**/*.svg"
                );
    }


}

