package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MappingController {
    @RequestMapping(value = {"/hello-basic", "/hello-go"}, method = RequestMethod.GET) // 배열로 여러개의 URL을 지정할 수 있음
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping("/mapping-get-v1")
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping("/mapping/{userId}") // PathVariable 사용 -> URL 경로에 있는 값을 파라미터로 받을 수 있음 -> 리소스 경로에 식별자
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    // 특정 파라미터 조건 매핑
    @GetMapping(value = "/mapping-param", params = "mode=debug") // params = "mode=debug" -> mode=debug 파라미터가 있어야 함
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    // 특정 헤더 조건 매핑
    @GetMapping(value = "/mapping-header", headers = "mode=debug") // headers = "mode=debug" -> mode=debug 헤더가 있어야 함
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    // 미디어 타입 조건 매핑 -> HTTP 요청 Content-Type, consume = "application/json" -> Content-Type이 application/json인 경우에만 호출됨
    @GetMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    // 미디어 타입 조건 매핑 -> HTTP 요청 Accept, produce = "text/html" -> Accept가 text/html인 경우에만 호출됨
    @GetMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }


}
