package org.shelden.ss.base.rabbit.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.shelden.ss.base.rabbit.message.Message;
import org.shelden.ss.base.rabbit.service.RabbitService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitServiceImpl<T extends Message> extends AbstractRabbitService<T> implements RabbitService<T> {

    @Autowired
    private List<Queue> queues;

    public RabbitServiceImpl(RabbitTemplate template) {
        super(template);
    }

    @Override
    protected boolean isAllowedQueue(String name) {
        return queues.stream()
                .anyMatch(queue -> StringUtils.equals(queue.getName(), name));
    }
}
