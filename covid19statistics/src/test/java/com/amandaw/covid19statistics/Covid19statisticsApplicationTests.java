package com.amandaw.covid19statistics;

import com.amandaw.covid19statistics.entity.AreaState;
import com.amandaw.covid19statistics.service.DataFetchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class Covid19statisticsApplicationTests {

    @Autowired
    DataFetchService dataFetchService;

    @Test
    void contextLoads() throws IOException, InterruptedException {
        List<AreaState> list = dataFetchService.FetchData();
        for(AreaState l:list) System.out.println(l);
    }

}
