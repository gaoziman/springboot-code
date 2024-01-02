package org.javatop.dynamic.config;

import org.javatop.dynamic.constant.DataSourceType;
import org.javatop.dynamic.utils.DynamicDataSourceUtil;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-02 15:18
 * @description : 定义动态数据源
 */
@Component
public class DynamicDataSource extends AbstractRoutingDataSource {

    public DynamicDataSource(LoadDataSource loadDataSource) {
        // 1、设置所有的数据源
        Map<String, DataSource> stringDataSourceMap = loadDataSource.loadAllDataSource();
        super.setTargetDataSources(new HashMap<>(stringDataSourceMap));
        // 2、设置默认的数据源
        super.setDefaultTargetDataSource(stringDataSourceMap.get(DataSourceType.default_ds_name));

        super.afterPropertiesSet();
    }

    /**
     * 这个方法用来返回数据源名称，当系统需要获取数据源的时候，会自动调用该方法获取数据源的名称
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceUtil.getDataSourceType();
    }
}
