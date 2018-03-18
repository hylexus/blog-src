package cn.hylexus.config;

import cn.hylexus.config.filter.TypeFilterImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author hylexus
 * createdAt 2018/3/11
 **/
@Configuration
@ComponentScan(
        value = "cn.hylexus",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.CUSTOM,
                classes = TypeFilterImpl.class
        ),
        useDefaultFilters = false
)
public class ComponentScanCustomerConfig {
}
