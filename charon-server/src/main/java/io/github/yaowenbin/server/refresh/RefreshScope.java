package io.github.yaowenbin.server.refresh;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.concurrent.ConcurrentHashMap;

public class RefreshScope implements Scope, BeanFactoryPostProcessor {

    private static final String TARGET = "scopedTarget.";


    ConcurrentHashMap<String /* beanName*/, Object> cacheMap = new ConcurrentHashMap<>(16);

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        return cacheMap.computeIfAbsent(s, key -> objectFactory.getObject());
    }

    @Override
    public Object remove(String s) {
        return cacheMap.remove(TARGET + s);
    }

    public void refreshAll() {
        this.cacheMap.clear();
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "refresh";
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        factory.registerScope("refresh", new RefreshScope());
    }
}
