package cn.hylexus.config.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是不是Mac系统
 *
 * @author hylexus
 * createdAt 2018/3/11
 **/
public class MacOsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("os.name", "Windows").toLowerCase().contains("mac");
    }
}
