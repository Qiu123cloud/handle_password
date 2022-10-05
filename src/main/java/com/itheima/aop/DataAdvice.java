package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataAdvice {
    //编写切入点表达式
    @Pointcut("execution(boolean com.itheima.service.*Service.*(*,*))")
    private void servicePt(){}

    //配置切面：添加环绕通知
    @Around("DataAdvice.servicePt()")
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
        //获取原来方法参数
        Object[] args=pjp.getArgs();
        for(int i =0;i<args.length;i++){
            //判断参数是否是字符串
            if(args[i].getClass().equals(String.class)){
                args[i]=args[i].toString().trim();
            }
        }
        //将修改后的参数传入到原始方法的执行中
        Object ret=pjp.proceed();
        return ret;
    }
}
