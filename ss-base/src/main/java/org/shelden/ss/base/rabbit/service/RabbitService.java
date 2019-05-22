package org.shelden.ss.base.rabbit.service;

import org.shelden.ss.base.rabbit.message.Message;

/**
 * The interface RabbitService.
 *
 * @param <T> the message type
 */
public interface RabbitService<T extends Message> {

    /**
     * Sends message to the specific queue.
     *
     * @param message the message
     * @param queue   the queue name
     */
    void send(T message, String queue);
}
