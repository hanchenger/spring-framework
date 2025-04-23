package org.springframework.example.aop.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.example.aop.service.DeleteService;
import org.springframework.example.aop.service.impl.DeleteBServiceImpl;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j(topic = "e")
public class NotVeryUsefulAspect {


	@DeclareParents(value = "org.springframework.example.aop.service.impl.UserServiceImpl", defaultImpl = DeleteBServiceImpl.class)
	public DeleteService deleteService;


	@Pointcut("execution(* org.springframework.example.aop.service..*.*(..))")
	public void pointCut() {

	}

	@Pointcut("execution(* org.springframework.example.aop.service..*.method4(..))")
	public void pointCutExecution() {

	}

	@Pointcut("within(org.springframework.example.aop.service.impl.AServiceImpl)")
	public void pointCutWithin() {

	}

	@Pointcut("args(Integer,String)")
	public void pointCutArgs() {

	}

	@Pointcut("this(org.springframework.example.aop.service.impl.AServiceImpl)")
	public void pointCutThis() {

	}

	@Pointcut("target(org.springframework.example.aop.service.impl.AServiceImpl)")
	public void pointCutTarget() {

	}

	/**
	 * 有且只有一个参数，且加了@Aop的
	 */
	@Pointcut("@args(org.springframework.example.aop.anno.Aop)")
	public void pointCutArgsAnno() {

	}

	/**
	 *
	 */
	@Pointcut("@within(org.springframework.example.aop.anno.Aop)")
	public void pointCutAnnoWithin() {

	}

	/**
	 *
	 */
	@Pointcut("@annotation(org.springframework.example.aop.anno.Aop)")
	public void pointCutAnnoAnnotation() {

	}

	@Before("pointCutAnnoAnnotation()")
	public void adviceBefore() {
		log.debug(" before aop");
	}

	//----------------------------------------------------------------------------------------------------------

	@Pointcut("within(org.springframework.example.aop.service.impl.AAopServiceImpl)")
	public void pointCutWithinAAopService() {

	}

	@Pointcut("within(org.springframework.example.aop.service.impl.BAopServiceImpl)")
	public void pointCutWithinBAopService() {

	}

	@Before("pointCutWithinAAopService()")
	public void adviceBeforeAAopService() {
		log.debug("========== before aop=============");
	}

	@After("pointCutWithinAAopService()")
	public void adviceAfterAAopService() {
		log.debug("========== after aop=============");
	}

	@AfterReturning("pointCutWithinAAopService()")
	public void adviceAfterReturningAAopService() {
		log.debug("========== afterReturning aop=============");
	}

	@Before("pointCutWithinBAopService()")
	public void adviceBeforeBAopService() {
		log.debug("========== before aop=============");
	}


}
