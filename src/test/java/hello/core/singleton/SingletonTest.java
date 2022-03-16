package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 純粹한 DI Container")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1。照會: 呼出할 때 마다 客體를 生成
        MemberService memberService1 = appConfig.memberService();

        // 2。照會: 呼出할 때 마다 客體를 生成
        MemberService memberService2 = appConfig.memberService();

        // 參照값이 다른 것을 確認
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("Singleton 패턴을 適用한 客體 使用")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
        // same -> Java의 「==」
        // equal -> Java의 「equals」

    }
}
