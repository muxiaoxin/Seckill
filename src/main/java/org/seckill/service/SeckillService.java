package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在"使用者"角度设计接口
 * 是三个方面： 方法定义粒度，参数，返回类型（可能返回异常）
 */

public interface SeckillService {
    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 当秒杀开始时输出秒杀接口的地址，
     * 否则输出系统时间和秒杀时间
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution exceuteSeckill(long seckillId, long userPhone, String md5) throws SeckillException,RepeatKillException,SeckillCloseException;

    /**
     * 执行秒杀操作 by 存储过程
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution exceuteSeckillProcedure(long seckillId, long userPhone, String md5);
}
