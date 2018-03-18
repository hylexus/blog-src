package cn.hylexus.config.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是不是windows系统
 *
 * @author hylexus
 * createdAt 2018/3/11
 **/
public class WindowsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("os.name", "Mac OS X").toLowerCase().contains("windows");
    }
}
