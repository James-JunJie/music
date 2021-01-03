package com.junjie.music.service;

 
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.junjie.music.entity.Consumer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
public interface ConsumerService extends IService<Consumer> {
    /**
     * 保存
     * @param consumer
     * @return
     */
    @Transactional(readOnly = false)
    public boolean save(Consumer consumer);

    /**
     * 更新
     * @param consumer
     * @return
     */
    @Transactional(readOnly = false)
    public boolean update(Consumer consumer);

    /**
     * 删除
     * @param id
     * @return
     */
    @Transactional(readOnly = false)
    public boolean delete(int id);

    /**
     * 根据id获取user
     * @param id
     * @return
     */
    public Consumer get(Integer id);

    /**
     * 获取全部User 分页
     * @return
     */
    public Page<Consumer> findAllByPage(int page, int size);
    /**
     * 获取全部User
     * @return
     */
    public List<Consumer> findAll( );

    /**
     * 根据 singerId 获取 consumer
     * @param id
     * @return
     */
    public List<Consumer> getBySingerId(Integer id);
    /**
     * 根据用户名与密码登录
     * */
    public  Consumer login(Consumer consumer);

    /**
     * 根据用户名查询
     * @param consumer
     * @return
     */
    public boolean findByName(Consumer consumer);
}
