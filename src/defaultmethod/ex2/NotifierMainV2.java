package defaultmethod.ex2;

import java.time.LocalDateTime;
import java.util.List;

public class NotifierMainV2 {

    public static void main(String[] args) {
        List<Notifier> notifiers = List.of(new EmailNotifier(), new SMSNotifier(), new AppPushNotifier());
        notifiers.forEach(n -> n.scheduleNotification("가입을 환영합니다.", LocalDateTime.now().plusDays(1)));
        /*
        [Email 전용 스케줄링] message: 가입을 환영합니다., time: 2026-10-18T02:25:36.208165
        [기본 스케줄링] message: 가입을 환영합니다., time: 2026-10-18T02:25:36.224873
        [기본 스케줄링] message: 가입을 환영합니다., time: 2026-10-18T02:25:36.225419
        */
    }
}
