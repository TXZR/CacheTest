package com.tyw.springcloud.service;

import com.tyw.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public boolean add(Dept dept) {
                return false;
            }

            public Dept get(Long id) {
                return new Dept().setDname("暂停服务！！！");
            }

            public List<Dept> list() {
                return null;
            }

            public Object discovery() {
                return null;
            }
        };
    }
}
