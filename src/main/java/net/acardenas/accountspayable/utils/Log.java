/*
 * ---------------------------------------------------------------------------
 *  COPYRIGHT Alejandro Cardenas, acardenas.net, Saltillo,Coah, MX 2014.
 *  All rights reserved.
 *
 *  The Copyright to the computer program(s) herein is the property of
 *  Alejandro Raul Cardenas
 *  The program(s) may be used and/or copied only with the written
 *  permission from Alejandro Cardenas, or in
 *  accordance with the terms and conditions stipulated in the
 *  agreement/contract under which the program(s) have been supplied.
 *  ---------------------------------------------------------------------------
 */

package net.acardenas.accountspayable.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/** Custom @Logger annotation **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Log
{
    // empty
}

/** LoggerPostProcessor => Custom Spring BeanPostProcessor **/
class LoggerPostProcessor implements BeanPostProcessor
{

    public Object postProcessAfterInitialization(Object bean, String beanName)
    {
        return bean;
    }

    public Object postProcessBeforeInitialization(final Object bean, String beanName)
    {
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback()
        {
            @SuppressWarnings("unchecked")
            public void doWith(Field field) throws IllegalAccessException
            {
                ReflectionUtils.makeAccessible(field);

                //Check if the field is annoted with @Log
                if (field.getAnnotation(Log.class) != null)
                {
                    field.getAnnotation(Log.class);
                    Logger logger = LoggerFactory.getLogger(bean.getClass());
                    field.set(bean, logger);
                }
            }
        });

        return bean;
    }
}