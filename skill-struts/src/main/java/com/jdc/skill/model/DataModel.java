package com.jdc.skill.model;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import com.jdc.skill.data.Entity;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target(value={FIELD, METHOD, TYPE, PARAMETER})
@Documented
public @interface DataModel {
	Class<? extends Entity> value();
}
