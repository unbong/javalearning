package Week7_Mysql.homework9.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(Week7_Mysql.homework9.datasource.DataSourceType)")
    public void dataSourcePointCut()
    {

    }

    @Around("dataSourcePointCut()")
    public Object aroud(ProceedingJoinPoint point) throws Throwable {
        log.info("aroud start.");

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSourceType ds = method.getAnnotation(DataSourceType.class);
        log.info("signature name: " + signature.getName() + " method name: " + method.getName() + " DataSourceType：" + ds.toString() );
        if(ds == null)
        {
            DynamicDataSource.setDataSource(DataSourceNames.MASTER);
            log.debug("data source is " + DataSourceNames.MASTER);
        }
        else {
            DynamicDataSource.setDataSource(ds.name());
            log.debug("data source is " + ds.name());
        }

        return point.proceed();
    }
}
