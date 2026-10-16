package optional;

import optional.model.Delivery;
import optional.model.Order;

import java.util.HashMap;
import java.util.Map;

public class DeliveryMain1 {

    private static Map<Long, Order> orderRepository = new HashMap<>();

    static {
        orderRepository.put(1L, new Order(1L, new Delivery("배송 완료", false)));
        orderRepository.put(2L, new Order(2L, new Delivery("배송 중", false)));
        orderRepository.put(3L, new Order(3L, new Delivery("배송 중", true)));
        orderRepository.put(4L, new Order(4L, null));
    }

    public static void main(String[] args) {
        System.out.println(getDeliveryStatus(1L)); // 배송 완료
        System.out.println(getDeliveryStatus(2L)); // 배송 중
        System.out.println(getDeliveryStatus(3L)); // 배송X
        System.out.println(getDeliveryStatus(4L)); // 배송X
    }

    private static String getDeliveryStatus(Long orderId) {
        Order order = findOrder(orderId);
        if (order == null) {
            return "배송X";
        }

        Delivery delivery = order.getDelivery();
        if (delivery == null || delivery.isCanceled()) {
            return "배송X";
        }

        String status = delivery.getStatus();
        if (status == null) {
            return "배송X";
        }

        return status;
    }

    private static Order findOrder(Long orderId) {
        return orderRepository.get(orderId);
    }
}
