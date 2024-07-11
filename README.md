# RSQL unknown property exception when using 'RSQLCommonSupport.addMapping(..)'

see `src/test/java/com/example/demo/RSQLMappingTest.java` testcase `testSearchWithReducedPathUsingRSQLMapping`

only `AddressEntity` has property `name`... and we need to _hide_ the `history`-part in our API. 

```
2024-07-11T09:40:22.776+02:00  INFO 26697 --- [    Test worker] i.g.perplexhub.rsql.RSQLCommonSupport    : Adding entity class mapping for class com.example.demo.entity.AccountEntity, selector invoiceAddress and property addressHistory.invoiceAddress

Unknown property: name from entity com.example.demo.entity.AccountEntity
io.github.perplexhub.rsql.UnknownPropertyException: Unknown property: name from entity com.example.demo.entity.AccountEntity
	at io.github.perplexhub.rsql.RSQLJPAPredicateConverter.findPropertyPathInternal(RSQLJPAPredicateConverter.java:101)
	at io.github.perplexhub.rsql.RSQLJPAPredicateConverter.findPropertyPath(RSQLJPAPredicateConverter.java:73)
	at io.github.perplexhub.rsql.RSQLJPAPredicateConverter.resolveExpression(RSQLJPAPredicateConverter.java:235)
	at io.github.perplexhub.rsql.RSQLJPAPredicateConverter.visit(RSQLJPAPredicateConverter.java:211)
	at io.github.perplexhub.rsql.RSQLJPAPredicateConverter.visit(RSQLJPAPredicateConverter.java:24)
	at cz.jirutka.rsql.parser.ast.ComparisonNode.accept(ComparisonNode.java:67)
	at io.github.perplexhub.rsql.RSQLJPASupport.lambda$toSpecification$7eef092d$1(RSQLJPASupport.java:135)
	at org.springframework.data.jpa.repository.support.SimpleJpaRepository.applySpecificationToCriteria(SimpleJpaRepository.java:841)
	at org.springframework.data.jpa.repository.support.SimpleJpaRepository.getQuery(SimpleJpaRepository.java:760)
	at org.springframework.data.jpa.repository.support.SimpleJpaRepository.getQuery(SimpleJpaRepository.java:745)
	at org.springframework.data.jpa.repository.support.SimpleJpaRepository.findAll(SimpleJpaRepository.java:449)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:354)
	at org.springframework.data.repository.core.support.RepositoryMethodInvoker$RepositoryFragmentMethodInvoker.lambda$new$0(RepositoryMethodInvoker.java:277)
	at org.springframework.data.repository.core.support.RepositoryMethodInvoker.doInvoke(RepositoryMethodInvoker.java:170)
	at org.springframework.data.repository.core.support.RepositoryMethodInvoker.invoke(RepositoryMethodInvoker.java:158)
	at org.springframework.data.repository.core.support.RepositoryComposition$RepositoryFragments.invoke(RepositoryComposition.java:516)
	at org.springframework.data.repository.core.support.RepositoryComposition.invoke(RepositoryComposition.java:285)
	at org.springframework.data.repository.core.support.RepositoryFactorySupport$ImplementationMethodExecutionInterceptor.invoke(RepositoryFactorySupport.java:628)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.doInvoke(QueryExecutorMethodInterceptor.java:168)
	at org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.invoke(QueryExecutorMethodInterceptor.java:143)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.data.projection.DefaultMethodInvokingMethodInterceptor.invoke(DefaultMethodInvokingMethodInterceptor.java:70)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:123)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:392)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:138)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.data.jpa.repository.support.CrudMethodMetadataPostProcessor$CrudMethodMetadataPopulatingMethodInterceptor.invoke(CrudMethodMetadataPostProcessor.java:165)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:223)
	at jdk.proxy3/jdk.proxy3.$Proxy145.findAll(Unknown Source)
	at com.example.demo.RSQLMappingTest.testSearchInListWhichContainEmbeddedClassWithRSQLMapping(RSQLMappingTest.java:105)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
```
