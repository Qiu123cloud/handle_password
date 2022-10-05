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
    //��д�������ʽ
    @Pointcut("execution(boolean com.itheima.service.*Service.*(*,*))")
    private void servicePt(){}

    //�������棺��ӻ���֪ͨ
    @Around("DataAdvice.servicePt()")
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
        //��ȡԭ����������
        Object[] args=pjp.getArgs();
        for(int i =0;i<args.length;i++){
            //�жϲ����Ƿ����ַ���
            if(args[i].getClass().equals(String.class)){
                args[i]=args[i].toString().trim();
            }
        }
        //���޸ĺ�Ĳ������뵽ԭʼ������ִ����
        Object ret=pjp.proceed();
        return ret;
    }
}
