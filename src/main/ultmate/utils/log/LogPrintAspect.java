package utils.log;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Aspect
@Service
public class LogPrintAspect {

  /**
   * 日志工具
   */
  private static final Logger logger = LoggerFactory.getLogger(LogPrintAspect.class);
  private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
  private static final String STRING_START = ">>>>";
  private static final String STRING_END = "<<<<";

  //service.impl和controller包下面的所有类（包括子包）的方法的所有参数
  @Pointcut("execution(* service.impl..*.*(..)) || execution(* controller..*.*(..))")
  public void serviceLog() {

  }

  @Around("serviceLog()")
  public Object around(ProceedingJoinPoint joinPoint) {
    try {
      MethodSignature signature = (MethodSignature) joinPoint.getSignature();
      Method method = signature.getMethod();
      Class<?> targetClass = method.getDeclaringClass();

      StringBuffer classAndMethod = new StringBuffer();

      LogPrint classAnnotation = targetClass.getAnnotation(LogPrint.class);
      LogPrint methodAnnotation = method.getAnnotation(LogPrint.class);

      if (classAnnotation != null) {
        if (classAnnotation.ignore()) {
          return joinPoint.proceed();
        }
        classAndMethod.append(classAnnotation.value()).append("-");
      }

      if (methodAnnotation != null) {
        if (methodAnnotation.ignore()) {
          return joinPoint.proceed();
        }
        classAndMethod.append(methodAnnotation.value());
      }

      String target = targetClass.getName() + "#" + method.getName();
      String params = JSONObject.toJSONStringWithDateFormat(joinPoint.getArgs(), dateFormat,
          SerializerFeature.WriteMapNullValue);

      logger.info(STRING_START + "{} 开始调用--> {} 参数:{}", classAndMethod.toString(), target, params);

//            Long start = System.currentTimeMillis();
      Object result = joinPoint.proceed();
//            Long timeConsuming = System.currentTimeMillis() - start;

//            logger.info("\n{} 调用结束<-- {} 返回值:{} 耗时:{}ms" + STRING_END, classAndMethod.toString(), target, JSONObject.toJSONStringWithDateFormat(result, dateFormat, SerializerFeature.WriteMapNullValue), timeConsuming);
      return result;
    } catch (Throwable throwable) {
      logger.error(throwable.getMessage(), throwable);
    }
    return null;
  }
}
