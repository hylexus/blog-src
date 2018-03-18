package cn.hylexus.config.slector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author hylexus
 * createdAt 2018/3/11
 **/
public class ImportSelectorImpl implements ImportSelector {

    /**
     * @return 返回值是要加入到容器中的bean的全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
        return new String[]{
                HashSet.class.getName(),
                HashMap.class.getName()
        };
    }
}
