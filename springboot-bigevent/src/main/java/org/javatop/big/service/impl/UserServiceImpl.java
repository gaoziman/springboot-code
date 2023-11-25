package org.javatop.big.service.impl;

import cn.hutool.core.util.ObjectUtil;
import jakarta.annotation.Resource;
import org.javatop.big.utils.JwtUtil;
import org.javatop.big.utils.Md5Util;
import org.javatop.big.utils.Result;
import org.javatop.big.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.javatop.big.mapper.UserMapper;
import org.javatop.big.pojo.User;
import org.javatop.big.service.UserService;
/**
 * @author : Leo
 * @date  2023-11-23 23:25
 * @version 1.0
 * @description :
 */

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public int updateByIdSelective(User record) {
        return userMapper.updateByIdSelective(record);
    }

    @Override
    public int updateByIdKey(User record) {
        return userMapper.updateByIdKey(record);
    }

    @Override
    public int updateBatchSelective(List<User> list) {
        return userMapper.updateBatchSelective(list);
    }


    /**
     * 注册用户
     * @param user 用户信息
     * @return 返回结果
     */
    @Override
    public Result register(User user) {
        //1.查询用户
        User queryUser = userMapper.selectByUserName(user.getUsername());
        //2.判断用户是否存在
        if (ObjectUtil.isNull(queryUser)){
            // 不存在则进行注册
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            // 3.密码加密
            user.setPassword(Md5Util.getMD5String(user.getPassword()));
            user.setEmail(user.getEmail().toLowerCase());
            user.setUsername(user.getUsername().toLowerCase());
            user.setNickname(user.getNickname().toLowerCase());
            user.setUserPic("https://gaoziman.oss-cn-hangzhou.aliyuncs.com/utools-bed/14.jpg");
            userMapper.insertSelective(user);
            return Result.success();
        }else {
            return Result.error("用户已存在");
        }
    }


    @Override
    public Result login(String username, String password) {
        //1.通过用户名查询用户
        User user = userMapper.selectByUserName(username);
        //2.判断用户是否存在以及密码是否正确
        if(ObjectUtil.isNotNull(user) && Objects.equals(Md5Util.getMD5String(password),user.getPassword()) ){
            //3.生成token
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            String token = JwtUtil.generateToken(claims);
            return Result.success(token);
        }else {
            return Result.error("用户名或密码错误");
        }
    }


    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 返回结果
     */
    @Override
    public Result updateInfo(User user) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        User queryUser = userMapper.selectById(id);
        if (ObjectUtil.isNotNull(queryUser)){
            user.setId(id);
            user.setUpdateTime(LocalDateTime.now());
            userMapper.updateByIdSelective(user);
            return Result.success("更新成功!");
        }else {
            return Result.error("用户不存在!");
        }
    }


    /**
     * 更新用户头像
     * @param url 头像地址
     * @return 返回结果
     */
    @Override
    public Result updateAvatar(String url) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateUserPicById(url,id);
        return Result.success("更新头像成功!");
    }


    @Override
    public Result updatePwd(Map<String, String> map) {
        Map<String, Object> clams = ThreadLocalUtil.get();
        Integer id = (Integer) clams.get("id");
        User user = userMapper.selectById(id);
        String oldPwd = map.get("oldPwd");
        String newPwd = map.get("newPwd");
        String rePwd = map.get("rePwd");
        // 验证这些密码的有效性
        if (ObjectUtil.isNotNull(oldPwd) && ObjectUtil.isNotNull(newPwd) && ObjectUtil.isNotNull(rePwd)){
            if (!Md5Util.getMD5String(oldPwd).equals(user.getPassword())){
                return Result.success("旧密码错误");
            }
            if (oldPwd.equals(newPwd)){
                return Result.success("新密码不能和旧密码相同");
            }
            if (!newPwd.equals(rePwd)){
                return Result.success("两次密码不一致");
            }
             userMapper.updatePasswordById(Md5Util.getMD5String(newPwd), id);
             return Result.success("密码修改成功");
        }else {
            return Result.error("必要参数填写有误!!!");
        }
    }
}
