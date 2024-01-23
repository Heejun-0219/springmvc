package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
// 반환시 HTTP 메시지 바디에 바로 입력
@Slf4j // 롬복 어노테이션
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // 로그 레벨 순서: trace < debug < info < warn < error
        // 로그 레벨에 따라서 출력되는 로그가 달라짐 -> logging.level.hello.springmvc=info (default: info)
        log.trace("trace log={}", name); // log.trace("trace log={}"+ name); => 자바 특성과 관련되어 + 연산을 먼저 실핼하기 때문에 불필요하게 발생
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
