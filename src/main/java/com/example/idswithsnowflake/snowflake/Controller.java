package com.example.idswithsnowflake.snowflake;

import com.example.idswithsnowflake.apis.Ids;
import com.example.idswithsnowflake.apis.SnowflakeApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller implements SnowflakeApi {

    @Override
    public ResponseEntity<Ids> snowflake(Integer nodeId) {
        Snowflake snowflake = Snowflake.valueOfNodeId(nodeId);
        long l = snowflake.nextId();
        Ids ids = new Ids();
        ids.setNode(nodeId);
        ids.setValue(l);
        return ResponseEntity.ok(ids);
    }
}
