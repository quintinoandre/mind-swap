/*package academy.mindswap.school.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        //System.out.println("-".repeat(100));
        //Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
        //System.out.println("-".repeat(100));

        Object proceed = joinPoint.proceed();

        //TeacherDto changedTeacher = (TeacherDto) proceed;

        //changedTeacher.setName("nameChanged");

        long executionTime = System.currentTimeMillis() - start;

        System.out.println("-".repeat(100));
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        System.out.println("-".repeat(100));

        return proceed;
    }
}*/
