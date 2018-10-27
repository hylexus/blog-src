package cn.hylexus.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 整个过程就是 @Around
 *
 * @author hylexus
 * createdAt 2018/3/19
 **/

@Aspect
public class MathCalculatorLogAspect {

    @Pointcut("execution(public int cn.hylexus.aop.MathCalculator.div(int,int))")
    public void pointCut() {
    }

    /**
     * 前置通知 @Before
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("method " + methodName + " started with args : " + Arrays.asList(args));
    }

    /**
     * 后置通知 @After
     */
    @After("pointCut()")
    public void logEnd() {
        System.out.println("method div end");
    }

    /**
     * 返回通知 @AfterReturning
     */
    @AfterReturning(value = "pointCut()", returning = "ret")
    public void logReturn(Object ret) {
        System.out.println("method div return,result : " + ret);
    }

    /**
     * 异常通知 @AfterThrowing
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(Throwable e) {
        System.out.println("method throws exception , errMsg is : " + e.getMessage());
    }
}
