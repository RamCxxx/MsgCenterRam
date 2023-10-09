package com.ram.msgcenter.handler.deduplication;

import com.ram.msgcenter.handler.deduplication.build.Builder;
import com.ram.msgcenter.handler.deduplication.service.DeduplicationService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * @author ramxx
 */
@Service
public class DeduplicationHolder {

    private final Map<Integer, Builder> builderHolder = new HashMap<>(4);
    private final Map<Integer, DeduplicationService> serviceHolder = new HashMap<>(4);

    public Builder selectBuilder(Integer key) {
        return builderHolder.get(key);
    }

    public DeduplicationService selectService(Integer key) {
        return serviceHolder.get(key);
    }

    public void putBuilder(Integer key, Builder builder) {
        builderHolder.put(key, builder);
    }

    public void putService(Integer key, DeduplicationService service) {
        serviceHolder.put(key, service);
    }
}
