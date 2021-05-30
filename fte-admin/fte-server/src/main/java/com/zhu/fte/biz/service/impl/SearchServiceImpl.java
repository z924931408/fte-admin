package com.zhu.fte.biz.service.impl;

import com.zhu.fte.biz.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * TODO
 *
 * @author zhujiqian
 * @date 2021/2/9 22:13
 */
@Slf4j
@Service
public class SearchServiceImpl implements SearchService {


    private RestClient restClient;

    @Override
    public void initEs() {
        restClient=RestClient.builder(new HttpHost("localhost",9200,"http")).build();
        log.info("ElasticSearch init in service");
    }

    @Override
    public void closeEs() {
        try {
            restClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
