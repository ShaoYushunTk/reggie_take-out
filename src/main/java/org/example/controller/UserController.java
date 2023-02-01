package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.example.common.R;
import org.example.entity.User;
import org.example.service.UserService;
import org.example.utils.SMSUtils;
import org.example.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Yushun Shao
 * @date 2023/1/28 15:55
 * @description: User controller
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 发送手机验证码短信
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession httpSession){
        //获取手机号
        String phone = user.getPhone();
        if (StringUtils.isNotEmpty(phone)){
            //随机生成验证码
            String code = ValidateCodeUtils.generateValidateCode(6).toString();
            log.info("code = {}",code);
            //调用阿里云短信服务api完成发送短信
//            SMSUtils.sendMessage("阿里云短信测试","SMS_154950909",phone,code);
            SMSUtils.sendMessage("瑞吉外卖","SMS_268645997",phone,code);

            //需要将生成的验证码保存到session
//            httpSession.setAttribute(phone,code);

            //生成的验证码缓存到redis 设置有效期为5分钟
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);

            return R.success("手机验证码短信发送成功");
        }


        return R.error("发送失败");
    }

    /**
     * 移动端用户登录
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession httpSession){
        log.info(map.toString());

        //获取页面提交的手机号
        String phone = map.get("phone").toString();
        //获取页面提交的验证码
        String code = map.get("code").toString();
        //从session获取保存的验证码
//        Object codeInSession = httpSession.getAttribute(phone);
        //从redis获取验证码
        String codeInSession = (String) redisTemplate.opsForValue().get(phone);

        //验证码比对
        if (codeInSession != null && codeInSession.equals(code)){
            //比对成功，则登录成功

            //判断当前手机号对应用户是否为新用户，如果是新用户就注册
            LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(User::getPhone,phone);
            User user = userService.getOne(lambdaQueryWrapper);

            if (user == null){
                //如果是新用户就注册
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            httpSession.setAttribute("user",user.getId());

            //删除redis
            redisTemplate.delete(phone);

            return R.success(user);
        }

        return R.error("登录失败");
    }
}
