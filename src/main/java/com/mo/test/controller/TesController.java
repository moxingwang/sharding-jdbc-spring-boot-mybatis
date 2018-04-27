package com.mo.test.controller;

import com.mo.test.entity.Order;
import com.mo.test.entity.OrderItem;
import com.mo.test.mapper.OrderItemMapper;
import com.mo.test.mapper.OrderMapper;
import com.mo.test.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * Created by MoXingwang on 2017/6/14.
 */
@RestController
@RequestMapping(value = "")
public class TesController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        Order order = new Order();
        order.setCreateDate(new Date());
        order.setSerialNumber(UUID.randomUUID().toString());

        orderMapper.insert(order);

    /*    OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(order.getId());
        orderItem.setProductName(UUID.randomUUID().toString());
        orderItemMapper.insert(orderItem);
*/
        return order.getId()+"";
    }
}
