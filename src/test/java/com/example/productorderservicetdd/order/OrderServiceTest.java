package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.product.DiscountPolicy;
import com.example.productorderservicetdd.product.Product;
import com.example.productorderservicetdd.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

class OrderServiceTest {

    private OrderService orderService;
    private OrderRepository orderRepository;
    private OrderPort orderPort;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
        orderPort = new OrderPort() {
            @Override
            public Product getProductById(Long productId) {
                return new Product("상품명" ,1000, DiscountPolicy.NONE);
            }

            @Override
            public void save(Order order) {
                orderRepository.save(order);
            }
        };
        orderService = new OrderService(orderPort);
    }

    @Test
    void 상품주문() {
        final Long productId = 1L;
        final int quantity = 2;
        final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);

        orderService.createOrder(request);
    }

    private record CreateOrderRequest(Long productId, int quantity) {
            private CreateOrderRequest(Long productId, int quantity) {
                this.productId = productId;
                this.quantity = quantity;
                Assert.notNull(productId, "productId must not be null");
                Assert.isTrue(quantity > 0, "quantity must be greater than 0");
            }
        }

    private class OrderService {
        private final OrderPort orderPort;

        private OrderService(final OrderPort orderPort) {
            this.orderPort = orderPort;
        }

        public void createOrder(final CreateOrderRequest request) {
            final Product product = orderPort.getProductById(request.productId());
            
            final Order order = new Order(product, request.quantity());

            orderPort.save(order);
        }


    }

    public interface OrderPort {
        Product getProductById(Long productId);
        void save(Order order);
    }

    private class OrderAdaptor implements OrderPort {
        private final ProductRepository productRepository;
        private final OrderRepository orderRepository;

        public OrderAdaptor(ProductRepository productRepository, OrderRepository orderRepository) {
            this.productRepository = productRepository;
            this.orderRepository = orderRepository;
        }

        public Product getProductById(Long productId) {
            return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
        }

        public void save(Order order) {
            orderRepository.save(order);
        }
    }

    public static class Order {
        private Long id = 0L;
        private final Product product;
        private final int quantity;

        public Order(final Product product, final int quantity) {
            Assert.notNull(product, "상품은 필수입니다");
            Assert.isTrue(quantity > 0, "수량은 0보다 커야합니다.");
            this.product = product;
            this.quantity = quantity;
        }

        public void assignId(final Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    private class OrderRepository {
        private final Map<Long, Order> persistence = new HashMap<>();
        private Long sequence = 0L;
        public void save(Order order) {
            order.assignId(++sequence);
            persistence.put(order.getId(), order);
        }
    }
}
