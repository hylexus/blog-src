package cn.hylexus.config.filter;

import cn.hylexus.dao.UserRepo;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author hylexus
 * createdAt 2018/3/11
 **/
public class TypeFilterImpl implements TypeFilter {
    /**
     * @param metadataReader        当前正在扫描的类的元数据信息
     * @param metadataReaderFactory 可以用来获取其他类的信息
     * @return 返回true表示当前类会被纳入IOC容器
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        System.out.println(">>>>>" + classMetadata.getClassName());

        // 排除UserRepo
        if (classMetadata.getClassName().equals(UserRepo.class.getName())) {
            return false;
        }

        return true;
    }
}
