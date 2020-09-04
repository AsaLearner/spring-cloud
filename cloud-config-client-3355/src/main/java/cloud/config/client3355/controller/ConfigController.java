package cloud.config.client3355.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @Value(("${server.port}"))
    private String port;

    @GetMapping("/configinfo")
    public String getConfigInfo(){
        return configInfo + "\n\n 端口："+port;
    }
}
