package info.biernacki.sushifactorywebserver.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {



    @GetMapping("/version")
    public String getNumberOfVersion(){
        return new Version().getAppVersion();
    }
}
