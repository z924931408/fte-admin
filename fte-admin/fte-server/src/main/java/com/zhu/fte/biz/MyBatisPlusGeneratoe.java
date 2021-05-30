package com.zhu.fte.biz;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * TODO
 *
 * @author zhujiqian
 * @date 2020/12/24 23:39
 */
public class MyBatisPlusGeneratoe {
    public static void main(String[] args) {
        //1.全局配置
        GlobalConfig config=new GlobalConfig();
        //是否支持AR模式
        config.setActiveRecord(true)
                //作者
                .setAuthor("ZQJ")
                //生成路径
                .setOutputDir("D:\\MyExample\\My-project\\fte\\biz\\src\\main\\java")
                //文件覆盖
                .setFileOverride(true)
                //主键策略
                .setIdType(IdType.INPUT)
                //设置生成的service接口名字首字母是否为I
                .setServiceName("%sService")
                //生成基本的resultMap
                .setBaseResultMap(true)
                //生产基本的SQL片段
                .setBaseColumnList(true);

        //2、数据源配置
        DataSourceConfig dsConfig=new DataSourceConfig();
        //设置数据库类型
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://127.0.0.1:3306/fteDb")
                .setUsername("root")
                .setPassword("root924931408");

        //3、策略配置globalConfiguration中
        StrategyConfig setConfig=new StrategyConfig();
        //全局大写命名
        setConfig.setCapitalMode(true)
                //数据库表映射到实体的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                //生成的表
                .setInclude("sys_user_role");

        //4、包名策略配置
        PackageConfig pkConfig=new PackageConfig();
        pkConfig.setParent("com.zhu.fte.biz")
                //dao
                .setMapper("mapper")
                //service
                .setService("service")
                //controller
                .setController("controller")
                .setEntity("entity")
                .setXml("mapper");

        //5.整合配置
        AutoGenerator ag=new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(setConfig)
                .setPackageInfo(pkConfig);

        //6.执行
        ag.execute();
    }
}
